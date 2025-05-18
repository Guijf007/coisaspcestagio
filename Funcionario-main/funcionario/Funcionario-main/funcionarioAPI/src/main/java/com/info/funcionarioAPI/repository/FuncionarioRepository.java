package com.info.funcionarioAPI.repository;


import com.info.funcionarioAPI.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
