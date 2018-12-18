/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alunos.agendamentopetshop.model.interfaces;

import java.util.List;

/**
 *
 * @author Izaquiel
 * @param <O>
 */
public interface InterfaceGenerica<O> {

    public void salvar(O o) throws Exception;

    public O buscar(Integer codigo);

    public void editar(O o) throws Exception;

    public void deletar(O o) throws Exception;

    public List<O> listar();
}
