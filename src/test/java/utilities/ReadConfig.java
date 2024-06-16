package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop = new Properties();
	
	String path ="F:\\Automation Testing\\PomWithDataDrivenTesting\\Configuration\\config.properties";
	
	public ReadConfig(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBaseUrl() {
		String valueUrl = prop.getProperty("baseUrl");
		
		if(valueUrl!=null) {
			return valueUrl;
		}else {
			throw new RuntimeException("Url not found in config file");
		}
	}
	
	public String getBrowserName() {
		String valueBrowserName = prop.getProperty("browser");
		if(valueBrowserName!=null) {
			return valueBrowserName;
		}else {
			throw new RuntimeException("browser not found in config file!!..");
		}
	}
	
	
	public String getEmail() {
		String emailAddress = prop.getProperty("email");
		
		if(emailAddress!=null) {
			return emailAddress;
		}else {
			throw new RuntimeException("Email address notfound!!!");
		}
	}
	
	public String getPassword() {
		String password = prop.getProperty("password");
		if(password!=null) {
			return password;
		}else {
			throw new RuntimeException("Password not found in properties file!!!...");
		}
	}
}
