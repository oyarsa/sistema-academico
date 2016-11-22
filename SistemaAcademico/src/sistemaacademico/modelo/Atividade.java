package sistemaacademico.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Atividade {

    private int codigo;
    private Date dataInicio;
    private Date dataTermino;
    private Date duracaoEstimada;
    private ArrayList<Atividade> dependencias;

    public Atividade() {
    }

    public Atividade(int codigo, Date dataInicio, Date dataTermino, Date duracaoEstimada,
            ArrayList<Atividade> dependencias) {
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.duracaoEstimada = duracaoEstimada;
        this.dependencias = dependencias;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Atividade> getDependencias() {
        return dependencias;
    }

    public void setDependencias(ArrayList<Atividade> dependencias) {
        this.dependencias = dependencias;
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

    public Date getDuracaoEstimada() {
        return duracaoEstimada;
    }

    public void setDuracaoEstimada(Date duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }

}
