package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class EditAccountPage {

	public EditAccountPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(id = "email")
	public WebElement usernameInputField;

	@FindBy(name = "login[password]")
	public WebElement passwordInputField;

	@FindBy(name = "send")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@data-action='customer-menu-toggle']")
	public WebElement switchButton;

	@FindBy(xpath = "(//a[@class='action edit'])[1]")
	public WebElement editButton;

	@FindBy(xpath = "//*[@id='firstname']")
	public WebElement firstName;

	@FindBy(xpath = "//*[@id='lastname']")
	public WebElement lastName;

	@FindBy(xpath = "//button[@title='Save']")
	public WebElement saveButton;

	@FindBy(xpath = "//*[@class='message-success success message']")
	public WebElement passMessage;

	@FindBy(xpath = "//*[@id='change-email']")
	public WebElement changeEmail;
	@FindBy(xpath = "//*[@id='email']")
	public WebElement email;
	@FindBy(xpath = "//*[@id='current-password']")
	public WebElement currentPassword;
	@FindBy(xpath = "//*[@id='change-password']")
	public WebElement changePassword;
	@FindBy(xpath = "//*[@id='password']")
	public WebElement newPassword;

	@FindBy(xpath = "//*[@id='password-confirmation']")
	public WebElement conFirmnewPassword;
}