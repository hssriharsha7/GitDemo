package pkg_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	// TODO Auto-generated constructor stub
		public LoginPageObjects(WebDriver driver) {
			this.driver=driver;
		}
	
	
	By emailID=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By loginBtn=By.xpath("//input[@name='commit']");
	
	

	public WebElement getEmailLocator() {
		return driver.findElement(emailID);
	}

	public WebElement getPasswordLocator() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtnLocator() {
		return driver.findElement(loginBtn);
		
	}
			
}
