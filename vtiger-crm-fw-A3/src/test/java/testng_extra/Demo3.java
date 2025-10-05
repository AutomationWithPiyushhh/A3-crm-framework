package testng_extra;

import org.testng.annotations.Test;

public class Demo3 {
	@Test(groups = "regression")
	public void case31() {
		System.out.println("31");
	}

	@Test(groups = "smoke")
	public void case32() {
		System.out.println("32");
	}

	@Test(groups = "system")
	public void case33() {
		System.out.println("33");
	}

}
