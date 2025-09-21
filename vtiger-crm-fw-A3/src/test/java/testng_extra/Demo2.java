package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {

	@Test(invocationCount = 2)
	public void case1() throws InterruptedException {
		System.out.println("Hey");
	}

	@Test
	public void case2() throws InterruptedException {
		System.out.println("How are you !!!");
	}

	@Test(enabled = false)
	public void case3() throws InterruptedException {
		System.out.println("I am fine !!!");
	}

}
