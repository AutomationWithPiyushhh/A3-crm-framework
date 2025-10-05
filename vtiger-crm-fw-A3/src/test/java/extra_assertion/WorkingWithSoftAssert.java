package extra_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithSoftAssert {
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


		SoftAssert sa = new SoftAssert();

		sa.assertTrue(status2);
		sa.assertFalse(status1);
		
		sa.assertEquals(a, c);
		sa.assertNotEquals(a, b);
		
		sa.assertNull(obj2);
		sa.assertNotNull(obj1);
		
		
		sa.assertAll();
	}

}
