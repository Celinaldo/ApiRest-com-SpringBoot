/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devjunior.Api.ApiRest.controller;

import br.com.devjunior.Api.ApiRest.model.Livro;
import br.com.devjunior.Api.ApiRest.model.dto.LivroDTO;
import br.com.devjunior.Api.ApiRest.service.LivroService;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jr
 */
@RestController
@RequestMapping(path = "/livros/api")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Livro>> listarLivros() {

        return service.listarLivros();  
        

    }
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Livro> buscarLivros(@PathVariable int id) {
        return service.buscarLivros(id);  
    }
    @PostMapping(path = "/{id}" , consumes ={MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LinkedHashMap<String , Object>>incluirLivro(@RequestBody LivroDTO livroDTO) {
        return service.incluirLivro(livroDTO);  
    }
    @PutMapping(consumes ={MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LinkedHashMap<String , Object>>atualizarLivro(@RequestBody LivroDTO livroDTO,@PathVariable int id) {
        return service.atualizarLivro(id,livroDTO);  
    }
    @DeleteMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> excluirLivro(@PathVariable int id) {
        return service.excluirLivro(id);  
    }
    
    

}
