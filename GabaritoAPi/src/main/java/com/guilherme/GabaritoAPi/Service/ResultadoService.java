package com.guilherme.GabaritoAPi.Service;

import com.guilherme.GabaritoAPi.Model.Resultado;
import com.guilherme.GabaritoAPi.Repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService {
    @Autowired
    ResultadoRepository resultadoRepository;

    public Resultado localizar(int id){
        return resultadoRepository.findById(id).orElse(null);
    }

    public List<Resultado> pesquisar(){
        return resultadoRepository.findAll();
    }

    public Resultado salvar(Resultado resultado){
        return resultadoRepository.save(resultado);
    }

    public void excluir(int id){
        resultadoRepository.deleteById(id);
    }
}
