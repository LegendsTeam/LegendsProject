package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.PageInitializer;

public class CreateAccountPage extends PageInitializer {
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[3]")
	public WebElement CreateAccountButton;
	
	@FindBy(xpath="//*[@class='page-title-wrapper']")
	public WebElement CreateNewAccountText;
	
	@FindBy(xpath="//*[@id='firstname']")
	public WebElement firstName;
	
	@FindBy(xpath="//*[@id='lastname']")
	public WebElement lastName;
	
	@FindBy(xpath="//*[@id='email_address']")
	public WebElement email;
	
	@FindBy(xpath="//*[@id='password")
	public WebElement password;
	
	@FindBy(xpath="//*[@id='password-confirmation")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//*[@class='action submit primary']")
	public WebElement createAnAccountButton;
	
	@FindBy(xpath="//*[@class=\"message-success success message\"]")
	public WebElement CreateNewAccountConfirmText;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	public WebElement downArrowTriangle;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]")
	public WebElement signOutButton;
	
	@FindBy(xpath="//*[@Class='message-error error message']")
	public WebElement existAccountText;
	
	@FindBy(xpath="//*[@id='email_address-error']")
	public WebElement wrongEmailText;
	
	

}
