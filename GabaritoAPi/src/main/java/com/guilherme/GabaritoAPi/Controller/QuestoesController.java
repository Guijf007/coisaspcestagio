package com.guilherme.GabaritoAPi.Controller;

import com.guilherme.GabaritoAPi.Model.Questoes;
import com.guilherme.GabaritoAPi.Service.QuestoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questoes")
public class QuestoesController {
    @Autowired
    private QuestoesService questoesService;

    @GetMapping("/{id}")
    public ResponseEntity<Questoes> localizar(@PathVariable int id) {
        return ResponseEntity.ok(questoesService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<List<Questoes>> pesquisa() {
        return ResponseEntity.ok(questoesService.pesquisar());
    }

    @GetMapping("/prova/{id}")
    public ResponseEntity<List<Questoes>> pesquisaProva(@PathVariable int id) {
        return ResponseEntity.ok(questoesService.pesquisarProva(id));
    }

    @PostMapping()
    public ResponseEntity<Questoes> salvar(@RequestBody Questoes questoes) {
        return ResponseEntity.ok(questoesService.salvar(questoes));
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            questoesService.excluir(id);
            return ResponseEntity.ok("Questão " + id + " excluída!");
        } catch (Exception e) {
            return ResponseEntity.ok("Erro ao excluir a Questão " + id +
                    ": " + e.getMessage());
        }
    }
}
