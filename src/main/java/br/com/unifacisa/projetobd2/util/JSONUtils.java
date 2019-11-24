package br.com.unifacisa.projetobd2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;

public class JSONUtils {

	public static QueryObject readJson(String key) {
		Gson gson = new Gson();
		try (InputStream is = new FileInputStream("src/main/resources/mapped-queries.json")) {
			MappedQueries queries = gson.fromJson(IOUtils.toString(is), MappedQueries.class);
			return queries.getQueryByKey(key);
		} catch (JsonSyntaxException | IOException e) {
			throw new PetShopConnectionException("Não foi possivel encontrar a query.");
		} 
	}
	
}
