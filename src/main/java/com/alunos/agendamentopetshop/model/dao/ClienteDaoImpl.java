/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.dao;

import com.alunos.agendamentopetshop.model.interfaces.InterfaceCliente;
import com.alunos.agendamentopetshop.model.entidades.Cliente;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class ClienteDaoImpl implements InterfaceCliente<Cliente> {
    
    @Override
    public void salvar(Cliente cliente) {
        DaoImpl.getInstance().salvar(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        DaoImpl.getInstance().editar(cliente);
    }

    @Override
    public Cliente buscar(Integer codigo) {
        List lista = DaoImpl.getInstance().listar("SELECT c FROM Cliente c WHERE c.id=" + codigo);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
            return null;
        
    }

    @Override
    public void deletar(Cliente cliente) {
        DaoImpl.getInstance().deletar(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return DaoImpl.getInstance().listar("SELECT c FROM Cliente c");
    }
    
    @Override
    public Cliente autenticar(String email, String senha) {
        return (Cliente) DaoImpl.getInstance().autenticar("SELECT a FROM Cliente a", email, senha);
    }
    
    @Override
    public Cliente buscarCpf(String cpf){
        List lista =  DaoImpl.getInstance().listar("SELECT c FROM Cliente c WHERE c.cpf=" + cpf);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
            return null;
    }
        
}
