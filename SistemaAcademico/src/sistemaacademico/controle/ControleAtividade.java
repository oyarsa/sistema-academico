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
        Atividade a = new Atividade();

        a.setTitulo(dados.get("titulo").toString());
        a.setDataInicio(Helper.stringToDate(dados.get("dataInicio").toString()));
        a.setDataTermino(Helper.stringToDate(dados.get("dataFim").toString()));
        a.setDuracaoEstimada(Helper.stringToDate(dados.get("duracaoEstimada").toString()));

        if (dados.get("codigo").equals("")) {
            String msg = DaoAtividade.inserir(a);
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
        dados.put("dataIncio", Helper.dateToString((Date) dados.get("dataInicio")));
        dados.put("dataFim", Helper.dateToString((Date) dados.get("dataFim")));
        dados.put("duracaoEstimada", Helper.dateToString((Date) dados.get("duracaoEstimada")));
    }

    public static ArrayList<HashMap<String, Object>> recuperarTodos() {
        ArrayList<Atividade> atividades = DaoAtividade.recuperarTodos();
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
