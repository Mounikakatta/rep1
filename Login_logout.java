package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login_logout {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		driver=new FirefoxDriver();
	    driver.get("http://192.168.1.124:85");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div/input[@id='txtUsername']")).sendKeys("afzalpurapmc");
	    driver.findElement(By.xpath("//div/input[@id='txtPassword']")).sendKeys("vsspl");
	    driver.findElement(By.xpath("//td/em/button[@id='ext-gen16']")).click();
        Thread.sleep(3000); 
	}
	
	@Test
  public void f() {
		driver.findElement(By.xpath("//div/div/div/span[contains(text(),'Administration')]")).click();	
  }
   @AfterTest
  public void afterTest() {
	 WebElement ee = driver.findElement(By.xpath("html/body/form/div[1]/div/div/div/table/tbody/tr/td[3]/table/tbody/tr/td/table[1]/tbody/tr/td/div[3]/span/a"));
	   ee.click();
	  //driver.quit();
  }

}
