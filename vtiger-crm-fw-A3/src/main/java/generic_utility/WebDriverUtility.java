package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this utility method will help to move the mouse controller to the middle of the element. 
	 * 
	 * @param target element to move to. 
	 * 
	 * @return A self reference.
	 * 
	 * @author random guy
	 */
	public void hover(WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
	}

}
