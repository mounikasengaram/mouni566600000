import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class movetoelement11 {
	WebDriver d;
	@Test
	public void SetUp11() throws Exception{
		 d.get("http://127.0.0.1/orangehrm-2.6/login.php");
		 Assert.assertEquals("OrangeHRM - New Level of HR Management",d.getTitle());
		 System.out.println(d.getCurrentUrl());
		 System.out.println(d.getTitle());
		 //username
		 d.findElement(By.name("txtUserName")).sendKeys("admin");
		 //password
		 d.findElement(By.name("txtPassword")).sendKeys("admin");
		 //login
		 d.findElement(By.name("Submit")).click();
		 //verifypage
			WebElement loginpage=d.findElement(By.id("companyLogoHeader"));
			System.out.println(loginpage.isDisplayed());
			Actions a=new Actions(d);
			WebElement ff=d.findElement(By.xpath("//li[@id='leave']/a/span"));
			WebElement gg=d.findElement(By.xpath("//li[@id='leave']/ul/li[1]/a/span"));
			a.moveToElement(ff).moveToElement(gg).click(d.findElement(By.xpath("//li[@id='leave']/ul/li[1]/ul/li/a/span"))).build().perform();
			Thread.sleep(3000);
			d.switchTo().frame(0);
			Select dd=new Select(d.findElement(By.xpath("//select[@name='year']")));
			dd.selectByVisibleText("2018");
			dd.getOptions();
			d.findElement(By.xpath("//input[@id='btnView']")).click();
			Thread.sleep(3000);
		 //  d.switchTo().frame("iframe");
		  // Assert.assertTrue(d.findElement(By.xpath("//div[@class='mainHeading']/h2)")).getText().matches("Leave Summary for All Employees for 2018"));

}
	
@BeforeMethod()
public void SetUp3(){
	d=new FirefoxDriver();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	d.manage().window().maximize();
}

@AfterMethod()
public void SetUp1(){
	d.quit();

}}