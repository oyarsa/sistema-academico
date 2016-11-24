package sistemaacademico.controle;

import java.util.HashMap;
import sistemaacademico.dao.DaoProjeto;
import sistemaacademico.modelo.Projeto;

public class ControleProjeto {

    public static HashMap<String, Object> recuperar(int codigoProjeto) {
        HashMap<String, Object> dados = new HashMap<>();
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
            return DaoProjeto.inserir(p);
        } else {
            p.setCodigo((Integer) dados.get("codigo"));
            return DaoProjeto.atualizar(p);
        }
    }

    public static String apagar(HashMap<String, Object> dados) {
        return DaoProjeto.remover((Integer) dados.get("codigo"));
    }

}
