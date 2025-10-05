package listeners_extra;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_extra.List_Imple.class)
public class Demo1 {
	@Test
	public void case1() {
		System.out.println("case1 started executing");
		Assert.assertTrue(true);
	}

	@Test
	public void case2() {
		System.out.println("case2 started executing");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "case2")
	public void case3() {
		System.out.println("case3 started executing");
		Assert.assertTrue(false);
	}
}








