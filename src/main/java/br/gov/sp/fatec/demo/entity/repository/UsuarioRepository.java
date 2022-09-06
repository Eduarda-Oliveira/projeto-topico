package br.gov.sp.fatec.demo.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.demo.entity.Usuario;

//Em uma interface não se pode ter lógica, apenas a declaração
//Mas ele entende que algo é uma onsulta dese que o o nome comece com find, query By ou get
//Caso quisesse pegar um usuario pelo nome, poderiamos ter o metodo 
//public findByNome(String nome)
//Caso quisesse pegar um usuario pelo nome, mas sem saber exatamente o nome completo (como um Like) 
//public List findByNomeContains(String nome)
//O contains vai retornar todos os usuarios cujo nome contenha aquela string
//Caso quisesse pegar um nome E senha de um usuario, 
//public findByNomeAndSenha(String nome, String senha)
//Caso quisesse pegar um nome que contanha aquela srting E uma senha exata de um usuario, 
//public findByContainsNomeAndSenha(String nome, String senha)
//Caso quisesse pegar um nome OU senha de um usuario, 
//public findByNomeOrSenha(String nome, String senha)

//Para fazer uma consulta, mas passando um nome diferente dos padrões acima podemos usar JPQL
// "?1" significa primeiro parametro do metodo 
//@Query("select us from Usuario us where us.nome = ?1")
//public Usuario buscarPorNome(String nome)

//Para fazer um Join, usamos o atributo
//findByAutorizacoesNome(String aut)
//o que é seria assim em SQL
//slect us * from usr_usuario us Join uau_usuario_autorizacao ua
// on us.usr_id = ua.usr_id Join aut_autorizacao a 
// on ua.aut_id = a.aut_id
// where a.aut_nome = " "

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario findByNome(String nome);
    
    @Query("select us from Usuario us where us.nome = ?1")
    public Usuario buscarPorNome(String nome);
    
    public List<Usuario> findByNomeContains(String nome);

    public List<Usuario> findByAutorizacoesNome(String autorizacao);

    @Query("select us from Usuario us join us.autorizacoes au where au.nome= ?1")
    public List<Usuario> buscarPorAutorizacao(String autorizacao);

}
