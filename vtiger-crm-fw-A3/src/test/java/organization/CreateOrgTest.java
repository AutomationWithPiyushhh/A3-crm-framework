package organization;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrgTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {

		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getDataFromExcelFile("Org", 8, 0) + (int) (Math.random() * 9999);

		HomePage hp = new HomePage(driver);
		OrgPage op = new OrgPage(driver);
		VerifyOrgPage vop = new VerifyOrgPage(driver);

//		Create an organization
		hp.getOrgLink().click();
		op.getPlusIcon().click();
		WebElement orgField = op.getOrgField();
		orgField.sendKeys(orgName);
		op.getSaveBtn().click();

//		verification
		String actOrgName = vop.getActOrgName();
		Assert.assertEquals(actOrgName, orgName);
	}

}
