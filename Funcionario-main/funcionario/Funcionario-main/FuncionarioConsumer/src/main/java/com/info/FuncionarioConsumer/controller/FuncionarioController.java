package com.info.FuncionarioConsumer.controller;

import com.info.FuncionarioConsumer.model.CalculaFolha;
import com.info.FuncionarioConsumer.model.Funcionario;
import com.info.FuncionarioConsumer.model.Tabelas;
import com.info.FuncionarioConsumer.service.FuncionarioService;
import com.info.FuncionarioConsumer.service.TabelasService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private TabelasService tabelasService;

    @GetMapping("")
    public String listarFuncionario(Model model, HttpSession session) {
        session.removeAttribute("idFuncionario");
        List<Funcionario> listFuncionario = funcionarioService.pesquisar();
        List<CalculaFolha> listCF = new ArrayList<>();
        Tabelas tabelas = tabelasService.localizar(1);
        for(Funcionario funcionario : listFuncionario){
            CalculaFolha cf = new CalculaFolha();
            cf.setFuncionario(funcionario);
            cf.setTabela(tabelas);
            cf.calcula();
            listCF.add(cf);
        }
        model.addAttribute("listcalculos", listCF);
        return "list-funcionario";
    }

    @GetMapping("/novo")
    public String novoFuncionario(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return "form-funcionario";
    }

    @GetMapping("/editar/{id}")
    public String editaFuncionario(@PathVariable int id, Model model, HttpSession session){
        session.setAttribute("idFuncionario", id);
        model.addAttribute("funcionario", funcionarioService.localizar(id));
        return "form-funcionario";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizaFuncionario(@PathVariable int id, Model model, HttpSession session){
        session.setAttribute("idFuncionario", id);
        Funcionario funcionario = funcionarioService.localizar(id);
        Tabelas tabelas = tabelasService.localizar(1);
            CalculaFolha cf = new CalculaFolha();
            cf.setFuncionario(funcionario);
            cf.setTabela(tabelas);
            cf.calcula();
        model.addAttribute("cf", cf);
        model.addAttribute("funcionario", funcionario);
        return "holerite";
    }

    @PostMapping("/salvar")
    public String salvaFuncionario(@ModelAttribute("funcionario") Funcionario funcionario, HttpSession session){
        //funcionario.setId(session.getAttribute("idFuncionario")==null?0:(int)session.getAttribute("idFuncionario"));
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionario";
    }

    @GetMapping("/excluir/{id}")
    public String excluirFuncionario(@PathVariable int id){
        funcionarioService.excluir(id);
        return "redirect:/funcionario";
    }
}
