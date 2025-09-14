package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {

	@Test
	public void case1() throws InterruptedException {
//		Console
		System.out.println("hey case 1");
//		Report
		Reporter.log("Hey case 1");
	}

	@Test
	public void case2() throws InterruptedException {
		System.out.println("hey case 2");
		Reporter.log("Hey case 2");
	}

	@Test
	public void case3() throws InterruptedException {
		System.out.println("hey case 3");
		Reporter.log("Hey case 3");
	}
//	public static void main(String[] args) {
//		System.out.println("hey");
//	}

}
