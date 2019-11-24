package br.com.unifacisa.projetobd2.exceptions;

public class PetShopConnectionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PetShopConnectionException(String msg) {
		super(msg);
	}

}
