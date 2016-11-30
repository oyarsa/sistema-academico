package sistemaacademico.modelo;

public class RegistroAcademico {
    
    private int codigo;
    private String matricula;
    private String curso;
    private String periodo;
    private Colaborador colaborador;

    public RegistroAcademico() {
    }

    public RegistroAcademico(int codigo, String matricula, String curso, String periodo, 
            Colaborador colaborador) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.colaborador = colaborador;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
