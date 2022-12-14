package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class CreateAccountPage {
	public CreateAccountPage() {		
		PageFactory.initElements(BaseClass.getDriver(), this);		
	}
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	public WebElement CreateAccountButton;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[1]")
	public WebElement CreateNewAccountText;
	
	@FindBy(xpath="//*[@class='message-success success message']")
	public WebElement CreateNewAccountConfirmText;
	
	@FindBy(css="body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span")
	public WebElement downArrowTriangle;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	public WebElement signOutButton;
	
	@FindBy(xpath="//*[@id=\"firstname\"]")
	public WebElement fistName;
	
	@FindBy(xpath="//*[@id=\"lastname\"]")
	public WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"email_address\"]")
	public WebElement email;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	public WebElement password;
	
	@FindBy(xpath="//*[@id=\"password-confirmation\"]")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//*[@id=\"form-validate\"]/div/div[1]/button")
	public WebElement createAnAccountButton;
	
	@FindBy(xpath="//*[@class='message-error error message']")
	public WebElement existAccountText;
	
	@FindBy(xpath="//*[@id=\"email_address-error\"]")
	public WebElement wrongEmailText;
	
}
