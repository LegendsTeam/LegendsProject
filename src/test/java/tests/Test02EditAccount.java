package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class Test02EditAccount extends CommonMethod {

	@BeforeMethod
	public void logIn() {
		signIn();
	}

	@Test(enabled = true, priority = 1)
	public void EditAccontPage() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ep.editButton);
		sendKey(ep.firstName, getProperty("firstName"));
		sendKey(ep.lastName, getProperty("lastName"));
		click(ep.saveButton);
		Assert.assertEquals("You saved the account information.", ep.passMessage.getText());
		System.out.println(ep.passMessage.getText());
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);

	}

	@Test(enabled = true, priority = 2)
	public void ChangeEmail() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ep.editButton);
		click(ep.changeEmail);
		sendKey(ep.email, getProperty("username"));
		sendKey(ep.currentPassword, getProperty("password"));
		sendKey(ep.firstName, getProperty("firstName"));
		sendKey(ep.lastName, getProperty("lastName"));
		click(ep.saveButton);
		Assert.assertEquals("You saved the account information.", ep.passMessage.getText());
		System.out.println(ep.passMessage.getText());

	}

	@Test(enabled = true, priority = 3)
	public void ChangePassword() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ep.editButton);
		click(ep.changePassword);
		sendKey(ep.currentPassword, getProperty("password"));
		sendKey(ep.newPassword, getProperty("password"));
		sendKey(ep.conFirmnewPassword, getProperty("password"));
		click(ep.saveButton);
		Assert.assertEquals("You saved the account information.", ep.passMessage.getText());
		System.out.println(ep.passMessage.getText());

	}
}
