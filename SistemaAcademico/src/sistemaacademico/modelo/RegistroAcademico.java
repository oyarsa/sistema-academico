package sistemaacademico.modelo;

public class RegistroAcademico {

    private int codigo;
    private String matricula;
    private String curso;
    private String periodo;

    public RegistroAcademico() {
    }

    public RegistroAcademico(int codigo, String matricula, String curso, String periodo) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
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
