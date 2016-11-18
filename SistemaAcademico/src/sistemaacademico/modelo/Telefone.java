package sistemaacademico.modelo;

public class Telefone {

    private String ddi;
    private String ddd;
    private String numero;
    private String operadora;

    public Telefone() {
    }

    public Telefone(String ddi, String ddd, String numero, String operadora) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
        this.operadora = operadora;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

}
