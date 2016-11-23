package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.HashMap;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoColaborador;
import sistemaacademico.modelo.Colaborador;

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
        int codigo = (Integer) dados.get("codigo");
        return DaoColaborador.remover(codigo);
    }

    public static HashMap<String, Object> carregarColaborador(HashMap<String, Object> dados) {
        int codigo = (Integer) dados.get("codigo");

        Colaborador c = DaoColaborador.recuperar(codigo);
        if (c == null)
            return null;
        else
            return c.toHashMap();
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
            if (msg.equals(Mensagens.SUCESSO) && (Boolean) dados.get("academico")) {
                // salvar RegistroAcademico
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

}
