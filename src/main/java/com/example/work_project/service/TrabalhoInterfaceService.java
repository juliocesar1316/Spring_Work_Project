package com.example.work_project.service;

import java.util.List;

import com.example.work_project.entity.Trabalho;

public interface TrabalhoInterfaceService {

    public Trabalho novoTrabalho(Trabalho trabalho);

    public List<Trabalho> listarTrabalhos(String titulo, Integer nota);

    public Trabalho buscarPorId (Long id);
}
