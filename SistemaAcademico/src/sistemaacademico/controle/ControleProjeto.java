package sistemaacademico.controle;

import java.util.HashMap;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoProjeto;
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

        if (!dados.containsKey("codigo")) {
            String msg = DaoProjeto.inserir(p);
            dados.put("codigo", p.getCodigo());
            return msg;
        } else {
            try {
                p.setCodigo(Integer.parseInt(dados.get("codigo").toString()));
                return DaoProjeto.atualizar(p);
            } catch (Exception ex) {
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

}
