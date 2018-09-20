/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.controller;

import com.alunos.agendamentopetshop.model.entidades.Cliente;
import com.alunos.agendamentopetshop.model.entidades.Empresa;
import com.alunos.agendamentopetshop.model.negocio.NegocioCliente;
import com.alunos.agendamentopetshop.model.negocio.NegocioEmpresa;
import com.alunos.agendamentopetshop.util.Criptografia;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@ManagedBean
@SessionScoped
public class AutenticarBean implements Serializable {
    private String email;
    private String senha;
    private Cliente clienteLogin;
    private Empresa empresaLogin;

public AutenticarBean(){
    clienteLogin = new Cliente();
    empresaLogin = new Empresa();
}
    
    public String entrar() {
        if(email == null) {
            System.out.println("valor nulo para email.");
        }
        if(senha == null) {
            System.out.println("valor nulo para senha.");
        }
        senha = Criptografia.criptografar(senha);
        NegocioCliente neg = new NegocioCliente();
        clienteLogin = neg.autenticar(email, senha);
        
        if(clienteLogin != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", this.clienteLogin);
            return "Cliente/visualizarServicos.xhtml?faces-redirect=true";
        } else {
            NegocioEmpresa negEmp = new NegocioEmpresa();
            empresaLogin = negEmp.autenticar(email, senha);
            
            if(empresaLogin != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresaLogado", this.empresaLogin);
                return "Empresa/meusAgendamentos.xhtml?faces-redirect=true";
            }
        }
        
        if(clienteLogin == null && empresaLogin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro ao fazer login!"));
        }
        
        return "index.xhtml";
        
    }
    
    public String sair() {
        clienteLogin = null;
        empresaLogin = null;
        return "../index.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(Cliente clienteLogin) {
        this.clienteLogin = clienteLogin;
    }

    public Empresa getEmpresaLogin() {
        return empresaLogin;
    }

    public void setEmpresaLogin(Empresa empresaLogin) {
        this.empresaLogin = empresaLogin;
    }


    
}
