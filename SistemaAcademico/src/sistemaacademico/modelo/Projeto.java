package sistemaacademico.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Projeto {

    private int codigo;
    private String nome;
    private String objetivo;
    private String recursos;
    private ArrayList<Colaborador> colaboradores;
    private ArrayList<Atividade> atividades;
    private Colaborador gerente;

    public Projeto() {
    }

    public Projeto(int codigo, String nome, String objetivo, String recursos,
            ArrayList<Colaborador> colaboradores,
            ArrayList<Atividade> atividades, Colaborador gerente) {
        this.codigo = codigo;
        this.nome = nome;
        this.objetivo = objetivo;
        this.recursos = recursos;
        this.colaboradores = colaboradores;
        this.atividades = atividades;
        this.gerente = gerente;
    }

    public Colaborador getGerente() {
        return gerente;
    }

    public void setGerente(Colaborador gerente) {
        this.gerente = gerente;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rv = new HashMap<>();

        rv.put("codigo", codigo);
        rv.put("nome", nome);
        rv.put("objetivo", objetivo);
        rv.put("recursos", recursos);
        rv.put("codigoGerente", gerente.getCodigo());

        return rv;
    }

}
