package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethod;

public class AccountPage{
	
	public AccountPage() {
		
		PageFactory.initElements(BaseClass.getDriver(),this);
	}

	@FindBy(name = "login[username]")
	public WebElement Email;
	
	@FindBy(name = "login[password]")
	public WebElement Password;
		
	@FindBy(xpath = "//*[@class='action login primary']")
	public WebElement signinbutton;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span")
	public WebElement CustomerNameArow;
	
	@FindBy(linkText = "My Account")
	public WebElement MyAccount;
	
	@FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[6]/a")
	public WebElement AddressBook;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	public WebElement signoutButton;
	
}
