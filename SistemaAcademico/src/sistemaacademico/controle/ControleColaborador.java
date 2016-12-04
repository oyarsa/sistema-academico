package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sistemaacademico.Util.Helper;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoColaborador;
import sistemaacademico.dao.DaoColaboradorProjeto;
import sistemaacademico.dao.DaoProjeto;
import sistemaacademico.dao.DaoRegistroAcademico;
import sistemaacademico.modelo.Colaborador;
import sistemaacademico.modelo.Estado;
import sistemaacademico.modelo.Projeto;
import sistemaacademico.modelo.RegistroAcademico;
import sistemaacademico.modelo.Telefone;

public class ControleColaborador {

    public static ArrayList<HashMap<String, Object>> recuperarTodos() {
        ArrayList<Colaborador> colaboradores = DaoColaborador.recuperarTodos();
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Colaborador c : colaboradores) {
            c.setRegistroAcad(DaoRegistroAcademico.recuperar(c.getCodigo()));
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
            HashMap<String, Object> rv = c.toHashMap();
            RegistroAcademico r = DaoRegistroAcademico.recuperar(codigo);
            if (r != null) {
                rv.put("academico", true);
                rv.put("cursoAcademico", r.getCurso());
                rv.put("matriculaAcademico", r.getMatricula());
                rv.put("periodoAcademico", r.getPeriodo());
            } else {
                rv.put("academico", false);
                rv.put("cursoAcademico", "");
                rv.put("matriculaAcademico", "");
                rv.put("periodoAcademico", "");
            }
            return rv;
        }
    }

    public static String salvar(HashMap<String, Object> dados) {
        String cpf = dados.get("cpf").toString();
        if (cpf.length() != 11) {
            return Mensagens.ERRO + "Tamanho do CPF inválido. Deve possuir 11 caracteres";
        }

        String rg = dados.get("rg").toString();
        if (rg.length() != 12) {
            return Mensagens.ERRO + "Tamanho do RG inválido. Deve possuir 12 caracteres";
        }

        Colaborador c = new Colaborador();

        c.setCpf(cpf);
        c.setCategoria(dados.get("categoria").toString());
        c.setEmail(dados.get("email").toString());
        c.setNome(dados.get("nome").toString());
        c.setNomePai(dados.get("nomePai").toString());
        c.setNomeMae(dados.get("nomeMae").toString());
        c.setRg(rg);
        c.setAtivo((Boolean) dados.get("ativo"));

        String sCodigo = dados.get("codigo").toString();
        if (sCodigo.equals("")) {
            String msg = DaoColaborador.inserir(c);
            if (msg.equals(Mensagens.SUCESSO)) {
                dados.put("codigo", c.getCodigo());
                msg = salvarAcademico(c, dados);
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
            String msg = DaoColaborador.atualizar(c);
            if (msg.equals(Mensagens.SUCESSO)) {
                dados.put("codigo", c.getCodigo());
                msg = salvarAcademico(c, dados);
            }
            return msg;
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
        String ddd = dados.get("ddd").toString();
        if (ddd.length() > 3)
            return Mensagens.ERRO + "Tamanho inválido para o DDD (máx. 3 caracteres)";
        if (!Helper.isInteiro(ddd))
            return Mensagens.ERRO + "DDD deve ser um número";

        String ddi = dados.get("ddi").toString();
        if (ddi.length() > 3)
            return Mensagens.ERRO + "Tamanho inválido para o DDI (máx. 3 caracteres)";
        if (!Helper.isInteiro(ddi))
            return Mensagens.ERRO + "DDI deve ser um número";

        String numero = dados.get("numero").toString();
        if (numero.length() > 9)
            return Mensagens.ERRO + "Tamanho inválido para o Número (máx. 9 caracteres)";
        if (!Helper.isInteiro(numero))
            return Mensagens.ERRO + "Número do telefone deve ser um número";

        int codigoColaborador;
        try {
            codigoColaborador = Integer.parseInt(dados.get("colaborador").toString());
        } catch (Exception ex) {
            return Mensagens.ERRO + "Colaborador inválido";
        }
        sistemaacademico.modelo.Telefone t = new Telefone();

        t.setDdd(ddd);
        t.setDdi(ddi);
        t.setNumero(numero);
        t.setOperadora(dados.get("operadora").toString());

        String sCodigo = dados.get("codigo").toString();
        if (sCodigo.equals("")) {
            String msg = sistemaacademico.dao.DaoTelefone.inserir(t, codigoColaborador);
            if (msg.equals(Mensagens.SUCESSO)) {
                dados.put("codigo", t.getCodigo());
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

    //CODIGO PARA HISTÓRICO
    public static String removerEstado(HashMap<String, Object> dados) {
        try {
            int codigo = Integer.parseInt(dados.get("codigo").toString());
            return sistemaacademico.dao.DaoEstado.remover(codigo);
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
    }

    public static HashMap<String, Object> carregarEstado(HashMap<String, Object> dados) {
        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        sistemaacademico.modelo.Estado e = sistemaacademico.dao.DaoEstado.recuperar(codigo);
        if (e == null) {
            return null;
        } else {
            HashMap<String, Object> rv = e.toHashMap();
            converteDatasEstado(rv);
            return rv;
        }
    }

    public static String salvarEstado(HashMap<String, Object> dados) {
        int codigoColaborador;
        try {
            codigoColaborador = Integer.parseInt(dados.get("colaborador").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Mensagens.ERRO + "Colaborador inválido";
        }
        sistemaacademico.modelo.Estado e = new Estado();

        e.setNome(dados.get("nome").toString());
        e.setDataInicio(Helper.stringToDate(dados.get("dataIni").toString()));
        e.setDataTermino(Helper.stringToDate(dados.get("dataTerm").toString()));

        String sCodigo = dados.get("codigo").toString();
        if (sCodigo.equals("")) {
            String msg = sistemaacademico.dao.DaoEstado.inserir(e, codigoColaborador);
            if (msg.equals(Mensagens.SUCESSO)) {
                dados.put("codigo", e.getCodigo());
            }
            return msg;
        } else {
            int codigo;
            try {
                codigo = Integer.parseInt(sCodigo);
            } catch (NumberFormatException ex) {
                return Mensagens.ERRO + ex;
            }

            e.setCodigo(codigo);
            return sistemaacademico.dao.DaoEstado.atualizar(e);
        }

    }

    public static ArrayList<HashMap<String, Object>> carregarEstados(HashMap<String, Object> dados) {
        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigo").toString());
        } catch (NumberFormatException ex) {
            return null;
        }

        ArrayList<sistemaacademico.modelo.Estado> estados
                = sistemaacademico.dao.DaoEstado.recuperarTodos(codigo);
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Estado e : estados) {
            HashMap<String, Object> map = e.toHashMap();
            converteDatasEstado(map);
            result.add(map);
        }

        return result;
    }

    private static void converteDatasEstado(HashMap<String, Object> dados) {
        Date dataIni = (Date) dados.get("dataIni");
        dados.remove("dataIni");
        dados.put("dataIni", Helper.dateToString(dataIni));

        Date dataTerm = (Date) dados.get("dataTerm");
        dados.remove("dataTerm");
        dados.put("dataTerm", Helper.dateToString(dataTerm));
    }

    private static String salvarAcademico(Colaborador c, HashMap<String, Object> dados) {
        RegistroAcademico r = DaoRegistroAcademico.recuperar(c.getCodigo());
        boolean antes = r != null;
        boolean depois = (Boolean) dados.get("academico");

        if (r == null) {
            r = new RegistroAcademico();
        }

        r.setColaborador(c);
        r.setCurso(dados.get("cursoAcademico").toString());
        r.setMatricula(dados.get("matriculaAcademico").toString());
        r.setPeriodo(dados.get("periodoAcademico").toString());

        if (antes && depois) {
            return DaoRegistroAcademico.atualizar(r);
        } else if (!antes && depois) {
            return DaoRegistroAcademico.inserir(r);
        } else if (antes && !depois) {
            return DaoRegistroAcademico.remover(c.getCodigo());
        } else {
            return Mensagens.SUCESSO;
        }
    }
}
