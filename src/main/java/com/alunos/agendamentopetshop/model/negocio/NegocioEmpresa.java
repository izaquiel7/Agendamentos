/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.negocio;

import com.alunos.agendamentopetshop.interfaces.InterfaceEmpresa;
import com.alunos.agendamentopetshop.model.entidades.Empresa;
import com.alunos.agendamentopetshop.repositorio.implementacao.RepositorioEmpresaImplDB;
import com.alunos.agendamentopetshop.util.Criptografia;
import com.alunos.agendamentopetshop.util.ValidaCNPJ;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class NegocioEmpresa implements InterfaceEmpresa<Empresa> {

    private RepositorioEmpresaImplDB repositorioEmpresa;

    private Empresa empresa;

    public NegocioEmpresa() {
        repositorioEmpresa = new RepositorioEmpresaImplDB();
    }

    @Override
    public Empresa autenticar(String login, String senha) {
        if (login == null || senha == null) {
            return null;
        } else {
            empresa = repositorioEmpresa.autenticar(login, senha);

            if (empresa == null) {
                return null;
            } else {
                return empresa;
            }
        }

    }

    @Override
    public Empresa buscarCnpj(String cnpj) {
        if (cnpj == null) {
            return null;
        } else {
            empresa = repositorioEmpresa.buscarCnpj(cnpj);

            if (empresa == null) {
                return null;
            } else {
                return empresa;
            }
        }
    }

    @Override
    public void salvar(Empresa e) throws Exception {

        boolean status = ValidaCNPJ.isCNPJ(e.getCnpj());
        if (status == true) {
            if (e == null || buscarCnpj(e.getCnpj()) != null) {
                throw new Exception("Erro!");
            }
            e.setSenha(Criptografia.criptografar(e.getSenha()));
            repositorioEmpresa.salvar(e);
        } else {
            throw new Exception("Erro!");
        }
    }

    @Override
    public Empresa buscar(Integer codigo) {
        if (codigo == null) {
            return null;
        } else {
            empresa = repositorioEmpresa.buscar(codigo);
            if (empresa == null) {
                return null;
            } else {
                return empresa;
            }
        }
    }

    @Override
    public void editar(Empresa e) throws Exception {

        if (e == null || repositorioEmpresa.buscar(e.getIdEmpresa()) == null) {
            throw new Exception("Erro!");
        } else {
            repositorioEmpresa.editar(e);
        }
    }

    @Override
    public void deletar(Empresa e) throws Exception {
        if (e == null || repositorioEmpresa.buscarCnpj(e.getCnpj()) == null) {
            throw new Exception("Erro!");
        } else {
            repositorioEmpresa.deletar(e);
        }

    }

    @Override
    public List<Empresa> listar() {
        List lista = repositorioEmpresa.listar();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

}
