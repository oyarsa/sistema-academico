package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoTarefa;
import sistemaacademico.modelo.Colaborador;
import sistemaacademico.modelo.Tarefa;
import sistemaacademico.modelo.TipoTrabalho;


public class ControleTarefa {
    public static String salvar(HashMap<String, Object> dados) {
        Tarefa t = new Tarefa();

        t.setHoraInicio((Date) dados.get("horaInicio"));
        t.setHoraTermino((Date) dados.get("horaTermino"));
        t.setObservacao((String) dados.get("observacao"));
        t.setTipo((TipoTrabalho) dados.get("tipoTrabalho"));
        t.setResponsavel((Colaborador) dados.get("colaborador"));

        if (dados.get("codigo").equals("")) {
            String msg = DaoTarefa.inserir(t);
            dados.put("codigo", t.getCodigo());
            return msg;
        } else {
            try {
                t.setCodigo(Integer.parseInt(dados.get("codigo").toString()));
                return DaoTarefa.atualizar(t);
            } catch (Exception ex) {
                System.err.println("Erro ao atualizar uma Atividade");
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
            return rv;
        }
    }


    public static ArrayList<HashMap<String, Object>> recuperarTodos() {
        ArrayList<Tarefa> tarefas = DaoTarefa.recuperarTodos();
        ArrayList<HashMap<String, Object>> rv = new ArrayList<>();

        for (Tarefa t : tarefas) {
            HashMap<String, Object> map = t.toHashMap();
            rv.add(map);
        }
        return rv;
    }

}
