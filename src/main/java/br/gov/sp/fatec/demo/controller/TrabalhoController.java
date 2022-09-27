package br.gov.sp.fatec.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.demo.entity.Trabalho;
import br.gov.sp.fatec.demo.service.SegurancaService;

@RestController
@RequestMapping(value="/trabalho")
@CrossOrigin

public class TrabalhoController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Trabalho> todosTrabalhos() {
        return segurancaService.todosTrabalhos();
    }

    @GetMapping(value = "/{x}")
    public Trabalho findByNotaGreaterThan(@PathVariable("x") int x) {
        return segurancaService.findByNotaGreaterThan(x);
    }

}
