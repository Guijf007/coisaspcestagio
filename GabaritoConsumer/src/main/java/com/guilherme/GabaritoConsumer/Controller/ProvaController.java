package com.guilherme.GabaritoConsumer.Controller;

import com.guilherme.GabaritoConsumer.Model.Prova;
import com.guilherme.GabaritoConsumer.Model.Questoes;
import com.guilherme.GabaritoConsumer.Service.ProvaService;
import com.guilherme.GabaritoConsumer.Service.QuestoesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prova")
public class ProvaController {
    @Autowired
    ProvaService provaService;
    @Autowired
    QuestoesService questoesService;

    @GetMapping("")
    public String listarProva(Model model, HttpSession session) {
        session.removeAttribute("idProva");
        model.addAttribute("listprova", provaService.pesquisar());
        return "prova/list-prova";
    }

    @GetMapping("/novo")
    public String novoProva(Model model){
        model.addAttribute("prova", new Prova());
        return "prova/form-prova";
    }

    @GetMapping("/editar/{id}")
    public String editaProva(@PathVariable int id, Model model, HttpSession session){
        session.setAttribute("idProva", id);
        model.addAttribute("prova", provaService.localizar(id));
        return "prova/form-prova";
    }
/*
    @GetMapping("/visualizar/{id}")
    public String visualizaProva(@PathVariable int id, Model model, HttpSession session){
        model.addAttribute("prova", provaService.localizar(id));
        return "prova/visualiza-prova";
    }

 */

    @PostMapping("/salvar")
    public String salvaProva(@ModelAttribute("prova") Prova prova, HttpSession session){
        //prova.setId(session.getAttribute("idProva")==null?0:(int)session.getAttribute("idProva"));
        int i;
        for(i=0;i<prova.getNumeroQuestoes();i++){
            Questoes questao = new Questoes();
            questao.setIdProva(prova.getId());
            questao.setTipo(0);
            questao.setSomatoria(0);
            questoesService.salvar(questao);
        }
        provaService.salvar(prova);
        return "redirect:/prova";
    }

    @GetMapping("/excluir/{id}")
    public String excluirFuncionario(@PathVariable int id){
        provaService.excluir(id);
        return "redirect:/prova";
    }
}
