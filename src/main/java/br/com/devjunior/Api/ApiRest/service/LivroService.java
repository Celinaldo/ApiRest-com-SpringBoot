/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devjunior.Api.ApiRest.service;

import br.com.devjunior.Api.ApiRest.model.Livro;
import br.com.devjunior.Api.ApiRest.model.dto.LivroDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        Livro l1 = new Livro(1, "Spring Total", LocalDate.of(2010, 10, 10));
        Livro l2 = new Livro(2, "Java Total", LocalDate.of(2011, 11, 1));
        Livro l3 = new Livro(3, "Java e Spring Total", LocalDate.of(2012, 12, 12));

        livros.add(l1);
        livros.add(l2);
        livros.add(l3);

        return ResponseEntity.ok(livros);

    }

    public ResponseEntity<Livro> buscarLivros(Integer id) {
        Livro l2 = new Livro(2, "Java Total", LocalDate.of(2011, 11, 1));

        if (id.equals(2)) {
            return ResponseEntity.ok(l2);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<LinkedHashMap<String, Object>> incluirLivro(LivroDTO livroDTO) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();

        if (livroDTO.getNome().equals("Java Toatal")) {
            map.put("id", 2);
            map.put("nome", livroDTO.getNome());
            map.put("publicacao", livroDTO.getPublicacao());
            map.put("dataCadastro", LocalDateTime.now());

        } else {
            map.put("id", 1);
            map.put("nome", livroDTO.getNome());
            map.put("publicacao", livroDTO.getPublicacao());
            map.put("dataCadastro", LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
        return null;        
    }

    public ResponseEntity<LinkedHashMap<String, Object>> atualizarLivro(Integer id, LivroDTO livroDTO) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();

        if (id.equals(1)) {
            map.put("id", 1);
            map.put("nome", livroDTO.getNome());
            map.put("publicacao", livroDTO.getPublicacao());
            map.put("dataAtualizada", LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.OK).body(map);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Void> excluirLivro(Integer id) {
        if (id.equals(1)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
            
        }


         
    }
    
    
    
    
    
    
}
