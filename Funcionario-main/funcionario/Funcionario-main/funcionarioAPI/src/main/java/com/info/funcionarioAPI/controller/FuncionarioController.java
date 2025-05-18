package com.info.funcionarioAPI.controller;

import com.info.funcionarioAPI.model.Funcionario;
import com.info.funcionarioAPI.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> localizar(@PathVariable int id) {
        return ResponseEntity.ok(funcionarioService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<List<Funcionario>> pesquisa() {
        return ResponseEntity.ok(funcionarioService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.salvar(funcionario));
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            funcionarioService.excluir(id);
            return ResponseEntity.ok("Funcionario " + id + " excluído!");
        } catch (Exception e) {
            return ResponseEntity.ok("Erro ao excluir o Funcionario " + id +
                    ": " + e.getMessage());
        }
    }
}
