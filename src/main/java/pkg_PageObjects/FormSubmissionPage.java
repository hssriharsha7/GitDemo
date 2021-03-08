package pkg_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormSubmissionPage {
	
	WebDriver driver;
	
	public FormSubmissionPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By fullName=By.xpath("//input[@id='user_name']");
	By emailAddress=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By confirmPassword=By.xpath("//input[@id='user_password_confirmation']");
	By receivePromoEmailsCheckbox=By.cssSelector("#user_unsubscribe_from_marketing_emails");
	By iAgreeCheckbox=By.cssSelector("#user_agreed_to_terms");
	By signUPButton=By.xpath("//a[@class='btn btn-theme btn-sm btn-min-block']");
	
	public WebElement getFullName() {
		return driver.findElement(fullName);
		}
	
	public WebElement getEmailAddress() {
		return driver.findElement(emailAddress);
		}
	
	public WebElement getPassword() {
		return driver.findElement(password);
		}
	
	public WebElement getconfirmPassword() {
		return driver.findElement(confirmPassword);
		}
	
	public WebElement getreceivePromoEmailsCheckbox() {
		return driver.findElement(receivePromoEmailsCheckbox);
		}
	
	public WebElement getiAgreeCheckbox() {
		return driver.findElement(iAgreeCheckbox);
		}
	
	public WebElement getsignUPButton() {
		return driver.findElement(signUPButton);
		}
}
