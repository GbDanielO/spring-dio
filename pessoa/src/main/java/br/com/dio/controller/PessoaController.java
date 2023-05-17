package br.com.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.exception.ResourceNotFoundException;
import br.com.dio.model.Pessoa;
import br.com.dio.service.PessoaService;

@RestController
@RequestMapping(path = "/api/v1/pessoas")
public class PessoaController {

	public final String resource = "Pessoa";
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Pessoa create(@RequestBody @Validated Pessoa pessoa) {
		return pessoaService.create(pessoa);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pessoa findById(@PathVariable Long id) throws ResourceNotFoundException {
		if(pessoaService.findById(id).isPresent()) {
			return pessoaService.findById(id).get();
		} else {
			throw new ResourceNotFoundException(resource, id);
		}
	}

	@GetMapping
	public List<Pessoa> listAll() {
		return pessoaService.listAll();
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public Pessoa update(@RequestBody @Validated Pessoa pessoa) {
		return pessoaService.update(pessoa);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		pessoaService.delete(id);
	}
}
