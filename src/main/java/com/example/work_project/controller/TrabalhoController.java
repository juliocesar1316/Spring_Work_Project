package com.example.work_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.work_project.entity.Trabalho;
import com.example.work_project.service.TrabalhoService;

@RestController
@RequestMapping (value ="/trabalho" )
@CrossOrigin
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public ResponseEntity<Trabalho> adicionarTrabalho(@RequestBody Trabalho trabalho){
        return ResponseEntity.status(HttpStatus.CREATED).body(trabalhoService.novoTrabalho(trabalho));
    }

    @GetMapping( value = "/{titulo}/{nota}")
    public ResponseEntity<List<Trabalho>> todosTrabalhos(@PathVariable("titulo") String titulo, @PathVariable("nota") Integer nota){
        return ResponseEntity.status(HttpStatus.OK).body(trabalhoService.listarTrabalhos(titulo, nota));
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Trabalho> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(trabalhoService.buscarPorId(id));
    }
}
