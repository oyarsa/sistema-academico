package sistemaacademico.modelo;

import java.util.HashMap;

public class TipoTrabalho {

    private int codigo;
    private String descricao;


    public TipoTrabalho(){
        
    }
    
    public TipoTrabalho(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rv = new HashMap<>();

        rv.put("codigo", codigo);
        rv.put("descricao", descricao);
        return rv;
    }

}
