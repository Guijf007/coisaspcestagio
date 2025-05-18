package com.guilherme.GabaritoAPi.Service;

import com.guilherme.GabaritoAPi.Model.Questoes;
import com.guilherme.GabaritoAPi.Repository.QuestoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestoesService {
    @Autowired
    QuestoesRepository questoesRepository;

    public Questoes localizar(int id){
        return questoesRepository.findById(id).orElse(null);
    }

    public List<Questoes> pesquisar(){
        return questoesRepository.findAll();
    }

    public List<Questoes> pesquisarProva(int idProva){
        return questoesRepository.findAllByIdProva(idProva);
    }

    public Questoes salvar(Questoes questoes){
        return questoesRepository.save(questoes);
    }

    public void excluir(int id){
        questoesRepository.deleteById(id);
    }
}
