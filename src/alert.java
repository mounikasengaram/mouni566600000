import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alert {
	WebDriver d;
	@Test
	public void SetUp11() throws Exception{
		 d.get("http://127.0.0.1/orangehrm-2.6/login.php");
		 Assert.assertEquals("OrangeHRM - New Level of HR Management",d.getTitle());
		 System.out.println(d.getCurrentUrl());
		 System.out.println(d.getTitle());
		 d.findElement(By.name("Submit")).click();
		 Alert al=d.switchTo().alert();
		 al.accept();
		 d.findElement(By.name("txtUserName")).sendKeys("admin");
		 d.findElement(By.name("Submit")).click();
		 al.accept();
		 d.findElement(By.name("txtPassword")).sendKeys("admin");
		 d.findElement(By.name("Submit")).click();
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