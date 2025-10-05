package config_annotations;

import org.testng.annotations.Test;

public class LeadsTest extends BaseClass{	
	@Test
	public void createLeadsTest() {
		System.out.println("star");
	}

	@Test
	public void modifyLeadsTest() {
		System.out.println("rectangle");
	}
	
	@Test
	public void deleteLeadsTest() {
		System.out.println("square");
	}
}
