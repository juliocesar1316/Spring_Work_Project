package com.example.work_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.work_project.entity.Trabalho;
import com.example.work_project.repository.TrabalhoRepo;

@Service
public class TrabalhoService implements TrabalhoInterfaceService {
        
    @Autowired
    private TrabalhoRepo trabalhoRepo;

    @Override
    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho==null || 
            trabalho.getTitulo() == null || 
            trabalho.getTitulo().isBlank() || 
            trabalho.getData() == null || 
            trabalho.getGrupo() == null ||
            trabalho.getGrupo().isBlank()){
              
                throw new IllegalArgumentException("Existe campos em brancos ou nulos");
        }

        return trabalhoRepo.save(trabalho);
    }

    @Override
    public List<Trabalho> listarTrabalhos(String titulo, Integer nota) {
        return trabalhoRepo.findByTituloAndNotaGreaterThan(titulo, nota);
    }

    @Override
    public Trabalho buscarPorId(Long id) {

        Optional<Trabalho> tra = trabalhoRepo.findById(id);
        if(tra.isEmpty()){
            throw new IllegalArgumentException("Trabalho não encontrado!");
        }
        return tra.get();
    }

    
}
