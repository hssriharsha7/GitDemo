package pkg_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	// TODO Auto-generated constructor stub
		public LandingPage(WebDriver driver) {
			this.driver=driver;
		}
	
	By signIn=By.cssSelector("a[href*='sign_in']");
	By signUpClick=By.xpath("btn btn-theme btn-sm btn-min-block");

	
	

	public WebElement login() {
		return driver.findElement(signIn);
	}
	
	public WebElement clickOnJoinNow() {
		return driver.findElement(signUpClick);
	}
	
}
