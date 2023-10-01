package com.example.work_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.work_project.entity.Trabalho;

public interface TrabalhoRepo extends JpaRepository<Trabalho, Long> {

    public List<Trabalho> findByTituloAndNotaGreaterThan(String titulo, Integer nota);
    
}
