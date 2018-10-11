/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alunos.agendamentopetshop.model.interfaces;

/**
 *
 * @author Izaquiel
* @param <Cliente>
 */
public interface InterfaceCliente<Cliente> extends InterfaceDao<Cliente> {
    
    public Cliente autenticar(String login, String senha);
    public Cliente buscarCpf(String cpf);
}
