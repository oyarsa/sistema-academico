package sistemaacademico.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Atividade {

    private int codigo;
    private String titulo;
    private Date dataInicio;
    private Date dataTermino;
    private Date duracaoEstimada;
    private ArrayList<Atividade> dependencias;
    private ArrayList<Tarefa> tarefas;

    public Atividade() {
    }

    public Atividade(int codigo, String titulo, Date dataInicio, Date dataTermino, Date duracaoEstimada,
            ArrayList<Atividade> dependencias, ArrayList<Tarefa> tarefas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.duracaoEstimada = duracaoEstimada;
        this.dependencias = dependencias;
        this.tarefas = tarefas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
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

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rv = new HashMap<>();

        rv.put("codigo", codigo);
        rv.put("titulo", titulo);
        rv.put("dataInicio", dataTermino);
        rv.put("duracaoEstimada", duracaoEstimada);

        return rv;
    }

}
