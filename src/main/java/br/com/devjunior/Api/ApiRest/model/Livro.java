/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devjunior.Api.ApiRest.model;

import java.time.LocalDate;

/**
 *
 * @author jr
 */
@lombok.Getter
@lombok.Setter
public class Livro {

    private int Id;
    private String nome;
    private LocalDate publicacao;

    public Livro(int Id, String nome, LocalDate publicacao) {
        this.Id = Id;
        this.nome = nome;
        this.publicacao = publicacao;
    }

}
