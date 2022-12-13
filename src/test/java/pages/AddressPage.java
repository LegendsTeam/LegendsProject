package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AddressPage {

	public AddressPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/a")
	public WebElement ChangeBillingAddress;
	//*[@id="firstname"]
	@FindBy(id = "firstname")
	public WebElement FirstName;

	@FindBy(name = "lastname")
	public WebElement LastName;

	@FindBy(name = "company")
	public WebElement Company;

	@FindBy(name = "telephone")
	public WebElement PhoneNumber;

	@FindBy(xpath = "//*[@title='Street Address']")
	public WebElement StreetAddress1;

	@FindBy(xpath = "//*[@id='city']")
	public WebElement City;

	@FindBy(id = "region_id")
	public WebElement States;

	@FindBy(xpath = "//*[@id='zip']")
	public WebElement ZipCode;

	@FindBy(xpath = "//*[@id='country']")
	public WebElement Countrys;

	@FindBy(xpath = "//*[@title='Save Address']")
	public WebElement SaveAddress;

	@FindBy(xpath = "//div[@class='message-success success message']/div")
	public WebElement SaveMessage;

	@FindBy(xpath = "//*[@id='maincontent']/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/a")
	public WebElement ShippingAddress;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/address")
	public WebElement DefaultBillingAdress;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/address")
	public WebElement DefaultShippingAddress;

	@FindBy(xpath = "// *[@title='Add New Address']")
	public WebElement Address;

	@FindBy(name = "firstname")
	public WebElement newFirstName;

	@FindBy(name = "lastname")
	public WebElement newLastName;

	@FindBy(name = "company")
	public WebElement newCompany;

	@FindBy(name = "telephone")
	public WebElement newPhoneNumber;

	@FindBy(xpath = "//*[@title='Street Address']")
	public WebElement newStreetAddress1;

	@FindBy(xpath = "//*[@id='city']")
	public WebElement newCity;

	@FindBy(id = "region_id")
	public WebElement newStates;

	@FindBy(xpath = "//*[@id='zip']")
	public WebElement newZipCode;

	@FindBy(xpath = "//*[@id='country']")
	public WebElement newCountrys;

	@FindBy(name = "default_billing")
	public WebElement billingCheckBox;

	@FindBy(name = "//*[@id=\"form-validate\"]/div/div[1]/button/span") // *[@id="form-validate"]/div/div[1]/button/span
	public WebElement newAddsave;

	@FindBy(className = "toolbar-number") // *[@id="form-validate"]/div/div[1]/button/span
	public WebElement numberofIteam;

	@FindBy(xpath = "//div[@class='message-success success message']/div")
	public WebElement newSaveMessage;

	@FindBy(xpath = "//*[@class='action delete']")
	public WebElement delete;

	@FindBy(xpath = "//*[@id='modal-content-18']/div")
	public WebElement alert;

	@FindBy(className = "action-primary action-accept ")
	public WebElement ok;

	@FindBy(xpath = "//*[@class='table-wrapper additional-addresses']/table/tbody/tr/td[9]/a[2]")
	public List<WebElement> listOfDeletebutton;

	@FindBy(xpath = "//*[@class='modal-footer']/button[2]")
	public WebElement okButton;
	
	 @FindBy(xpath = "//*[@class='nav items']/li")
	    public List<WebElement> accountMenu;

	 @FindBy(xpath ="//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/address")
	 public WebElement afternewAddBillingDefilt;
	 
	 @FindBy(xpath ="//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/address")
	 public WebElement afternewAddShippingDefilt;
}
