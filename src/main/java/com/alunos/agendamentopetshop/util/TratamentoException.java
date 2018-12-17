/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alunos.agendamentopetshop.util;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class TratamentoException {

    public static Exception e;

    private TratamentoException() {
    }

    public static void trataSalvar() throws Exception {
        e = new Exception();
        throw new Exception("Erro ao tentar salvar!", e.getCause());
    }

    public static void trataEditar() throws Exception {
        e = new Exception();
        throw new Exception("Erro ao tentar editar!", e.getCause());
    }

    public static void trataDeletar() throws Exception {
        e = new Exception();
        throw new Exception("Erro ao tentar deletar!", e.getCause());
    }
}
