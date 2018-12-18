/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class Mensagens {
    private static Mensagens mensagens;

    private Mensagens() {

    }

    public static Mensagens getInstance() {

        if (mensagens == null) {
            mensagens = new Mensagens();
        }

        return mensagens;
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, mensagem);
    }

    public void nenhumaInformacao() {
        adicionarMensagem(null, "Não foi passada nenhuma Informação!!!", FacesMessage.SEVERITY_ERROR);
    }

    public void jaExisteNoBanco(String texto) {
        adicionarMensagem(null, "Já Existe um(a) " + texto + "igual a esse no banco!!!", FacesMessage.SEVERITY_ERROR);
    }
    
    public void invalido(String texto){
        adicionarMensagem(null, texto + " invalido!! Digite um " + texto + " valido", FacesMessage.SEVERITY_ERROR);
    }
    
    public void salvoComSucesso() {
        adicionarMensagem(null, "Salvo com sucesso!!!", FacesMessage.SEVERITY_INFO);

    }

    public void alteradoComSucesso() {
        adicionarMensagem(null, "Alterado com sucesso!!!", FacesMessage.SEVERITY_INFO);
    }

    public void deletadoComSucesso() {
        adicionarMensagem(null, "Deletado com sucesso!!!", FacesMessage.SEVERITY_INFO);
    }
}
