package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class TestMyAccountListAddressBooks extends CommonMethod {

	@BeforeMethod(enabled = true , groups = "sign in")
	public void Signin() {

		hp.headerBarSelect("Sign In");
		sendKey(ca.Email, getProperty("username"));
		sendKey(ca.Password, getProperty("password"));
		click(ca.signinbutton);

	}

	@Test(enabled = false ,priority = 1,groups = "sign in")
	public void MyAccount() {

	

	}
	@Test(enabled = true ,priority = 2)
	public void ChangeBillingAddress() {
		click(ca.CustomerNameArow);
		click(ca.MyAccount);
		click(ca.AddressBook);
		click(cb.ChangeBillingAddress);	
		sendKey(cb.FirstName, getProperty("firstName"));
		sendKey(cb.LastName, getProperty("lastName"));
		sendKey(cb.Company, getProperty("company"));
		sendKey(cb.PhoneNumber,getProperty("Phone"));
		sendKey(cb.StreetAddress1,getProperty("StreetAddress1"));		
		sendKey(cb.City,getProperty("City"));
		Select sec = new Select(cb.Countrys);
		sec.selectByVisibleText("United States");
		Select sec1 = new Select(cb.States);
		sec1.selectByValue("61");
		
		sendKey(cb.ZipCode,getProperty("ZipCode"));
		
		
		
	
	//	sendKey(cb.Countrys,getProperty("country"));
		
		click(cb.SaveAddress);
		
		
		
	}

	@Test(priority = 3,enabled = false , groups = "sign in")
	public void ChangeShippingAddress() {
		
		click(cb.ShippingAddress);
		
		sendKey(cb.FirstName, getProperty("firstName"));
		sendKey(cb.LastName, getProperty("lastName"));
		sendKey(cb.Company, getProperty("company"));
		sendKey(cb.PhoneNumber,getProperty("Phone"));
		sendKey(cb.StreetAddress1,getProperty("StreetAddress1"));
		sendKey(cb.StreetAddress2,getProperty("StreetAddress2"));
		sendKey(cb.StreetAddress3,getProperty("StreetAddress3"));
		sendKey(cb.City,getProperty("City"));
		sendKey(cb.States,getProperty("State"));
		sendKey(cb.ZipCode,getProperty("ZipCode"));
//		sendKey(cb.Country,getProperty("country"));
		click(cb.SaveAddress);
		

	}
	
	@Test(priority =4 , enabled = false)
	public void AddNewAddress() {
		
		click(cb.AddNewAddress);
		sendKey(cb.FirstName, getProperty("firstName"));
		sendKey(cb.LastName, getProperty("lastName"));
		sendKey(cb.Company, getProperty("company"));
		sendKey(cb.PhoneNumber,getProperty("Phone"));
		sendKey(cb.StreetAddress1,getProperty("StreetAddress1"));
		sendKey(cb.City,getProperty("City"));
//		sendKey(cb.States,getProperty("State"));
		sendKey(cb.ZipCode,getProperty("ZipCode"));
//		sendKey(cb.Country,getProperty("country"));
		
		
	}

}
