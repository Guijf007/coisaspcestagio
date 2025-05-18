package com.info.funcionarioAPI.service;

import com.info.funcionarioAPI.model.Funcionario;
import com.info.funcionarioAPI.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario localizar(int id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<Funcionario> pesquisar(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void excluir(int id){
        funcionarioRepository.deleteById(id);
    }
}
