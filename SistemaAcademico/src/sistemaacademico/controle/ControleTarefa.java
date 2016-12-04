package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sistemaacademico.Util.Helper;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoColaborador;
import sistemaacademico.dao.DaoTarefa;
import sistemaacademico.dao.DaoTipoTrabalho;
import sistemaacademico.modelo.Tarefa;

public class ControleTarefa {

    public static String salvar(HashMap<String, Object> dados) {
        int codigoTipoTrabalho, codigoColaborador, codigoAtividade;

        try {
            codigoTipoTrabalho = Integer.parseInt(dados.get("tipoTrabalho").toString());
        } catch (Exception ex) {
            return Mensagens.ERRO + "Tipo de Trabalho inválido";
        }

        try {
            codigoColaborador = Integer.parseInt(dados.get("responsavel").toString());
        } catch (Exception ex) {
            return Mensagens.ERRO + "Colaborador responsável inválido";
        }

        try {
            codigoAtividade = Integer.parseInt(dados.get("atividade").toString());
        } catch (Exception ex) {
            return Mensagens.ERRO + "Atividade inválida";
        }

        Tarefa t = new Tarefa();

        Date horaInicio = Helper.stringToTimeDate(dados.get("horaInicio").toString());
        if (horaInicio == null)
            return Mensagens.ERRO + "Hora de início inválida: o formato é HH:mm";

        Date horaTermino = Helper.stringToTimeDate(dados.get("horaTermino").toString());
        if (horaTermino == null)
            return Mensagens.ERRO + "Hora de término inválida: o formato é HH:mm";

        t.setHoraInicio(horaInicio);
        t.setHoraTermino(horaTermino);
        t.setObservacao((String) dados.get("observacao"));
        t.setTipo(DaoTipoTrabalho.recuperar(codigoTipoTrabalho));
        t.setResponsavel(DaoColaborador.recuperar(codigoColaborador));

        if (dados.get("codigo").equals("")) {
            String msg = DaoTarefa.inserir(t, codigoAtividade);
            dados.put("codigo", t.getCodigo());
            return msg;
        } else {
            try {
                t.setCodigo(Integer.parseInt(dados.get("codigo").toString()));
                return DaoTarefa.atualizar(t, codigoAtividade);
            } catch (Exception ex) {
                System.err.println("Erro ao atualizar uma Tarefa");
                return Mensagens.ERRO + "Código inválido";
            }
        }
    }

    public static String apagar(HashMap<String, Object> tarefa) {
        try {
            int codigo = Integer.parseInt(tarefa.get("codigo").toString());
            return DaoTarefa.remover(codigo);
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
    }

    public static HashMap<String, Object> recuperar(HashMap<String, Object> tarefa) {
        int codigo;
        try {
            codigo = Integer.parseInt(tarefa.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        Tarefa t = DaoTarefa.recuperar(codigo);
        if (t == null)
            return null;
        else {
            HashMap<String, Object> rv = t.toHashMap();
            rv.put("tipoTrabalho", t.getTipo().getCodigo());
            rv.put("responsavel", t.getResponsavel().getCodigo());
            return rv;
        }
    }

    public static ArrayList<HashMap<String, Object>> recuperarTodos(HashMap<String, Object> atividade) {
        int codigo;
        try {
            codigo = Integer.parseInt(atividade.get("codigo").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Erro ao recuperar tarefas de uma atividade");
            return null;
        }

        ArrayList<Tarefa> tarefas = DaoTarefa.recuperarTodos(codigo);
        ArrayList<HashMap<String, Object>> rv = new ArrayList<>();

        for (Tarefa t : tarefas) {
            HashMap<String, Object> map = t.toHashMap();
            map.put("tipoTrabalho", t.getTipo().getCodigo());
            map.put("responsavel", t.getResponsavel().getCodigo());
            rv.add(map);
        }
        return rv;
    }

}
