package com.senacead.ProjetoIntegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoController {

    @GetMapping("/") //eh definido a URL que sera chamada
    public String inicio() {
        return "index"; //sera apontado o arquivo HTML que sera chamado
    }
      @GetMapping("/inserir") //eh definido a URL que sera chamada
    public String cadastro() {
        return "Cadastro"; //sera apontado o arquivo HTML que sera chamado
    }
}
