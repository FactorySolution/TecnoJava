package br.com.tecnospeed.tecnojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecnospeed.tecnojava.model.Autor;
import br.com.tecnospeed.tecnojava.repository.AutoresRepository;


@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}	
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a.isPresent()) {
				throw new RuntimeException("O autor já existe.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(!autor.isPresent()) {
			throw new RuntimeException("O autor não pôde ser encontrado.");
		}
		return autor.get();
	}
	
	public void deletar(Long id) {
		autoresRepository.deleteById(id);;
	}
}