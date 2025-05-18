package com.guilherme.GabaritoAPi.Service;

import com.guilherme.GabaritoAPi.Model.Prova;
import com.guilherme.GabaritoAPi.Repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {
    @Autowired
    ProvaRepository provaRepository;

    public Prova localizar(int id){
        return provaRepository.findById(id).orElse(null);
    }

    public List<Prova> pesquisar(){
        return provaRepository.findAll();
    }

    public Prova salvar(Prova prova){
        return provaRepository.save(prova);
    }

    public void excluir(int id){
        provaRepository.deleteById(id);
    }
}
