package com.info.funcionarioAPI.service;

import com.info.funcionarioAPI.model.Tabelas;
import com.info.funcionarioAPI.repository.TabelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelasService {
    @Autowired
    TabelasRepository tabelasRepository;

    public Tabelas localizar(int id){
        return tabelasRepository.findById(id).orElse(null);
    }

    public List<Tabelas> pesquisar(){
        return tabelasRepository.findAll();
    }

    public Tabelas salvar(Tabelas tabelas){
        return tabelasRepository.save(tabelas);
    }

    public void excluir(int id){
        tabelasRepository.deleteById(id);
    }
}
