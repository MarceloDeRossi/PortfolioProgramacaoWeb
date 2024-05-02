package br.com.portfolio.crud.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Não foi possível localizar o usuário com a identificação "+ id);
	}

}
