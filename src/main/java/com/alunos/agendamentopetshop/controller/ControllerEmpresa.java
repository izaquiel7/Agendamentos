/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.controller;

import com.alunos.agendamentopetshop.model.entidades.Empresa;
import com.alunos.agendamentopetshop.model.negocio.EmpresaModel;
import com.alunos.agendamentopetshop.util.Mensagens;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@ManagedBean
@SessionScoped
public class ControllerEmpresa implements Serializable {

    private EmpresaModel negEmpresa;
    private Empresa empresa;
    private ArrayList<Empresa> listaEmpresa;
    private String ret = "";

    public ControllerEmpresa() {
        negEmpresa = new EmpresaModel();
        empresa = new Empresa();
        listaEmpresa = new ArrayList<>();
    }

    public String salvar() {
        try {

            negEmpresa.salvar(empresa);
            Mensagens.getInstance().salvoComSucesso();
            ret = "Menu empresa";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String alterar(Empresa emp) {
        try {

            negEmpresa.editar(emp);
            Mensagens.getInstance().alteradoComSucesso();
            ret = "Menu empresa";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String deletar() {
        try {
            negEmpresa.deletar(empresa);
            Mensagens.getInstance().deletadoComSucesso();
            ret = "pagina inicial";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public void listar() {
        listaEmpresa = (ArrayList<Empresa>) negEmpresa.listar();
    }

    public void buscarId() {
        negEmpresa.buscar(empresa.getIdEmpresa());
    }

    public void bu8scarCnpj() {
        negEmpresa.buscarCnpj(empresa.getCnpj());
    }

    public EmpresaModel getNegEmpresa() {
        return negEmpresa;
    }

    public void setNegEmpresa(EmpresaModel negEmpresa) {
        this.negEmpresa = negEmpresa;
    }

    public ArrayList<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(ArrayList<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

}