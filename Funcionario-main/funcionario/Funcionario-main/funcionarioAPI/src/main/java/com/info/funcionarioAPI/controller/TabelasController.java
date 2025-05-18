package com.info.funcionarioAPI.controller;

import com.info.funcionarioAPI.model.Tabelas;
import com.info.funcionarioAPI.service.TabelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tabelas")
public class TabelasController {
    @Autowired
    private TabelasService tabelasService;

    @GetMapping("/{id}")
    public ResponseEntity<Tabelas> localizar(@PathVariable int id) {
        return ResponseEntity.ok(tabelasService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<List<Tabelas>> pesquisa() {
        return ResponseEntity.ok(tabelasService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Tabelas> salvar(@RequestBody Tabelas tabelas) {
        return ResponseEntity.ok(tabelasService.salvar(tabelas));
    }
}
