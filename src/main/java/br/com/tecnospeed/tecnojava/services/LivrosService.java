package br.com.tecnospeed.tecnojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tecnospeed.tecnojava.model.Livro;
import br.com.tecnospeed.tecnojava.repository.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;

	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	public Livro buscar(Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);

		if (!livro.isPresent()) {
			throw new RuntimeException("O livro não pôde ser encontrado.");
		}

		return livro.get();
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}

	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("O livro não pôde ser encontrado.");
		}
	}

	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}

	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	/*
	 * public Comentario salvarComentario(Long livroId, Comentario comentario) {
	 * Livro livro = buscar(livroId);
	 * 
	 * comentario.setLivro(livro); comentario.setData(new Date());
	 * 
	 * return comentariosRepository.save(comentario); }
	 * 
	 * public List<Comentario> listarComentarios(Long livroId) { Livro livro =
	 * buscar(livroId);
	 * 
	 * return livro.getComentarios(); }
	 */

}
