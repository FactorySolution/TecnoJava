package br.com.tecnospeed.tecnojava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecnospeed.tecnojava.model.Autor;
import br.com.tecnospeed.tecnojava.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutoresResource {

	@Autowired
	private AutorRepository autorRepository;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Autor> listar() {
		List<Autor> autor = autorRepository.findAll();
		return autor;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Autor autor(@PathVariable("id") Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isPresent())
			return autor.get();
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		autorRepository.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Autor update(@RequestBody Autor autor, @PathVariable("id") Long id) {
		autor.setId(id);
		autorRepository.save(autor);
		return autor;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Autor create(@RequestBody Autor autor) {
		autorRepository.save(autor);
		return autor;
	}

}
