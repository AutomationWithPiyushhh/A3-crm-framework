package extra_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithHardAssert {
	@Test
	public void case1() {

		boolean status1 = true;
		boolean status2 = false;

		String a = "abc";
		String b = "pqr";
		String c = "xyz";
		String d = "abc";

		Object obj1 = null;
		Object obj2 = new Object();

		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals(a, d);
		Assert.assertNotEquals(a, c);
		
		Assert.assertNull(obj1);
		Assert.assertNotNull(obj2);

	}

}
