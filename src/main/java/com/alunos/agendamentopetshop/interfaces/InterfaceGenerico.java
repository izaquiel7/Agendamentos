/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alunos.agendamentopetshop.interfaces;

import java.util.List;

/**
 *
 * @author Izaquiel
 * @param <E>
 */
public interface InterfaceGenerico<E> {
    public void salvar(E e) throws Exception;
    public E buscar(Integer codigo);
    public void editar(E e) throws Exception;
    public void deletar(E e) throws Exception;
    public List<E> listar();
}
