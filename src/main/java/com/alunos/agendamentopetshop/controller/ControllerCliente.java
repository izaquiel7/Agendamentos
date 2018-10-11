/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.controller;

import com.alunos.agendamentopetshop.model.entidades.Cliente;
import com.alunos.agendamentopetshop.model.negocio.ClienteModel;
import com.alunos.agendamentopetshop.util.Mensagens;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@ManagedBean
@SessionScoped
public class ControllerCliente implements Serializable {

    private ClienteModel negocioCliente;
    private Cliente cliente;
    private ArrayList<Cliente> clientes;

    public ControllerCliente() {
        negocioCliente = new ClienteModel();
        cliente = new Cliente();
        clientes = new ArrayList<>();
    }

    public void salvar() {
        try {
            cliente.setCpf(cliente.getCpf().replace(".", ""));
            cliente.setCpf(cliente.getCpf().replace("-", ""));

            negocioCliente.salvar(cliente);
            Mensagens.getInstance().salvoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }

    public void alterar() {
        try {
            negocioCliente.editar(cliente);
            Mensagens.getInstance().alteradoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }

    public void deletar() {
        try {
            negocioCliente.deletar(cliente);
            Mensagens.getInstance().deletadoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }

    public void listar() {
        clientes = (ArrayList<Cliente>) negocioCliente.listar();
    }

    public void buscarId() {
        negocioCliente.buscar(cliente.getIdCliente());
    }

    public Cliente buscarCpf() {
        return negocioCliente.buscarCpf(cliente.getCpf());
    }

    public ClienteModel getNegocioCliente() {
        return negocioCliente;
    }

    public void setNegocioCliente(ClienteModel negocioCliente) {
        this.negocioCliente = negocioCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

}

