/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.repositorio.implementacao;

import com.alunos.agendamentopetshop.dao.PersistenciaDAO;
import com.alunos.agendamentopetshop.interfaces.InterfaceEmpresa;
import com.alunos.agendamentopetshop.model.entidades.Empresa;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class RepositorioEmpresaImplDB implements InterfaceEmpresa<Empresa> {

    @Override
    public void salvar(Empresa empresa) {
        PersistenciaDAO.getInstance().salvar(empresa);
    }

    @Override
    public void editar(Empresa empresa) {
        PersistenciaDAO.getInstance().editar(empresa);
    }

    @Override
    public Empresa buscar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT em FROM Empresa em WHERE em.id=" + codigo);
        if(!lista.isEmpty()){
            return (Empresa) lista.get(0);
        }
            return null;
    }

    @Override
    public void deletar(Empresa empresa) {
        PersistenciaDAO.getInstance().deletar(empresa);
    }

    @Override
    public List<Empresa> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT em FROM Empresa em");
    }
    
    @Override
    public Empresa autenticar(String email, String senha) {
        return (Empresa) PersistenciaDAO.getInstance().autenticar("SELECT a FROM Empresa a", email, senha);
    }

    @Override
    public Empresa buscarCnpj(String cnpj) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT em FROM Empresa em WHERE em.cnpj=" + cnpj);
        if(!lista.isEmpty()){
            return (Empresa) lista.get(0);
        }
            return null;
    }
}

