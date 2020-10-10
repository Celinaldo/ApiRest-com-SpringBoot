/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devjunior.Api.ApiRest.service;

import br.com.devjunior.Api.ApiRest.model.Livro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author jr
 */

@Service
public class LivroService {
    
    public ResponseEntity<List<Livro>> listarLivros(){
        List<Livro> livros = new ArrayList<>();
        Livro l1 = new Livro(1, "Spring Total", LocalDate.of(2010,10,10));
        Livro l2 = new Livro(2, "Java Total", LocalDate.of(2011,11,1));
        Livro l3 = new Livro(3, "Java e Spring Total", LocalDate.of(2012,12,12));
        
        livros.add(l1);
        livros.add(l2);
        livros.add(l3);
        
        return ResponseEntity.ok(livros);
        
        
    }

    public ResponseEntity<Livro> buscarLivros(Integer id) {
        Livro l2 = new Livro(2, "Java Total", LocalDate.of(2011,11,1));
        
        if(id.equals(2)){
            return ResponseEntity.ok(l2);
            
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            
        }

        
        
    }
    
}
