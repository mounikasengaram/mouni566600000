import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class importhrms {
	WebDriver d;
	@Test
	public void SetUp11() throws Exception{
		 d.get("http://127.0.0.1/orangehrm-2.6/login.php");
		 Assert.assertEquals("OrangeHRM - New Level of HR Management",d.getTitle());
		 System.out.println(d.getCurrentUrl());
		 System.out.println(d.getTitle());
		 FileInputStream fis=new FileInputStream("D:\\selenium\\testresults\\book1jx.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		 Sheet sh=wb.getSheet(0);
		 int totalnoofrows=sh.getRows();
		 System.out.println(totalnoofrows);
		 int totalnoofcolumns=sh.getColumns();
		 System.out.println(totalnoofcolumns);
		 for(int i=1;i<totalnoofrows+1;i++){
		 d.findElement(By.name("txtUserName")).sendKeys(sh.getCell(0,i).getContents());
		 //password
		 d.findElement(By.name("txtPassword")).sendKeys(sh.getCell(1,i).getContents());
		 //login
		 d.findElement(By.name("Submit")).click();
		 d.findElement(By.xpath("//*[@id='option-menu']/li[3]/a")).click();
	
			 }}
	
@BeforeMethod
public void setUp() throws Exception
{
	d= new FirefoxDriver();
	d.manage().window().maximize();
}
@AfterMethod
public void Setup777()
{
	d.quit();
}}
