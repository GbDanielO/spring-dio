package br.com.dio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7503967365259345134L;

	
	public ResourceNotFoundException(String recurso, Long id) {
        super(String.format(recurso + " não encontrado!", id));
    }
}
