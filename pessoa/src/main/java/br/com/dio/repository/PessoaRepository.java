package br.com.dio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.dio.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
