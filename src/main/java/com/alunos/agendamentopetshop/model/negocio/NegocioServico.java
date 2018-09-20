/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.negocio;

import com.alunos.agendamentopetshop.interfaces.InterfaceServico;
import com.alunos.agendamentopetshop.model.entidades.Servico;
import com.alunos.agendamentopetshop.repositorio.implementacao.RepositorioServicoImplDB;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class NegocioServico implements InterfaceServico<Servico>{
    
    private RepositorioServicoImplDB repositorioServico;
    private Servico servico;
    
    public NegocioServico(){
        repositorioServico = new RepositorioServicoImplDB();
    }
    
    @Override
    public void salvar(Servico servico) throws Exception{
        if (servico == null) {
            throw new Exception("Erro!");
        }else{
            if(buscar(servico.getIdServico()) != null){
                throw new Exception("Erro!");
            }else{
                repositorioServico.salvar(servico);
            }
        }
    }
    
    @Override
    public Servico buscar(Integer codigo){
        if(codigo == null){
            return null;
        }else{
            servico = repositorioServico.buscar(codigo);
            if(servico == null){
                return null;
            }else{
                return servico;
            }
        }
    }
    
    @Override
    public void editar(Servico servico) throws Exception{
        if(servico == null){
            throw new Exception("Erro!");
        }else{
                repositorioServico.editar(servico);
           }
    }
    
    @Override
    public void deletar(Servico servico) throws Exception{
        if(servico == null){
            throw new Exception("Erro!");
        }else{
            servico = repositorioServico.buscar(servico.getIdServico());
            if(servico == null){
                throw new Exception("Erro!");
            }else{
                repositorioServico.deletar(servico);
            }
        }
    }
    
    @Override
    public List<Servico> listar(){
        List lista = repositorioServico.listar();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
}

