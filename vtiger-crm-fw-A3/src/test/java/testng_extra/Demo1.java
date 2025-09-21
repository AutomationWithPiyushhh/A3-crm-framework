package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {

	@Test(invocationCount = 5)
	public void create() throws InterruptedException {
		System.out.println("create Pant samrajya");
		Assert.assertTrue(true);
	}

	@Test(invocationCount = 3)
	public void modify() throws InterruptedException {
		System.out.println("Pant -> Mahishmati");
	}

	@Test(invocationCount = 0)
	public void delete() throws InterruptedException {
		System.out.println("Delete mahishmati");
	}


}
