package sistemaacademico.modelo;

import java.util.ArrayList;

public class Colaborador {

    private String nome;
    private String cpf;
    private String rg;
    private boolean ativo;
    private String email;
    private String nomeMae;
    private String nomePai;
    private String categoria;
    private String login;
    private String senha;
    private Telefone telefone;
    private RegistroAcademico registroAcad;
    private ArrayList<Projeto> projetos;

    public Colaborador() {
    }

    public Colaborador(String nome, String cpf, String rg, boolean ativo,
            String email, String nomeMae, String nomePai, String categoria,
            String login, String senha, Telefone telefone,
            RegistroAcademico registroAcad, ArrayList<Projeto> projetos) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.ativo = ativo;
        this.email = email;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.categoria = categoria;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.registroAcad = registroAcad;
        this.projetos = projetos;
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }

    public RegistroAcademico getRegistroAcad() {
        return registroAcad;
    }

    public void setRegistroAcad(RegistroAcademico registroAcad) {
        this.registroAcad = registroAcad;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}