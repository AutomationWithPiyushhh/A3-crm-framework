package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		Get the java rep object of the physical file
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\commondata.properties");

//		by using load(), Load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		fetch all the values by using getProperty("key")
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}
}
