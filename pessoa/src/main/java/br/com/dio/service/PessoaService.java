package br.com.dio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.model.Pessoa;
import br.com.dio.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaReposytory;

	
	public Pessoa create(Pessoa pessoa) {
		return pessoaReposytory.save(pessoa);
	}
	
	public Optional<Pessoa> findById(Long id) {
		return pessoaReposytory.findById(id);
	}

	public List<Pessoa> listAll() {
		return (List<Pessoa>) pessoaReposytory.findAll();
	}

	public void delete(Long id) {
		pessoaReposytory.deleteById(id);
		
	}

	public Pessoa update(Pessoa pessoa) {
		return pessoaReposytory.save(pessoa);
	}

	

}
