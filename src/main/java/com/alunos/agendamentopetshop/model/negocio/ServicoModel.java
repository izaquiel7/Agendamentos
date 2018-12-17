/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.negocio;

import com.alunos.agendamentopetshop.model.interfaces.InterfaceServico;
import com.alunos.agendamentopetshop.model.entidades.Servico;
import com.alunos.agendamentopetshop.model.dao.ServicoDaoImpl;
import com.alunos.agendamentopetshop.util.TratamentoException;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class ServicoModel implements InterfaceServico<Servico>{
    
    private ServicoDaoImpl repositorioServico;
    private Servico servico;
    
    public ServicoModel(){
        repositorioServico = new ServicoDaoImpl();
    }
    
    @Override
    public void salvar(Servico servico) throws Exception{
        if (servico == null) {
            TratamentoException.trataSalvar();
        }else{
            if(buscar(servico.getIdServico()) != null){
                System.err.print("Este serviço foi salvo anteriormente!");
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
            TratamentoException.trataEditar();
        }else{
                repositorioServico.editar(servico);
           }
    }
    
    @Override
    public void deletar(Servico servico) throws Exception{
        if(servico == null){
            TratamentoException.trataDeletar();
        }else{
            servico = repositorioServico.buscar(servico.getIdServico());
            if(servico == null){
                TratamentoException.trataDeletar(); //vai dar NullPointerException
                //System.err.print("Este serviço já foi deletado!");
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

