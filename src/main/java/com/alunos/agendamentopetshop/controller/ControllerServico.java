/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.controller;

import com.alunos.agendamentopetshop.model.entidades.Servico;
import com.alunos.agendamentopetshop.model.negocio.ServicoModel;
import com.alunos.agendamentopetshop.util.Mensagens;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@ManagedBean
@SessionScoped
public class ControllerServico {
    
    private ServicoModel negServico;
    private Servico servico;
    private ArrayList<Servico> listaServico;
    
    public ControllerServico(){
        
        negServico = new ServicoModel();
        servico = new Servico();
        listaServico = new ArrayList<>();
    }
    
    public void salvar(){
        try {
            negServico.salvar(servico);
            Mensagens.getInstance().salvoComSucesso();
        } catch(Exception ex){
            Mensagens.getInstance().nenhumaInformacao();
        }
    }
    
    public void alterar(){
        try {
            negServico.editar(servico);
            Mensagens.getInstance().alteradoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }
    
    public void deletar(){
        try {
            negServico.deletar(servico);
            Mensagens.getInstance().deletadoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }
    
    public void listar(){
        listaServico = (ArrayList<Servico>) negServico.listar();
    }
    
    public void buscarId(){
        negServico.buscar(servico.getIdServico());
    }

    public ServicoModel getNegServico() {
        return negServico;
    }

    public void setNegServico(ServicoModel negServico) {
        this.negServico = negServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public ArrayList<Servico> getListaServico() {
        return listaServico;
    }

    public void setListaServico(ArrayList<Servico> listaServico) {
        this.listaServico = listaServico;
    }
    
    
    
}
