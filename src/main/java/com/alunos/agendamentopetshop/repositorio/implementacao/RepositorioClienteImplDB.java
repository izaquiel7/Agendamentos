/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.repositorio.implementacao;

import com.alunos.agendamentopetshop.dao.PersistenciaDAO;
import com.alunos.agendamentopetshop.interfaces.InterfaceCliente;
import com.alunos.agendamentopetshop.model.entidades.Cliente;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class RepositorioClienteImplDB implements InterfaceCliente<Cliente> {
    
    @Override
    public void salvar(Cliente cliente) {
        PersistenciaDAO.getInstance().salvar(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        PersistenciaDAO.getInstance().editar(cliente);
    }

    @Override
    public Cliente buscar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.id=" + codigo);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
            return null;
        
    }

    @Override
    public void deletar(Cliente cliente) {
        PersistenciaDAO.getInstance().deletar(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c");
    }
    
    @Override
    public Cliente autenticar(String email, String senha) {
        return (Cliente) PersistenciaDAO.getInstance().autenticar("SELECT a FROM Cliente a", email, senha);
    }
    
    @Override
    public Cliente buscarCpf(String cpf){
        List lista =  PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.cpf=" + cpf);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
            return null;
    }
        
}
