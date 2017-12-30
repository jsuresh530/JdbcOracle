package com.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DdProperties {
	private static DdProperties instance = null;
	private static Properties properties = null;
	
	/*static
	{
		InputStream is = null;
        try {
        	properties = new Properties();
            is = DdProperties.class.getResourceAsStream("/database.properties");
            properties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}*/

	private DdProperties() {
		properties = new Properties();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/database.properties")));
			properties.load(br);
			//properties.load(new FileInputStream("src/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DdProperties getInstance() {
		if (instance == null) {
			instance = new DdProperties();
		}
		return instance;
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
	
}
