package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AddressPage {
	
	public AddressPage() {
		
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	@FindBy(xpath ="//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/a")
	public WebElement ChangeBillingAddress;
	
	@FindBy(name ="firstname")
	public WebElement FirstName;
	
	@FindBy(name= "lastname")
	public WebElement LastName;
	
	@FindBy(name ="company")
	public WebElement Company;
	
	@FindBy(name="telephone")
	public WebElement PhoneNumber;
	
	@FindBy(xpath ="//*[@title='Street Address']")
	public WebElement StreetAddress1;
	
	@FindBy(id="street_2")
	public WebElement StreetAddress2;
	
	@FindBy(id="street_3")
	public WebElement StreetAddress3;
	
	@FindBy(xpath ="//*[@id=\"city\"]")
	public WebElement City;
	
	@FindBy(id ="region_id")
	public WebElement States;
	
	@FindBy(xpath = "//*[@id=\"zip\"]")
	public WebElement ZipCode;
	
	@FindBy(xpath = "//*[@id=\"country\"]")
	public WebElement Countrys;
	
	
	
	@FindBy(xpath ="//*[@title='Save Address']")
	public WebElement SaveAddress;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")
	public WebElement SaveMessage;
	
	@FindBy(xpath ="//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/a")
	public WebElement ShippingAddress;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/button")
	public WebElement AddNewAddress;
	

}
