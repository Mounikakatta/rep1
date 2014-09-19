package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Action {
  public WebDriver driver;
  
  
	@BeforeTest
	  public void beforeTest() throws Exception{
		driver=new FirefoxDriver();
	    driver.get("http://192.168.1.124:85");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div/input[@id='txtUsername']")).sendKeys("afzalpurapmc");
	    driver.findElement(By.xpath("//div/input[@id='txtPassword']")).sendKeys("vsspl");
	    driver.findElement(By.xpath("//td/em/button[@id='ext-gen16']")).click();
            Thread.sleep(3000); 
            driver.findElement(By.xpath("//div/div/div/span[contains(text(),'Administration')]")).click();
            driver.findElement(By.xpath("//a/span[contains(text(),'Action Plan')]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().frame("4049_IFrame");
	  }
	  
	@SuppressWarnings("deprecation")
	@Test(invocationCount=3)
  public void f()throws Exception {
	    driver.findElement(By.xpath("//td/em/button[contains(text(), 'New Record')]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//img[@id='ext-gen203']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//td[@class='x-btn-center']/em[@unselectable='on']/button[contains(text(),'September 2014')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//td[@class='x-date-mp-month']/a[contains(text(),'Apr')]")).click();
	    driver.findElement(By.xpath("//td[@class='x-date-mp-year x-date-mp-sel']/a[contains(text(),'2014')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'16')]")).click();
	    driver.findElement(By.xpath("//img[@id='ext-gen213']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@id='developmentPlanningWindow_cmbFinancialYear_Container']")).click();
	    driver.findElement(By.xpath("//img[@id='ext-gen213']")).click();
	    Thread.sleep(1000);
	    //Financial year Drop down
	    //driver.findElement(By.xpath("html/body/div[6]/div/div[5]")).click();
	    driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'Apr  1 2012_Mar 31 2013')]")).click();
	    driver.findElement(By.xpath("//div/input[@id='developmentPlanningWindow_txtWorkName']")).sendKeys("Car ways");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@id='ext-gen229']")).click();
	    //Scheme name Drop down
	    Thread.sleep(1000);
	    //driver.findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']")).click();
	    driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'RKKY ')]")).click();
	    driver.findElement(By.xpath("//div/input[@id='developmentPlanningWindow_txtWorkValue']")).sendKeys("650000");
	    driver.findElement(By.xpath("//div/textarea[@id='developmentPlanningWindow_txtWorkDetails']")).sendKeys("Roads construction");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();   
	    Thread.sleep(1000);
	    try{
	    	WebDriverWait Wait = new WebDriverWait(driver,20);
	    	Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ext-mb-text']")));
	    	
	      	WebElement r = driver.findElement(By.xpath("//span[contains(text(),'Action plan details has been saved successfully')]"));
		    String str= r.getText();
		    System.out.println(str);
		    Assert.assertEquals("Action plan details has been saved successfully",str);
	    }
	    catch (Exception e){
	    	System.out.println("Failed" +e.getMessage());
	    }	    	
	    driver.findElement(By.xpath("//td/em/button[contains(text(),'OK')]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
	    Thread.sleep(1000);		
  }
  
  @SuppressWarnings("deprecation")
	@Test(enabled= false)
  public void E()throws Exception {
			driver.findElement(By.xpath("//a/span[contains(text(),'Action Plan')]")).click();
		    Thread.sleep(2000);
		    driver.switchTo().frame("4049_IFrame");
		    driver.findElement(By.xpath("//div[contains(text(),'Street lights')]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[contains(text(),'Edit Record')]")).click();
		    driver.findElement(By.xpath("//input[@id='developmentPlanningWindow_txtWorkValue']")).clear();
		    driver.findElement(By.xpath("//input[@id='developmentPlanningWindow_txtWorkValue']")).sendKeys("435126");
		    driver.findElement(By.xpath("//textarea[@id='developmentPlanningWindow_txtWorkDetails']")).clear();
		    driver.findElement(By.xpath("//textarea[@id='developmentPlanningWindow_txtWorkDetails']")).sendKeys("Action plan work details");
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		    WebElement e = driver.findElement(By.xpath("//span[@id='Action plan details has been saved successfully']"));
		    String str= e.getText();
		    System.out.println(str);
		    Assert.assertEquals("Action plan details has been saved successfully", str);
		    driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
  }
  @AfterTest
  public void Logout() throws Exception{
	  driver.findElement(By.xpath("//span/a[contains(text(),'| LogOff')]")).click();
	 	  //driver.quit();
	  
	  
  }

}
