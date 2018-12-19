package br.com.tecnospeed.tecnojava.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tecnospeed.tecnojava.model.Autor;
import br.com.tecnospeed.tecnojava.repository.AutorRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private AutorRepository autorRepository;

	@Override
	public void run(String... args) throws Exception {
		inserirDados();
	}

	public DataLoader(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	private void inserirDados() {
		Autor autor = new Autor();
		autor.setNome("André Luiz");
		autorRepository.save(autor);
		
		Autor autor2 = new Autor();
		autor2.setNome("Aline Priscila");
		autorRepository.save(autor2);
		
		Autor autor3 = new Autor();
		autor3.setNome("Gabriel Henrique");
		autorRepository.save(autor3);
		
	
	}
	
	

}
