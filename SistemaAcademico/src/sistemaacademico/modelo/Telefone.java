package sistemaacademico.modelo;

import java.util.HashMap;

public class Telefone {

    private int codigo;
    private String ddi;
    private String ddd;
    private String numero;
    private String operadora;

    public Telefone() {
    }

    public Telefone(int codigo, String ddi, String ddd, String numero, String operadora) {
        this.codigo = codigo;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
        this.operadora = operadora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
    
      public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rv = new HashMap<>();

        rv.put("codigo", codigo);
        rv.put("ddd", ddd);
        rv.put("ddi", ddi);
        rv.put("numero", numero);
        rv.put("operadora", operadora);

        return rv;
    }

}
