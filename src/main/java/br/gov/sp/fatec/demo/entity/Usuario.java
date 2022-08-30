package br.gov.sp.fatec.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usr_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome")
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    //O Lazy é o mais comum, onde a consulta só é feita quando necessario, no EAGER ela é feita smepre q a p é carregada, o que pode levar a lentidão
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  // Usado para mapear uma tabela de ligação (só se mapeia de um lado)
        name = "uau_usuario_autorizacao",
        joinColumns = { @JoinColumn(name = "usr_id")},
        inverseJoinColumns = { @JoinColumn(name = "aut_id")}
    )
    private Set<Autorizacao> autorizacoes;

    //Gerar getters and setters botão direito, source Action 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
}
