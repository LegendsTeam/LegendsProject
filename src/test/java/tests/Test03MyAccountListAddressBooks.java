package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethod;

@Listeners(utilities.MyListener.class)
public class Test03MyAccountListAddressBooks extends CommonMethod {

	@BeforeMethod(enabled = true)
	public void logIn() {
		signIn();
		click(ca.CustomerNameArow);
		click(ca.MyAccount);
		click(ca.AddressBook);
	}

	@Test(enabled = true, priority = 1)
	public void ChangeBillingAddress() {

		click(cb.ChangeBillingAddress);
		sendKey(cb.FirstName, getProperty("firstName"));
		sendKey(cb.LastName, getProperty("lastName"));
		sendKey(cb.Company, getProperty("company"));
		sendKey(cb.PhoneNumber, getProperty("phone"));
		sendKey(cb.StreetAddress1, getProperty("streetAddress1"));
		sendKey(cb.City, getProperty("city"));
		selectItem(cb.Countrys, getProperty("country"));
		selectItem(cb.States, getProperty("state"));
		sendKey(cb.ZipCode, getProperty("zipCode"));
		click(cb.SaveAddress);

		String expectedmessage = getProperty("expectedMessage");
		String actualmessage = cb.SaveMessage.getText();
		System.out.println(actualmessage);
		Assert.assertEquals(actualmessage, expectedmessage);

	}

	@Test(enabled = true, priority = 2)
	public void DefultBillingAndShippingAddress() {

		highLightElementMethod(cb.DefaultBillingAdress);
		highLightElementMethod(cb.DefaultShippingAddress);
		String Billing = cb.DefaultBillingAdress.getText();
		String Shipping = cb.DefaultShippingAddress.getText();
		System.out.println(Billing + Shipping);
		Assert.assertEquals(Billing, Shipping);

	}

	@Test(enabled = true, priority = 3)
	public void AddNewAddress() {

		cb.Address.click();
		sendKey(cb.newFirstName, getProperty("newFirstName"));
		sendKey(cb.newLastName, getProperty("newLastName"));
		sendKey(cb.newCompany, getProperty("newCompany"));
		sendKey(cb.newPhoneNumber, getProperty("newPhone"));
		sendKey(cb.newStreetAddress1, getProperty("newStreetAddress1"));
		sendKey(cb.newCity, getProperty("newCity"));
		selectItem(cb.newCountrys, getProperty("newCountry"));
		selectItem(cb.newStates, getProperty("newState"));
		sendKey(cb.newZipCode, getProperty("zipCode"));
		WebElement box = cb.billingCheckBox;
		box.click();
		click(cb.SaveAddress);

		highLightElementMethod(cb.SaveMessage);
		String newexpectedmessage = getProperty("expectedMessage");
		String newactualmessage = cb.SaveMessage.getText();
		System.out.println(newactualmessage);
		Assert.assertEquals(newactualmessage, newexpectedmessage);

		String newbilling = cb.afternewAddBillingDefilt.getText();
		String newshipping = cb.afternewAddShippingDefilt.getText();
		System.out.println(newbilling + newshipping);
		Assert.assertNotEquals(newbilling, newshipping);

		cb.accountMenu.get(5).click();
		cb.listOfDeletebutton.get(0).click();
		cb.okButton.click();

	}

	@AfterMethod(enabled = true)
	public void signoutTest() {
		signOut();
	}
}