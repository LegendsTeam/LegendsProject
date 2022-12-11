package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethod;
public class TestCreateAccount extends CommonMethod{
	
@BeforeClass
	public void CreatAccount() {		
		BaseClass.getDriver();
		}
@BeforeMethod
	public void CreateAccountButton() {
		click(cap.CreateAccountButton);
		Assert.assertTrue(cap.CreateNewAccountText.getText().contains(getProperty("NactualCreateAccountText")));
	}
@Test (priority=1)
public void CreateAccount()  {
	cap.fistName.sendKeys(getProperty("firstName"));
//	sendKey(cap.fistName, getProperty("firstName"));
	cap.lastName.sendKeys(getProperty("lastName"));
//	sendKey(cap.lastName, getProperty("lastName"));
	cap.email.sendKeys(getProperty("email"));
//	sendKey(cap.email, getProperty("email"));
	cap.password.sendKeys(getProperty("Npassword"));
//	sendKey(cap.password, getProperty("Npassword"));
//	sendKey(cap.confirmPassword, getProperty("Npassword"));
	cap.confirmPassword.sendKeys(getProperty("Npassword"));
	click(cap.createAnAccountButton);
}
@Test(priority=2)
public void CreateAccountWithExistingEmail()  {
	cap.fistName.sendKeys(getProperty("firstName"));
	cap.lastName.sendKeys(getProperty("lastName"));
	cap.email.sendKeys(getProperty("email"));
	cap.password.sendKeys(getProperty("Npassword"));
	cap.confirmPassword.sendKeys(getProperty("Npassword"));
	click(cap.createAnAccountButton);	
	System.out.println("The text is " +cap.existAccountText.getText());
	Assert.assertTrue(cap.existAccountText.getText().contains(getProperty("alreadyExistText")));
}
@Test
public void CreateAccountWithWrongEmail()  {
	cap.fistName.sendKeys(getProperty("firstName"));
	cap.lastName.sendKeys(getProperty("lastName"));
	cap.email.sendKeys(getProperty("wrongEmail"));
	cap.password.sendKeys(getProperty("Npassword"));
	cap.confirmPassword.sendKeys(getProperty("Npassword"));
	click(cap.createAnAccountButton);
Assert.assertTrue(cap.wrongEmailText.getText().contains(getProperty("wrongEmailText")));
}
}