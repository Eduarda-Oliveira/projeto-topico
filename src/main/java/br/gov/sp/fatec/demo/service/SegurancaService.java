package br.gov.sp.fatec.demo.service;

import java.util.List;

import br.gov.sp.fatec.demo.entity.Usuario;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface SegurancaService extends UserDetailsService {
    
    public Usuario novoUsuario(Usuario usuario);

    public Usuario novoUsuario( String name, String senha);

    public List<Usuario> todosUsuarios();

    public Usuario buscarPorId(Long id);
}
