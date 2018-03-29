package cl.camiletti.happyFeetWeb.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilProperties {

	private java.util.Properties prop = new Properties();

	public UtilProperties() {
		String path = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0 ? "c:/app/happyFeet.properties"
				: "/opt/tomcat/prop/happyFeet.properties";
		try {
			prop.load(new FileInputStream(path));
		} catch (IOException e) {
			// LOGGER.error("Error al buscar archivo Properties " + e.getMessage() +
			// e.getCause());
		}
	}

	public String getProperty(String property) {
		return prop.getProperty(property);
	}

}