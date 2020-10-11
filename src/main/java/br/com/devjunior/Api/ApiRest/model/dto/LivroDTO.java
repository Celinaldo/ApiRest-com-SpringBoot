 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devjunior.Api.ApiRest.model.dto;

import java.time.LocalDate;

/**
 *
 * @author jr
 */
@lombok.Getter
@lombok.Setter
public class LivroDTO {
    
    private String nome;
    
    private LocalDate publicacao;
    
    
}
