package com.info.FuncionarioConsumer.controller;

import com.info.FuncionarioConsumer.model.Tabelas;
import com.info.FuncionarioConsumer.service.TabelasService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tabelas")
public class TabelasController {
    @Autowired
    TabelasService tabelasService;

    @GetMapping("")
    public String editaTabela(Model model, HttpSession session){
        session.setAttribute("idTabelas", 1);
        model.addAttribute("tabelas", tabelasService.localizar(1));
        return "tabelas";
    }

    @PostMapping("/salvar")
    public String salvaTabelas(@ModelAttribute("tabelas") Tabelas tabelas, HttpSession session){
        tabelasService.salvar(tabelas);
        return "redirect:/tabelas";
    }

}
