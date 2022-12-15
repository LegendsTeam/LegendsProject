package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LogInPage {
	
	public LogInPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(id = "email")
	public WebElement usernameInputField;
	
	@FindBy(name = "login[password]")
	public WebElement passwordInputField;
	
	@FindBy(name = "send")
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@class='action create primary']")
	public WebElement createAccountButton;
	
	@FindBy(xpath = "//*[@class='message-error error message']")
	public WebElement errorMessages;
	
	

}
