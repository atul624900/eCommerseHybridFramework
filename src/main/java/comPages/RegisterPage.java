package comPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	 WebDriver driver;
	 
	 //constructor to initialize connection b/w WebElement and locator

	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	// objects of register web page 
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement myAccountDropDown;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerButton;
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;
	
	@FindBy(css=".radio-inline input")
	private WebElement radioButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement successAlertMsg;
	
	@FindBy(css=".alert")
	private WebElement duplicateEmailAlertMsg;
	
	@FindBy(css=".alert")
	private WebElement privacyPolicyEmailAlertMsg;
	
	//Actions
	
	public void clickOnMyAccount()
	{
		myAccountDropDown.click();
	}
	public void clickOnRegister()
	{
		registerButton.click();
	}
	public void enterFirstName(String userFirstName)
	{
		firstName.sendKeys(userFirstName);
	}
	public void enterLastName(String userLastName)
	{
		lastName.sendKeys(userLastName);
	}
	public void enterEmail(String userEmail)
	{
		email.sendKeys(userEmail);
	}
	public void enterTelephone(String telephoneNum)
	{
		telephone.sendKeys(telephoneNum);
	}
	public void enterPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	public void enterConfirmPassword(String userConfirmPassword)
	{
		confirmPassword.sendKeys(userConfirmPassword);
	}
	public void clickOnPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	public void clickOnRadioButton()
	{
		radioButton.click();
	}
	public String getsuccessAlertMsg()
	{
		return successAlertMsg.getText();
	}
	public String getduplicateEmailAlertMsg()
	{
		return duplicateEmailAlertMsg.getText();
	}
	public String getprivacyPolicyEmailAlertMsg()
	{
		return privacyPolicyEmailAlertMsg.getText();
	}
	

}
