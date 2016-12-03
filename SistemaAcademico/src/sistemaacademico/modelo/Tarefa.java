package sistemaacademico.modelo;

import java.util.Date;
import java.util.HashMap;

public class Tarefa {

    private int codigo;
    private String descricao;
    private Date horaInicio;
    private Date horaTermino;
    private String observacao;
    private TipoTrabalho tipo;
    private Colaborador responsavel;
    private Atividade atividadeOrigem;

    public Tarefa() {
    }

    public Tarefa(int codigo, String descricao, Date horaInicio, Date horaTermino,
            String observacao, TipoTrabalho tipo, Colaborador responsavel,
            Atividade atividadeOrigem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.observacao = observacao;
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.atividadeOrigem = atividadeOrigem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Colaborador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Colaborador responsavel) {
        this.responsavel = responsavel;
    }

    public Atividade getAtividadeOrigem() {
        return atividadeOrigem;
    }

    public void setAtividadeOrigem(Atividade atividadeOrigem) {
        this.atividadeOrigem = atividadeOrigem;
    }

    public TipoTrabalho getTipo() {
        return tipo;
    }

    public void setTipo(TipoTrabalho tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rv = new HashMap<>();

        rv.put("codigo", codigo);
        rv.put("descricao", descricao);
        rv.put("horaInicio", horaInicio);
        rv.put("horaTermino",horaTermino);
        rv.put("tipoTrabalho",tipo);
        rv.put("colaborador",responsavel);
        return rv;
    }   

}
