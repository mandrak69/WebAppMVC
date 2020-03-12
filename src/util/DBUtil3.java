package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBUtil3 {

	private Properties properties;
	private static DBUtil3 instance;
	private DBUtil3() throws FileNotFoundException, IOException {
		properties=new Properties();
		properties.load(new FileInputStream("db.properties"));
	}
	public static DBUtil3 getInstance() throws FileNotFoundException, IOException {
		if(instance==null) {
			instance=new DBUtil3();
		}
		return instance;
	}
	
	public String getDriver() {
		String izvor=properties.getProperty("izvor");
		String driverKey=izvor+"_driver";
		return properties.getProperty(driverKey);
	}
	
	public String getURL() {
		String izvor=properties.getProperty("izvor");
		String urlKey=izvor+"_url";
		return properties.getProperty(urlKey);
	}
	
	public String getUser() {
		String izvor=properties.getProperty("izvor");
		String userKey=izvor+"_user";
		return properties.getProperty(userKey);
	}
	
	public String getPassword() {
		String izvor=properties.getProperty("izvor");
		String passwordKey=izvor+"_password";
		return properties.getProperty(passwordKey);
	}
	public String getConnectionFactory() {
		String izvor=properties.getProperty("izvor");
		String connectionFactoryKey=izvor+"_connectionFactory";
		return properties.getProperty(connectionFactoryKey);
	}
}
