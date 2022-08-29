package br.gov.sp.fatec.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.demo.entity.Usuario;
import br.gov.sp.fatec.demo.entity.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{
    
    @Autowired
    // ou criar um construtor
    // public SegurancaServiceImpl(usuarioRepository usuarioRepo){
    //   this.usuarioRepo = usuario(mais alguma coisa que n deu tempo, desculpa)
   // }
    private UsuarioRepository usuarioRepo;

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return novoUsuario(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOpitinal = usuarioRepo.findById(id);
        if(usuarioOpitinal.isPresent()){
            return usuarioOpitinal.get();
        }
        throw new RuntimeException("Usuario não encontrado");
    }
    
}
