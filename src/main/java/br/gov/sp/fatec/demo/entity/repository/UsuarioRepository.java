package br.gov.sp.fatec.demo.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
