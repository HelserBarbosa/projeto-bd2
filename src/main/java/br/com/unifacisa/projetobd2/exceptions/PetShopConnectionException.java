package br.com.unifacisa.projetobd2.exceptions;

import java.sql.Connection;
import java.sql.SQLException;

public class PetShopConnectionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PetShopConnectionException(String msg) {
        super(msg);
    }

    public static void handlePetShopConnectionException(Exception e) {
        throw new PetShopConnectionException(e.getMessage() + ", " + e);
    }

}
