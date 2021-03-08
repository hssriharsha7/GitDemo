package pkg_Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.sun.jna.platform.FileUtils;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\sriharsha\\workspace\\E2EProjectPKG\\src\\main\\java\\pkg_Resources\\data.properties");
		
		prop.load(fis);
		String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		
		
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sriharsha\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sriharsha\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	 	}
	
	public void getScreenshotPath(String testCaseName, WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFilePath=System.getProperty(("user.dir")+"\\reports\\"+testCaseName+".png");
		
		FileUtils.copyFile(source, new File(destinationFilePath));
		
		
	}

}
