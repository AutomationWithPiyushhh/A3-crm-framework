package testng_extra;

import org.testng.annotations.Test;

public class Demo4 {
	@Test(groups = "regression")
	public void case41() {
		System.out.println("41");
	}

	@Test(groups = {"regression", "smoke" })
	public void case42() {
		System.out.println("42");
	}

	@Test(groups = "smoke")
	public void case43() {
		System.out.println("43");
	}

}
