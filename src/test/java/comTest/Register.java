package comTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comPages.BaseClass;
import comPages.RegisterPage;

public class Register extends BaseClass {
	//public WebDriver driver;
	RegisterPage rp;
	
	public Register() throws IOException {
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void teatUp()
	{
		
		driver = setUp();
		rp = new RegisterPage(driver);
		rp.clickOnMyAccount();
		rp.clickOnRegister();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void RegisterWithMendatoryFields() 
	{
		
		rp.enterFirstName("Atul");
		rp.enterLastName("Kumar");
		rp.enterEmail("ranigpta123@gmail.com");
		rp.enterTelephone("2341234321");
		rp.enterPassword("12345678");
		rp.enterConfirmPassword("12345678");
		rp.clickOnPrivacyPolicy();
		rp.clickOnContinueButton();
		String str = rp.getsuccessAlertMsg();
		Assert.assertTrue(str.equals("Your Account Has Been Created!"));
		System.out.println("register with mandatory field");
		

	}
	
	@Test()
	public void RegisterWithDuplicateEmail() 
	{
		
		rp.enterFirstName("Atul");
		rp.enterLastName("Kumar");
		rp.enterEmail("ranigupta123@gmail.com");
		rp.enterTelephone("2341234321");
		rp.enterPassword("12345678");
		rp.enterConfirmPassword("12345678");
		rp.clickOnPrivacyPolicy();
		rp.clickOnContinueButton();
		String str = rp.getduplicateEmailAlertMsg();
		//Thread.sleep(Duration.ofSeconds(3));
		Assert.assertEquals(str, "Warning: E-Mail Address is already registered!","given warning is not same");
	

	}
	
	@Test()
	public void RegisterWithAllField() 
	{
		
		
		rp.enterFirstName("Atul");
		rp.enterLastName("Kumar");
		rp.enterEmail("ranigpa123@gmail.com");
		rp.enterTelephone("2341234321");
		rp.enterPassword("12345678");
		rp.enterConfirmPassword("12345678");
		rp.clickOnPrivacyPolicy();
		rp.clickOnContinueButton();
		rp.clickOnRadioButton();
		String str = rp.getsuccessAlertMsg();
		Assert.assertTrue(str.equals("Your Account Has Been Create!"));
		

	}
	@Test()
	public void RegisterWithoutAllField()
	{
		
		
		rp.clickOnContinueButton();
		String alert1 = rp.getprivacyPolicyEmailAlertMsg();
		Assert.assertEquals(alert1,"Warning: You must agree to the Privacy Policy!");	
	
	}
}
