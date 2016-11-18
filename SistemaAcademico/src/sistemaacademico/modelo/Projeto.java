package sistemaacademico.modelo;

import java.util.ArrayList;

public class Projeto {

    private String nome;
    private String objetivo;
    private String recursos;
    private ArrayList<Colaborador> colaboradores;

    public Projeto() {
    }

    public Projeto(String nome, String objetivo, String recursos,
            ArrayList<Colaborador> colaboradores) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.recursos = recursos;
        this.colaboradores = colaboradores;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

}
