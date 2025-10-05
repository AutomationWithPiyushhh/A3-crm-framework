package testng_extra;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo5 {
	
	
	@Parameters({"un","pwd"})
	@Test
	public void login(String un, String pwd) {
//		String un = "admin";
//		String pwd = "manager";
		
		System.out.println(un);
		System.out.println(pwd);
		
	}
}
