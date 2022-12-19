package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class Test02EditAccount extends CommonMethod {

	public void logIn() {
		hp.headerBarSelect("Sign In");
		sendKey(lp.usernameInputField, getProperty("username"));
		sendKey(lp.passwordInputField, getProperty("password"));
		click(lp.loginButton);

	}

	@Test(enabled = true, priority = 1)
	public void EditAccontPage() {
		logIn();
		// topBarSelect("SwichButton");
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ep.editButton);
		sendKey(ep.firstName, getProperty("firstName"));
		sendKey(ep.lastName, getProperty("lastName"));
		click(ep.saveButton);
		AssertJUnit.assertEquals("You saved the account information.", ep.passMessage.getText());
		System.out.println(ep.passMessage.getText());
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);

	}

	@Test(enabled = true, priority = 2)
	public void ChangeEmail() {
		logIn();
//        topBarSelect("SwichButton");
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ep.editButton);
		click(ep.changeEmail);
		sendKey(ep.email, getProperty("username"));
		sendKey(ep.currentPassword, getProperty("password"));
		sendKey(ep.firstName, getProperty("firstName"));
		sendKey(ep.lastName, getProperty("lastName"));
		click(ep.saveButton);
		AssertJUnit.assertEquals("You saved the account information.", ep.passMessage.getText());
		System.out.println(ep.passMessage.getText());

	}

	@Test(enabled = true, priority = 3)
	public void ChangePassword() {
		logIn();
//        topBarSelect("SwichButton");
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ep.editButton);
		click(ep.changePassword);
		sendKey(ep.currentPassword, getProperty("password"));
		sendKey(ep.newPassword, getProperty("password"));
		sendKey(ep.conFirmnewPassword, getProperty("password"));
		click(ep.saveButton);
		AssertJUnit.assertEquals("You saved the account information.", ep.passMessage.getText());
		System.out.println(ep.passMessage.getText());

	}
}
