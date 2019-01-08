package br.com.tecnospeed.tecnojava.bootstrap;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tecnospeed.tecnojava.model.Autor;
import br.com.tecnospeed.tecnojava.model.Livro;
import br.com.tecnospeed.tecnojava.repository.AutoresRepository;
import br.com.tecnospeed.tecnojava.repository.LivrosRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private AutoresRepository autorRepository;
	private LivrosRepository livroRepostitory;

	@Override
	public void run(String... args) throws Exception {
		inserirDados();
	}

	public DataLoader(AutoresRepository autorRepository, LivrosRepository livroRepostitory) {
		this.autorRepository = autorRepository;
		this.livroRepostitory = livroRepostitory;
	}

	private void inserirDados() {
		
		Autor autor = new Autor();
		autor.setNome("André Luiz");
		autor.setNacionalidade("BR");
		autor.setNascimento(new Date());
		autorRepository.save(autor);

		Livro livro = new Livro();

		livro.setAutor(autor);
		livro.setEditora("Tecnospeed");
		livro.setNome("Java é bom");
		livro.setPublicacao(new Date());
		livro.setResumo("Livro bão de mais");

		livroRepostitory.save(livro);

	}

}
