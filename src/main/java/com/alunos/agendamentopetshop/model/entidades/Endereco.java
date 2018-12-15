/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String logradouro;
    private Integer numero;
    private String cidade;
    private String bairro;

    public Endereco() {
    }

    public Endereco(String logradouro, Integer numero, String cidade, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public Integer getIdEndereco() {
        return id;
    }

    public void setIdEndereco(Integer id) {
        this.id = id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        return hash;
    }



    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) obj;

        if(endereco.id == id
                && endereco.bairro == bairro
                && endereco.cidade == cidade
                && endereco.logradouro == logradouro
                && endereco.numero == numero) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", cidade=" + cidade + ", bairro=" + bairro + '}';
    }
}