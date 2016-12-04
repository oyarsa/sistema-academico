package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.HashMap;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoColaborador;
import sistemaacademico.dao.DaoColaboradorProjeto;
import sistemaacademico.dao.DaoProjeto;
import sistemaacademico.modelo.Colaborador;
import sistemaacademico.modelo.Projeto;

public class ControleProjeto {

    public static HashMap<String, Object> recuperar(int codigoProjeto) {
        Projeto p = DaoProjeto.recuperar(codigoProjeto);

        if (p == null)
            return null;
        else
            return p.toHashMap();
    }

    public static String salvar(HashMap<String, Object> dados) {
        Projeto p = new Projeto();
        p.setNome(dados.get("nome").toString());
        p.setObjetivo(dados.get("objetivo").toString());
        p.setRecursos(dados.get("recursos").toString());

        try {
            p.setGerente(DaoColaborador.recuperar(
                    Integer.parseInt(dados.get("codigoGerente").toString())));
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Gerente inválido";
        }

        if (!dados.containsKey("codigo")) {
            String msg = DaoProjeto.inserir(p);
            dados.put("codigo", p.getCodigo());
            return msg;
        } else {
            try {
                p.setCodigo(Integer.parseInt(dados.get("codigo").toString()));
                return DaoProjeto.atualizar(p);
            } catch (Exception ex) {
                ex.printStackTrace();
                return Mensagens.ERRO + "Código inválido";
            }
        }
    }

    public static String apagar(HashMap<String, Object> dados) {
        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigo").toString());
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
        return DaoProjeto.remover(codigo);
    }

    public static String removerColaborador(HashMap<String, Object> dados) {
        int codigoProjeto, codigoColaborador;

        try {
            codigoProjeto = Integer.parseInt(dados.get("codigoProjeto").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Erro ao recuperar código do projeto";
        }

        try {
            codigoColaborador = Integer.parseInt(dados.get("codigoColaborador").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Erro ao recuperar código do colaborador";
        }

        return DaoColaboradorProjeto.remover(codigoProjeto, codigoColaborador);
    }

    public static String adicionarColaborador(HashMap<String, Object> dadosColab) {
        int codigoProjeto, codigoColaborador;

        try {
            codigoProjeto = Integer.parseInt(dadosColab.get("codigoProjeto").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Erro ao recuperar código do projeto";
        }

        try {
            codigoColaborador = Integer.parseInt(dadosColab.get("codigoColaborador").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Erro ao recuperar código do colaborador";
        }

        return DaoColaboradorProjeto.inserir(codigoProjeto, codigoColaborador);
    }

    public static ArrayList<HashMap<String, Object>> recuperarColaboradores(HashMap<String, Object> dados) {
        int codigoProjeto;
        try {
            codigoProjeto = Integer.parseInt(dados.get("codigo").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        ArrayList<Colaborador> colaboradores = DaoColaboradorProjeto.recuperarColabadores(codigoProjeto);
        ArrayList<HashMap<String, Object>> rv = new ArrayList<>();

        for (Colaborador c : colaboradores) {
            rv.add(c.toHashMap());
        }

        return rv;
    }

}
