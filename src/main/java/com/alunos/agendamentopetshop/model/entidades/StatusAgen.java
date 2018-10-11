/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alunos.agendamentopetshop.model.entidades;

/**
 *
 * @author Izaquiel
 */
public enum StatusAgen {

    ESPERA(1), AGENDADO(2), REALIZADO(3), CANCELADO(4);

    private final int valor;

    private StatusAgen(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
