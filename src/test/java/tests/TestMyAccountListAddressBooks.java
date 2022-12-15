package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class TestMyAccountListAddressBooks extends CommonMethod {

	@BeforeMethod(enabled = true )
	public void Signin() {

		hp.headerBarSelect("Sign In");
		sendKey(ca.Email, getProperty("username"));
		sendKey(ca.Password, getProperty("password"));
		click(ca.signinbutton);
		
		
	}

	@Test(enabled = true ,priority = 1)
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
		selectItem(cb.Countrys ,"United States");
		selectItem(cb.States, "Virginia");		
		sendKey(cb.ZipCode,getProperty("ZipCode"));		
		click(cb.SaveAddress);
		
		String expectedmessage =getProperty("expectedMessage");
		String actualmessage =cb.SaveMessage.getText();
		System.out.println(actualmessage);
	    Assert.assertEquals(actualmessage,expectedmessage );
	   
		
		
	}

	@Test(enabled = true ,priority =2)
	public void DefultBillingAndShippingAddress() {
	
//		 wait(0.1);
		click(ca.CustomerNameArow);
		click(ca.MyAccount);
		click(ca.AddressBook);
		 wait(0.1);
		highLightElementMethod(cb.DefaultBillingAdress);
		wait(0.1);
		highLightElementMethod(cb.DefaultShippingAddress);
		wait(0.1);
		String Billing= cb.DefaultBillingAdress.getText();
		String Shipping= cb.DefaultShippingAddress.getText();
		System.out.println(Billing + Shipping);
		Assert.assertEquals(Billing, Shipping);
	

	}
	
	@Test(enabled = true ,priority = 3)
	public void AddNewAddress() {
		
		wait(0.1);
		click(ca.CustomerNameArow);
		click(ca.MyAccount);
		click(ca.AddressBook);
		cb.Address.click();
		wait(0.1);
		sendKey(cb.newFirstName,getProperty("newfirstName"));
		sendKey(cb.newLastName,getProperty("newlastName"));
		sendKey(cb.newCompany,getProperty("newcompany"));
		sendKey(cb.newPhoneNumber,getProperty("newPhone"));
		sendKey(cb.newStreetAddress1,getProperty("newStreetAddress1"));
		sendKey(cb.newCity,getProperty("newCity"));
		selectItem(cb.newCountrys ,"United States");
		selectItem(cb.newStates, "Virginia");		
		sendKey(cb.newZipCode,getProperty("ZipCode"));	
		WebElement box= cb.billingCheckBox;
		box.click();
		click(cb.SaveAddress);
		wait(0.1);
		highLightElementMethod(cb.SaveMessage);
		String newexpectedmessage =getProperty("expectedMessage");
		String newactualmessage =cb.SaveMessage.getText();
		System.out.println(newactualmessage);
	    Assert.assertEquals(newactualmessage,newexpectedmessage );
		
			
        String newbilling =cb.afternewAddBillingDefilt.getText();
        String newshipping =cb.afternewAddShippingDefilt.getText();
        System.out.println(newbilling+newshipping);
        Assert.assertNotEquals(newbilling, newshipping);
        
        cb.accountMenu.get(5).click();
        cb.listOfDeletebutton.get(0).click();
        cb.okButton.click();
	 
}
	@AfterMethod(enabled = true)
	public void signoutTest() {
		
		click(ca.CustomerNameArow);
		click(ca.signoutButton);
	}
}