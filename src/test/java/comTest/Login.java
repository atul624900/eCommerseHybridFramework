package comTest;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import comPages.BaseClass;
import comPages.LoginPage;
import utils_utilities.Utilities;

public class Login extends BaseClass{
	
	LoginPage lp;
	
	public Login() throws IOException {
		super();
		
	}
	 public WebDriver driver;
	
	@BeforeMethod
	public void tearUp()
	{
		driver = setUp();
		lp = new LoginPage(driver);
		lp.clickAccountTypeDropdown();
		lp.clickLogin();
		//this.driver=driver;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void loginWithValidCredentials()
	{
		
		lp.enterLogin(prop.getProperty("email"),prop.getProperty("password"));
		lp.submitButton();
		
	}
	@Test()
	public void loginWithInvalidCredentials()
	{
		
		lp.enterLogin("adcbcbb@gmail.com","212233233");
		lp.submitButton();
		String alert1 = lp.AlertWarningMessage();
		Assert.assertEquals(alert1,"Warning: No match for E-Mail Address and/or Password.");
	}
	@Test()
	public void loginWithInvalidEmailValidPasswordCredentials()
	{
		
		lp.enterLogin("Kumtul123@gmail.com","987654321");
		lp.submitButton();
		String alert1 = lp.AlertWarningMessage();
		Assert.assertEquals(alert1,"Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test()
	public void loginWithValidEmailInvalidPasswordCredentials()
	{
		
		lp.enterLogin("Kumaratul123@gmail.com","980000054321");
		lp.submitButton();
		String alert1 = lp.AlertWarningMessage();
		Assert.assertEquals(alert1,"Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test()
	public void loginWithoutProvidingCredentials()
	{
		
		
		lp.enterLogin("","");
		lp.submitButton();
		String alert1 = lp.AlertWarningMessage();
		Assert.assertEquals(alert1,"Warning: No match for E-Mail Address and/or Password.");
	}
	
	@DataProvider(name="excelData")
	public Object[][] getData() throws IOException
	{
		Object[][] obj=Utilities.supplyTestData("Login");
		return obj;
	}
	

}



