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

public class fileupload {
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
			WebElement g=d.findElement(By.xpath("//li[@id='pim']/a/span"));
			WebElement y=d.findElement(By.xpath("//li[@id='pim']/ul/li[1]/a/span"));
			a.moveToElement(g).click(y).build().perform();
			d.switchTo().frame(0);
			Select dd1=new Select(d.findElement(By.xpath("//select[@id='loc_code']")));
		    dd1.selectByVisibleText("Emp. ID");
		    d.findElement(By.xpath("//input[@id='loc_name']")).sendKeys("0002");
		    String l=d.findElement(By.xpath("//input[@id='loc_name']")).getAttribute("value");
		    System.out.println(l);
		    d.findElement(By.xpath("//form[@id='standardView']/div[2]/input[2]")).click();
		    Thread.sleep(4000);
		    WebElement v=d.findElement(By.xpath("//form[@id='standardView']/table/tbody/tr/td[3]/a"));
		    System.out.println(v.isDisplayed());
		    System.out.println(v.getText());
		    d.findElement(By.xpath("//form[@id='standardView']/table/tbody/tr/td[3]/a")).click();
		    d.findElement(By.xpath("//input[@id='btnEditPers']")).click();
		    d.findElement(By.xpath("//input[@id='txtEmpFirstName']")).sendKeys("mouniiiii");
		    d.findElement(By.className("savebutton")).click();
		    Thread.sleep(3000);
		    d.findElement(By.xpath("//span[@id='empname']")).click();
		    Thread.sleep(3000);
		    d.findElement(By.xpath("//input[@id='photofile']")).click();
		    Thread.sleep(3000);
		    new ProcessBuilder("D:\\selenium\\autoit\\uploadhrm12.exe").start(); 
			Thread.sleep(3000);
		   d.findElement(By.xpath("//*[@id='photo']/div[1]/div[2]/div[2]/div/input")).click();
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