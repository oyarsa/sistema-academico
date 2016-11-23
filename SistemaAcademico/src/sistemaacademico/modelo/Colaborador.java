package sistemaacademico.modelo;

import java.util.ArrayList;

public class Colaborador {

    private int codigo;
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
    private ArrayList<Estado> historico;
    private ArrayList<Projeto> projetosGerenciados;

    public Colaborador() {
    }

    public Colaborador(int codigo, String nome, String cpf, String rg, boolean ativo,
            String email, String nomeMae, String nomePai, String categoria,
            String login, String senha, Telefone telefone,
            RegistroAcademico registroAcad, ArrayList<Projeto> projetos,
            ArrayList<Estado> historico, ArrayList<Projeto> projetosGerenciados) {
        this.codigo = codigo;
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
        this.historico = historico;
        this.projetosGerenciados = projetosGerenciados;
    }

    public ArrayList<Projeto> getProjetosGerenciados() {
        return projetosGerenciados;
    }

    public void setProjetosGerenciados(ArrayList<Projeto> projetosGerenciados) {
        this.projetosGerenciados = projetosGerenciados;
    }

    public long calculaHorasTrabalhadas(Projeto p) {
        long tempoTrabalho = 0;

        ArrayList<Atividade> atividades = p.getAtividades();

        for (Atividade a : atividades) {
            ArrayList<Tarefa> tarefas = a.getTarefas();

            for (Tarefa t : tarefas) {
                if (t.getResponsavel().getCodigo() == this.codigo) {
                    long inicio = t.getHoraInicio().getTime();
                    long fim = t.getHoraTermino().getTime();
                    tempoTrabalho += fim - inicio;
                }
            }
        }

        return tempoTrabalho;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public ArrayList<Estado> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Estado> historico) {
        this.historico = historico;
    }

}
