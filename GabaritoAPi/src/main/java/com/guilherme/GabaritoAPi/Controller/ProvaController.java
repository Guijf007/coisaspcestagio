package com.guilherme.GabaritoAPi.Controller;

import com.guilherme.GabaritoAPi.Model.Prova;
import com.guilherme.GabaritoAPi.Service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prova")
public class ProvaController {
    @Autowired
    private ProvaService provaService;

    @GetMapping("/{id}")
    public ResponseEntity<Prova> localizar(@PathVariable int id) {
        return ResponseEntity.ok(provaService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<List<Prova>> pesquisa() {
        return ResponseEntity.ok(provaService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Prova> salvar(@RequestBody Prova prova) {
        return ResponseEntity.ok(provaService.salvar(prova));
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            provaService.excluir(id);
            return ResponseEntity.ok("Prova " + id + " excluída!");
        } catch (Exception e) {
            return ResponseEntity.ok("Erro ao excluir a Prova " + id +
                    ": " + e.getMessage());
        }
    }
}
