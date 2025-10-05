package contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;

public class CreateContactTest extends BaseClass {
	@Test
	public void createConTest() throws IOException {
		FileUtility fUtil = new FileUtility();
		String lastName = fUtil.getDataFromExcelFile("Contact", 5, 0);

//		Create new contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		Fill the form to create the contact
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.className("save")).click();

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(actLastName, lastName);
	}
}
