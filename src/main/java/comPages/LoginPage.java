package comPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	int a=8;
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement myAccountDropdown;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement clickLogin;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement clicklogin;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(css=".alert")
	private WebElement invalidCredentialMsg;
	
	//Action on WebElement
	
	public void clickAccountTypeDropdown()
	{
		myAccountDropdown.click();
	}
	public void clickLogin()
	{
		clickLogin.click();
	}
	public void enterLogin(String loginEmail,String emailPassword)
	{
		email.sendKeys(loginEmail,emailPassword);
	}
		public void submitButton()
	{
		submit.click();
	}
	public String AlertWarningMessage()
	{
		return invalidCredentialMsg.getText();
	}
	

}
