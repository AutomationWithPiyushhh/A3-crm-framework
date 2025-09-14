package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {

	@Test
	public void case1() throws InterruptedException {
//		Report
		Reporter.log("Hey case 1", true);
	}

	@Test
	public void case2() throws InterruptedException {
		Reporter.log("Hey case 2", true);
	}

	@Test
	public void case3() throws InterruptedException {
		Reporter.log("Hey case 3", true);
	}
//	public static void main(String[] args) {
//		System.out.println("hey");
//	}

}
