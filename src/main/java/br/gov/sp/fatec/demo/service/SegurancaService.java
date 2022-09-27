package br.gov.sp.fatec.demo.service;

import java.util.List;

import br.gov.sp.fatec.demo.entity.Trabalho;
import br.gov.sp.fatec.demo.entity.Usuario;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface SegurancaService extends UserDetailsService {
    
    public Usuario novoUsuario(Usuario usuario);

    public Usuario novoUsuario( String name, String senha);

    public Usuario novoUsuario(String nome, String senha, String autorizacao);
    
    public List<Usuario> todosUsuarios();

    public List<Trabalho> todosTrabalhos();

    public Usuario buscarPorId(Long id);

    public  Trabalho findByNotaGreaterThan(int x);
}
