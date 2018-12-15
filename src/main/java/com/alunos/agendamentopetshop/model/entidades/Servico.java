/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@Entity
@Table(name="servico")
public class Servico implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Integer duracao;
    private BigDecimal valor;
    @OneToOne
    private Empresa empresa;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER) 
    private List<Horarios> listaDeHorarios;

    public Servico() {
    }

    public Servico(String nome, Integer duracao, BigDecimal valor, Empresa empresa, List<Horarios> listaDeHorarios) {
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
        this.empresa = empresa;
        this.listaDeHorarios = listaDeHorarios;
    }

    public Integer getIdServico() {
        return id;
    }

    public void setIdServico(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Horarios> getListaDeHorarios() {
        return listaDeHorarios;
    }

    public void setListaDeHorarios(List<Horarios> listaDeHorarios) {
        this.listaDeHorarios = listaDeHorarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", valor=" + valor + ", empresa=" + empresa + ", listaDeHorarios=" + listaDeHorarios + '}';
    }

    
}
