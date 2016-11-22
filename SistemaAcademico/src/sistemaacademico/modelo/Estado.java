package sistemaacademico.modelo;

import java.util.Date;

public class Estado {

    private String nome;
    private Date dataInicio;
    private Date dataTermino;

    public Estado() {
    }

    public Estado(String nome, Date dataInicio, Date dataTermino) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
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

}
