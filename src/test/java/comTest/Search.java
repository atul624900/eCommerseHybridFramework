package comTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import comPages.BaseClass;

public class Search extends BaseClass{
	public Search() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	@Test
	public void SearchWithValidProduct()
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		driver.findElement(By.cssSelector(".btn-lg")).click();
	}
	
	@Test
	public void SearchWithInalidProduct()
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone20");
		driver.findElement(By.cssSelector(".btn-lg")).click();
		String str = driver.findElement(By.xpath("//*[text()='There is no product that matches the search criteria.']")).getText();
		Assert.assertEquals(str,"There is no product that matches the search criteria.");
	}
	
	@Test
	public void SearchWithoutAnyProduct()
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		driver.findElement(By.cssSelector(".btn-lg")).click();
	}

}
