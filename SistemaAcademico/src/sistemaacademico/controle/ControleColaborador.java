package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.HashMap;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoColaborador;
import sistemaacademico.dao.DaoColaboradorProjeto;
import sistemaacademico.dao.DaoProjeto;
import sistemaacademico.modelo.Colaborador;
import sistemaacademico.modelo.Projeto;
import sistemaacademico.modelo.Telefone;

public class ControleColaborador {

    public static ArrayList<HashMap<String, Object>> recuperarTodos() {
        ArrayList<Colaborador> colaboradores = DaoColaborador.recuperarTodos();
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Colaborador c : colaboradores) {
            result.add(c.toHashMap());
        }

        return result;
    }

    public static String remover(HashMap<String, Object> dados) {
        try {
            int codigo = Integer.parseInt(dados.get("codigo").toString());
            return DaoColaborador.remover(codigo);
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
    }

    public static HashMap<String, Object> carregarColaborador(HashMap<String, Object> dados) {
        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        Colaborador c = DaoColaborador.recuperar(codigo);
        if (c == null) {
            return null;
        } else {
            return c.toHashMap();
        }
    }

    public static String salvar(HashMap<String, Object> dados) {
        Colaborador c = new Colaborador();

        c.setCpf(dados.get("cpf").toString());
        c.setCategoria(dados.get("categoria").toString());
        c.setEmail(dados.get("email").toString());
        c.setNome(dados.get("nome").toString());
        c.setNomePai(dados.get("nomePai").toString());
        c.setNomeMae(dados.get("nomeMae").toString());
        c.setRg(dados.get("rg").toString());
        c.setAtivo((Boolean) dados.get("ativo"));

        String sCodigo = dados.get("codigo").toString();
        if (sCodigo.equals("")) {
            String msg = DaoColaborador.inserir(c);
            if (msg.equals(Mensagens.SUCESSO)) {
                dados.put("codigo", c.getCodigo());
                if ((Boolean) dados.get("academico")) {
                    // salvar RegistroAcademico
                }
            }
            return msg;
        } else {
            int codigo;
            try {
                codigo = Integer.parseInt(sCodigo);
            } catch (NumberFormatException ex) {
                return Mensagens.ERRO + ex;
            }

            c.setCodigo(codigo);
            return DaoColaborador.atualizar(c);
        }

    }

    public static ArrayList<HashMap<String, Object>> carregarProjetos(HashMap<String, Object> dados) {
        ArrayList<Projeto> projetos
                = DaoColaboradorProjeto.recuperarProjetos(
                        Integer.parseInt(dados.get("codigo").toString()));
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Projeto p : projetos) {
            result.add(p.toHashMap());
        }

        return result;
    }

    public static ArrayList<HashMap<String, Object>> carregarProjetosGerenciados(
            HashMap<String, Object> dados) {

        ArrayList<Projeto> projetos
                = DaoProjeto.recuperarProjetosDoGerente(
                        Integer.parseInt(dados.get("codigo").toString()));
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Projeto p : projetos) {
            result.add(p.toHashMap());
        }

        return result;
    }

    // CÓDIGO PARA TELEFONE

    public static String removerTelefone(HashMap<String, Object> dados) {
        try {
            int codigo = Integer.parseInt(dados.get("codigo").toString());
            return sistemaacademico.dao.DaoTelefone.remover(codigo);
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
    }

    public static HashMap<String, Object> carregarTelefone(HashMap<String, Object> dados) {
        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        Telefone t = sistemaacademico.dao.DaoTelefone.recuperar(codigo);
        if (t == null) {
            return null;
        } else {
            return t.toHashMap();
        }
    }

    public static String salvarTelefone(HashMap<String, Object> dados) {
        sistemaacademico.modelo.Telefone t = new Telefone();

        t.setDdd(dados.get("ddd").toString());
        t.setDdi(dados.get("ddi").toString());
        t.setNumero(dados.get("numero").toString());
        t.setOperadora(dados.get("operadora").toString());

        String sCodigo = dados.get("codigo").toString();
        if (sCodigo.equals("")) {
            String msg = sistemaacademico.dao.DaoTelefone.inserir(t, t.getCodigo());
            if (msg.equals(Mensagens.SUCESSO)) {
                dados.put("codigo", t.getCodigo());
                if ((Boolean) dados.get("academico")) {
                    // salvar RegistroAcademico
                }
            }
            return msg;
        } else {
            int codigo;
            try {
                codigo = Integer.parseInt(sCodigo);
            } catch (NumberFormatException ex) {
                return Mensagens.ERRO + ex;
            }

            t.setCodigo(codigo);
            return sistemaacademico.dao.DaoTelefone.atualizar(t);
        }

    }

    public static ArrayList<HashMap<String, Object>> carregarTelefones(HashMap<String, Object> dados) {
        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigo").toString());
        } catch (NumberFormatException ex) {
            return null;
        }

        ArrayList<Telefone> telefones
                = sistemaacademico.dao.DaoTelefone.recuperarTodos(codigo);
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Telefone t : telefones) {
            result.add(t.toHashMap());
        }

        return result;
    }

}
