package sistemaacademico.modelo;

public class TipoTrabalho {

    private int codigo;
    private String descricao;

    public TipoTrabalho() {
    }

    public TipoTrabalho(int codigo, String descricao) {
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

}
