package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sistemaacademico.Util.Helper;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoAtividade;
import sistemaacademico.modelo.Atividade;

public class ControleAtividade {

    public static String salvar(HashMap<String, Object> dados) {
        Date dataInicio = Helper.stringToDate(dados.get("dataInicio").toString());
        if (dataInicio == null)
            return Mensagens.ERRO + "Data de início inválida. Formato: dd/MM/yyyy";

        Date dataTermino = Helper.stringToDate(dados.get("dataFim").toString());
        if (dataTermino == null)
            return Mensagens.ERRO + "Data de término inválida. Formato: dd/MM/yyyy";

        Date duracaoEstimada = Helper.stringToDate(dados.get("duracaoEstimada").toString());
        if (duracaoEstimada == null)
            return Mensagens.ERRO + "Duração estimada inválida. Formato: dd/MM/yyyy";

        int codigoProjeto;
        try {
            codigoProjeto = Integer.parseInt(dados.get("codigoProjeto").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Projeto inválido";
        }

        Atividade a = new Atividade();

        a.setTitulo(dados.get("titulo").toString());
        a.setDataInicio(dataInicio);
        a.setDataTermino(dataTermino);
        a.setDuracaoEstimada(duracaoEstimada);

        if (dados.get("codigo").equals("")) {
            String msg = DaoAtividade.inserir(a, codigoProjeto);
            dados.put("codigo", a.getCodigo());
            return msg;
        } else {
            try {
                a.setCodigo(Integer.parseInt(dados.get("codigo").toString()));
                return DaoAtividade.atualizar(a);
            } catch (Exception ex) {
                System.err.println("Erro ao atualizar uma Atividade");
                return Mensagens.ERRO + "Código inválido";
            }
        }
    }

    public static String apagar(HashMap<String, Object> ativ) {
        try {
            int codigo = Integer.parseInt(ativ.get("codigo").toString());
            return DaoAtividade.remover(codigo);
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
    }

    public static HashMap<String, Object> recuperar(HashMap<String, Object> ativ) {
        int codigo;
        try {
            codigo = Integer.parseInt(ativ.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        Atividade a = DaoAtividade.recuperar(codigo);
        if (a == null)
            return null;
        else {
            HashMap<String, Object> rv = a.toHashMap();
            converteDatas(rv);
            return rv;
        }
    }

    private static void converteDatas(HashMap<String, Object> dados) {
        Date dataInicio = (Date) dados.get("dataInicio");
        dados.remove("dataInicio");
        dados.put("dataInicio", Helper.dateToString(dataInicio));

        Date dataFim = (Date) dados.get("dataFim");
        dados.remove("dataFim");
        dados.put("dataFim", Helper.dateToString(dataFim));

        Date duracaoEstimada = (Date) dados.get("duracaoEstimada");
        dados.remove("duracaoEstimada");
        dados.put("duracaoEstimada", Helper.dateToString(duracaoEstimada));
    }

    public static ArrayList<HashMap<String, Object>> recuperarTodos(HashMap<String, Object> dados) {
        int codigoProjeto;
        try {
            codigoProjeto = Integer.parseInt(dados.get("codigo").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        ArrayList<Atividade> atividades = DaoAtividade.recuperarTodos(codigoProjeto);
        ArrayList<HashMap<String, Object>> rv = new ArrayList<>();

        for (Atividade a : atividades) {
            HashMap<String, Object> map = a.toHashMap();
            converteDatas(map);
            rv.add(map);
        }
        return rv;
    }

    public static ArrayList<HashMap<String, Object>> recuperarDependencias(HashMap<String, Object> ativ) {
        int codigo;
        try {
            codigo = Integer.parseInt(ativ.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        ArrayList<Atividade> dependencias = DaoAtividade.carregarDependencias(codigo);
        ArrayList<HashMap<String, Object>> rv = new ArrayList<>();

        for (Atividade a : dependencias) {
            rv.add(a.toHashMap());
        }
        return rv;
    }

}
