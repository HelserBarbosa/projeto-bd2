package br.com.unifacisa.projetobd2.util;

import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;

public class SQLUtils {

	public static String getExternalQuery(String queryKey) {
		QueryObject qo = JSONUtils.readJson(queryKey);
		if (qo == null) {
			throw new PetShopConnectionException("A query não foi encontrada");
		}
		return qo.getQuery();
	}

}
