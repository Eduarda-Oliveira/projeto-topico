package br.gov.sp.fatec.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.demo.entity.Usuario;
import br.gov.sp.fatec.demo.repository.UsuarioRepository;
import br.gov.sp.fatec.demo.entity.Autorizacao;
import br.gov.sp.fatec.demo.repository.AutorizacaoRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{
    
    @Autowired
    // ou criar um construtor
    // public SegurancaServiceImpl(usuarioRepository usuarioRepo){
    //   this.usuarioRepo = usuario(mais alguma coisa que n deu tempo, desculpa)
   // }
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("isAuthenticated()")
    public List<Usuario> todosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOpitinal = usuarioRepo.findById(id);
        if(usuarioOpitinal.isPresent()){
            return usuarioOpitinal.get();
        }
        throw new RuntimeException("Usuario não encontrado");
    }
    
    @Override
    @Transactional
    public Usuario novoUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        return novoUsuario(usuario);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if (usuario == null) {
          throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
            .authorities(usuario.getAutorizacoes().stream()
                .map(Autorizacao::getNome).collect(Collectors.toList())
                .toArray(new String[usuario.getAutorizacoes().size()]))
            .build();
    }
}
