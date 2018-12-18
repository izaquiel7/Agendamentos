/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.dao;

import com.alunos.agendamentopetshop.model.interfaces.InterfaceServico;
import com.alunos.agendamentopetshop.model.entidades.Servico;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class ServicoDaoImpl implements InterfaceServico<Servico> {

    @Override
    public void salvar(Servico servico) {
        DaoImpl.getInstance().salvar(servico);
    }

    @Override
    public void editar(Servico servico) {
        DaoImpl.getInstance().editar(servico);
    }

    @Override
    public Servico buscar(Integer codigo) {
        List lista = DaoImpl.getInstance().listar("SELECT s FROM Servico s WHERE s.id=" + codigo);
        if (!lista.isEmpty()) {
            return (Servico) lista.get(0);
        }
        return null;
    }

    @Override
    public void deletar(Servico servico) {
        DaoImpl.getInstance().deletar(servico);
    }

    @Override
    public List<Servico> listar() {
        return (List<Servico>) (Object) DaoImpl.getInstance().listar("SELECT s FROM Servico s");
    }

}
