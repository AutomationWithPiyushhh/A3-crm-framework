package advance_reports_extra;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Demo {

	@Test(dependsOnMethods = "case3")
	public void case1() {
		Assert.assertTrue(true);
	}

	@Test
	public void case2() {
		Assert.assertTrue(false);
	}

	@Test
	public void case3() {
		Assert.assertTrue(false);
	}
}
