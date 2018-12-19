package br.com.tecnospeed.tecnojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tecnospeed.tecnojava.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
