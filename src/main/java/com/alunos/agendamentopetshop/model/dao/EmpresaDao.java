/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.dao;

import com.alunos.agendamentopetshop.util.Persistencia;
import com.alunos.agendamentopetshop.model.interfaces.InterfaceEmpresa;
import com.alunos.agendamentopetshop.model.entidades.Empresa;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class EmpresaDao implements InterfaceEmpresa<Empresa> {

    @Override
    public void salvar(Empresa empresa) {
        Persistencia.getInstance().salvar(empresa);
    }

    @Override
    public void editar(Empresa empresa) {
        Persistencia.getInstance().editar(empresa);
    }

    @Override
    public Empresa buscar(Integer codigo) {
        List lista = Persistencia.getInstance().listar("SELECT em FROM Empresa em WHERE em.id=" + codigo);
        if(!lista.isEmpty()){
            return (Empresa) lista.get(0);
        }
            return null;
    }

    @Override
    public void deletar(Empresa empresa) {
        Persistencia.getInstance().deletar(empresa);
    }

    @Override
    public List<Empresa> listar() {
        return Persistencia.getInstance().listar("SELECT em FROM Empresa em");
    }
    
    @Override
    public Empresa autenticar(String email, String senha) {
        return (Empresa) Persistencia.getInstance().autenticar("SELECT a FROM Empresa a", email, senha);
    }

    @Override
    public Empresa buscarCnpj(String cnpj) {
        List lista = Persistencia.getInstance().listar("SELECT em FROM Empresa em WHERE em.cnpj=" + cnpj);
        if(!lista.isEmpty()){
            return (Empresa) lista.get(0);
        }
            return null;
    }
}

