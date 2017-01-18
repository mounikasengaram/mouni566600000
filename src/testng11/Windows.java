package testng11;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows {
WebDriver d;
@Test
public void SetUp11() throws Exception{
	d.get("http://www.seleniumhq.org/");
WebElement ff=d.findElement(By.linkText("Projects"));
WebElement gg=d.findElement(By.linkText("Download"));
Actions a=new Actions(d);
a.moveToElement(ff).keyDown(Keys.CONTROL).click().perform();
a.moveToElement(gg).keyDown(Keys.CONTROL).click().perform();
d.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"\t");
Thread.sleep(3000);
d.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"\t");
Thread.sleep(3000);
d.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"\t");
Thread.sleep(3000);
d.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"\t");
}
@Before
public void SetUp3(){
	d=new FirefoxDriver();
}
@After
public void SetUp1(){
	
}
}