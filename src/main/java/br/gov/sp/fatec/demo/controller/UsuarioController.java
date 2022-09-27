//Controller = responsável oir acionar as partes responsáveis pela regra de negócio e bd a partir das view rotas
package br.gov.sp.fatec.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.demo.entity.Usuario;
import br.gov.sp.fatec.demo.service.SegurancaService;

//@RestController = demardar classes do controller
@RestController
//@RequestMapping = mapeia um endpoint para uma classe
@RequestMapping(value="/usuario")
@CrossOrigin

//HTTPMapping (GetMapping, por exemplo) = mapeia um endpoint para um metodo

public class UsuarioController {
    //@Autowired = permitir a inspeção de dependências do spring
    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Usuario> buscarTodos() {
        return segurancaService.todosUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return segurancaService.buscarPorId(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return segurancaService.novoUsuario(usuario);
    }
}
