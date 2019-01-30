package com.algaworks.comercial.exceptions;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4973131946845988224L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

	public NotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
