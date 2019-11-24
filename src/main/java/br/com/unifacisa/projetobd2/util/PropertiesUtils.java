package br.com.unifacisa.projetobd2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Properties prop = new Properties();

	private PropertiesUtils() {
	}
	
	public static Properties getProperties(String pathToPropertieFile) {
		try (InputStream input = new FileInputStream(pathToPropertieFile)) {
			prop.load(input);
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Properties getProperties() {
		return getProperties("src/main/resources/application.properties");
	}
	
	public static String getStringPropertie(String propertyName) {
		return getProperties().getProperty(propertyName);
	}

}
