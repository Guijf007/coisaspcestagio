package com.guilherme.GabaritoAPi.Controller;

import com.guilherme.GabaritoAPi.Model.Resultado;
import com.guilherme.GabaritoAPi.Service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resultado")
public class ResultadoController {
    @Autowired
    ResultadoService resultadoService;

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> localizar(@PathVariable int id) {
        return ResponseEntity.ok(resultadoService.localizar(id));
    }

    @GetMapping()
    public ResponseEntity<List<Resultado>> pesquisa() {
        return ResponseEntity.ok(resultadoService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Resultado> salvar(@RequestBody Resultado resultado) {
        return ResponseEntity.ok(resultadoService.salvar(resultado));
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            resultadoService.excluir(id);
            return ResponseEntity.ok("Resultado " + id + " excluído!");
        } catch (Exception e) {
            return ResponseEntity.ok("Erro ao excluir o Resultado " + id +
                    ": " + e.getMessage());
        }
    }
}
