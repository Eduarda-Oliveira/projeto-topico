package br.gov.sp.fatec.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {

    public Autorizacao(String nome){
        this.nome = nome;
    }

    public Autorizacao(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @Column(name = "aut_nome")
    private String nome;

    //mappedBy mostra onde essa relação das tabelas foi mapeada
    @ManyToMany(fetch= FetchType.LAZY, mappedBy = "autorizacoes")
    @JsonIgnore //para evitar que entre num loop infinito (onde ao pegar uma autorização relacionada a um usuario, ele ve o usuriao e busca a autorização dele... infinito e além)
    private Set<Usuario> usuarios;

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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
