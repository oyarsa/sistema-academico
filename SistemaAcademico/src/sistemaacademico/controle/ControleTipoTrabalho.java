package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.HashMap;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.dao.DaoTipoTrabalho;
import sistemaacademico.modelo.TipoTrabalho;


public class ControleTipoTrabalho {
    public static String salvar(HashMap<String, Object> dados) {
        TipoTrabalho t = new TipoTrabalho();

        t.setDescricao(dados.get("descricao").toString());


        if (dados.get("codigo").equals("")) {
            String msg = DaoTipoTrabalho.inserir(t);
            dados.put("codigo", t.getCodigo());
            return msg;
        } else {
            try {
                t.setCodigo(Integer.parseInt(dados.get("codigo").toString()));
                return DaoTipoTrabalho.atualizar(t);
            } catch (Exception ex) {
                System.err.println("Erro ao atualizar uma Atividade");
                return Mensagens.ERRO + "Código inválido";
            }
        }
    }
 
   public static String apagar(HashMap<String, Object> tipotrab) {
        try {
            int codigo = Integer.parseInt(tipotrab.get("codigo").toString());
            return DaoTipoTrabalho.remover(codigo);
        } catch (Exception ex) {
            return Mensagens.ERRO + "Código inválido";
        }
    }

    public static HashMap<String, Object> recuperar(HashMap<String, Object> tipotrab) {
        int codigo;
        try {
            codigo = Integer.parseInt(tipotrab.get("codigo").toString());
        } catch (Exception ex) {
            return null;
        }

        TipoTrabalho t = DaoTipoTrabalho.recuperar(codigo);
        if (t == null)
            return null;
        else {
            HashMap<String, Object> rv = t.toHashMap();
            return rv;
        }
    }


    public static ArrayList<HashMap<String, Object>> recuperarTodos() {
        ArrayList<TipoTrabalho> tipotrabalho = DaoTipoTrabalho.recuperarTodos();
        ArrayList<HashMap<String, Object>> rv = new ArrayList<>();

        for (TipoTrabalho t : tipotrabalho) {
            HashMap<String, Object> map = t.toHashMap();
            rv.add(map);
        }
        return rv;
    }
    
}
