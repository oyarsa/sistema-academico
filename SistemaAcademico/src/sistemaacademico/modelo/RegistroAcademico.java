package sistemaacademico.modelo;

public class RegistroAcademico {

    private String matricula;
    private String curso;
    private String periodo;

    public RegistroAcademico() {
    }

    public RegistroAcademico(String matricula, String curso, String periodo) {
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
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
