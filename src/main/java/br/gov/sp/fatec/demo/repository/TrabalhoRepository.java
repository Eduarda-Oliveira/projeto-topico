package br.gov.sp.fatec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.demo.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    public Trabalho findByTitulo(String titulo);

    public Trabalho findByNotaGreaterThan(int nota);

}
