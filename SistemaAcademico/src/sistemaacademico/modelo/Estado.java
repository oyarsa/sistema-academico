package sistemaacademico.modelo;

import java.util.Date;
import java.util.HashMap;

public class Estado {

    private int codigo;
    private String nome;
    private Date dataInicio;
    private Date dataTermino;

    public Estado() {
    }

    public Estado(int codigo, String nome, Date dataInicio, Date dataTermino) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    
        public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rv = new HashMap<>();

        rv.put("codigo", codigo);
        rv.put("nome", nome);
        rv.put("dataIni", dataInicio);
        rv.put("dataTerm", dataTermino);

        return rv;
    }

}
