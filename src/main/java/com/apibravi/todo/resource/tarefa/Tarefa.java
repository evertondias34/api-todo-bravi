package com.apibravi.todo.resource.tarefa;

import com.apibravi.todo.resource.comentario.Comentario;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private Boolean isAtivo;
    private Integer tempoGasto;

    private Date dataPrevista;

    @Transient
    private Boolean isPraHoje;
    @Transient
    private Boolean isAtrasada;
    @Transient
    private Boolean isAgendada;
    @Transient
    private String data;

    @OneToMany(mappedBy = "tarefa")
    List<Comentario> comentarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Integer getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(Integer tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Boolean getIsAtrasada() {
        return isAtrasada;
    }

    public void setIsAtrasada(Boolean atrasada) {
        isAtrasada = atrasada;
    }

    public Boolean getIsAgendada() {
        return isAgendada;
    }

    public void setIsAgendada(Boolean agendada) {
        isAgendada = agendada;
    }

    public Boolean getIsPraHoje() {
        return isPraHoje;
    }

    public void setIsPraHoje(Boolean praHoje) {
        isPraHoje = praHoje;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
