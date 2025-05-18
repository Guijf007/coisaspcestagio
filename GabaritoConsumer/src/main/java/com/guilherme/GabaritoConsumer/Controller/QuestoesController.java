package com.guilherme.GabaritoConsumer.Controller;

import com.guilherme.GabaritoConsumer.Model.Questoes;
import com.guilherme.GabaritoConsumer.Service.QuestoesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questoes")
public class QuestoesController {
    @Autowired
    QuestoesService questoesService;

    @GetMapping("")
    public String listarQuestoes(Model model, HttpSession session) {
        session.removeAttribute("idQuestoes");
        model.addAttribute("listquestoes", questoesService.pesquisar());
        return "questoes/list-questoes";
    }

    @GetMapping("/prova/{id}")
    public String listarQuestoesProva(@PathVariable int id, Model model, HttpSession session) {
        session.removeAttribute("idQuestoes");
        model.addAttribute("listquestoes", questoesService.pesquisarProva(id));
        return "questoes/list-questoes";
    }

    @GetMapping("/novo")
    public String novoQuestoes(Model model){
        model.addAttribute("questoes", new Questoes());
        return "questoes/form-questoes";
    }

    @GetMapping("/editar/{id}")
    public String editaQuestoes(@PathVariable int id, Model model, HttpSession session){
        session.setAttribute("idQuestoes", id);
        model.addAttribute("questoes", questoesService.localizar(id));
        return "questoes/form-questoes";
    }
/*
    @GetMapping("/visualizar/{id}")
    public String visualizaQuestoes(@PathVariable int id, Model model, HttpSession session){
        model.addAttribute("prova", provaService.localizar(id));
        return "prova/visualiza-prova";
    }

 */

    @PostMapping("/salvar")
    public String salvaQuestoes(@ModelAttribute("prova") Questoes questoes, HttpSession session){
        questoes.setId(session.getAttribute("idQuestoes")==null?0:(int)session.getAttribute("idQuestoes"));
        questoesService.salvar(questoes);
        return "redirect:/questoes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirFuncionario(@PathVariable int id){
        questoesService.excluir(id);
        return "redirect:/prova";
    }
}
