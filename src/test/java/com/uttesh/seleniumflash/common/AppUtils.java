package com.uttesh.seleniumflash.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Uttesh Kumar T.H.
 */

public class AppUtils {

	
	static Properties prop = new Properties();
	static InputStream input = null;
	

	public static void loadProperties() throws IOException{
		input = new FileInputStream("app.properties");
		prop.load(input);
	}
        
        public static void loadSikuliDlls(){
            System.load("sikulidlls");
        }
	
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
}
