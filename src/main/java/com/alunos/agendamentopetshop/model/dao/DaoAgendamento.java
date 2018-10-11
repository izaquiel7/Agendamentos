/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.dao;

import com.alunos.agendamentopetshop.model.repositorio.Persistencia;
import com.alunos.agendamentopetshop.model.interfaces.InterfaceAgendamento;
import com.alunos.agendamentopetshop.model.entidades.Agendamento;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class DaoAgendamento implements InterfaceAgendamento<Agendamento>{
 
    @Override
    public void salvar(Agendamento agendamento) {
        Persistencia.getInstance().salvar(agendamento);
    }

    @Override
    public void editar(Agendamento agendamento) {
        Persistencia.getInstance().editar(agendamento);
    }

    @Override
    public Agendamento buscar(Integer codigo) {
        List lista = Persistencia.getInstance().listar("SELECT ag FROM Agendamento ag WHERE ag.id=" + codigo);
        if(!lista.isEmpty()){
            return (Agendamento) lista.get(0);
        }
            return null;
    }

    @Override
    public void deletar(Agendamento agendamento) {
        Persistencia.getInstance().deletar(agendamento);
    }

    @Override
    public List<Agendamento> listar() {
        return Persistencia.getInstance().listar("SELECT ag FROM Agendamento ag");
    }
}
