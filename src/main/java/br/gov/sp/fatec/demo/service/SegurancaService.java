package br.gov.sp.fatec.demo.service;

import java.util.List;

import br.gov.sp.fatec.demo.entity.Usuario;

public interface SegurancaService {
    
    public Usuario novoUsuario(Usuario usuario);

    public Usuario novoUsuario( String name, String senha);

    public List<Usuario> todosUsuarios();

    public Usuario buscarPorId(Long id);
}
