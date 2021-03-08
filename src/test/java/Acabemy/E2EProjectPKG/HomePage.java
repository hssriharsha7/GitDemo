package Acabemy.E2EProjectPKG;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pkg_PageObjects.FormSubmissionPage;
import pkg_PageObjects.LandingPage;
import pkg_PageObjects.LoginPageObjects;
import pkg_Resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	public LoginPageObjects loginObj;
	public LandingPage landObj;
	public FormSubmissionPage formSubPageObj;
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("Browser initialized");
		
		driver.get(prop.getProperty("urlName"));
		log.info("URL opened");
		driver.manage().window().maximize();
		log.info("Browser window maximized");
	}
	
	
	@Test
	public void basePageNavigation() throws IOException {
		
		landObj=new LandingPage(driver);
		landObj.login().click();
		
		}
	
	@Test(dataProvider="getData")
	
	public void loginToAccount(String usrName, String pwd) {
		loginObj=new LoginPageObjects(driver);
		log.info("Login method opened");
	    loginObj.getEmailLocator().sendKeys(usrName);
	    log.info("Email Entered");
		loginObj.getPasswordLocator().sendKeys(pwd);
		log.info("Password entered");
		loginObj.getLoginBtnLocator().click();
		log.info("Login button clicked");
		driver.navigate().back();
		driver.navigate().back();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data=new Object[1][2];
		
		data[0][0]="haasriharsha7@gmail.com";
		data[0][1]="Harsha@1993";
		
		return data;
		
	}
	
	@AfterClass
	
	public void closeBrowser() {
		log.info("Browser about close");
		driver.close();
		log.info("Browser closed");
	}
	

}
