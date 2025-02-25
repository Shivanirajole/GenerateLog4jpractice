package LoginFreeCRM;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logintest {
	
	//what is log :capturing info/activitites at the time of program execution
	//types of logs:1 info,2 warn,3 debug,4 fatal
	//how to generate the logs:use Apache log4j API(log4j jar)
	//how it works: it reades the log4j configuration from log4j.properties file
	//where to create:create inside resources folder
	
	
	WebDriver driver = new ChromeDriver();
	Logger log=Logger.getLogger(Logintest.class);

	@BeforeMethod
	public void setup() {

		driver.get("https://freecrm.com/en");
		driver.manage().window().maximize();
		log.info("maximum window");

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.warn("wait sometime");
		log.debug("debug msg");
		log.fatal("fatal msg");
	}

	@Test
	public void clickonlogin() throws InterruptedException {
		
		log.info("********************* Stating Test cases **************");

		WebElement loginbtn = driver.findElement(By.xpath("//a[contains (text(),'Login')]"));
		log.info("click on login button");
		loginbtn.click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
