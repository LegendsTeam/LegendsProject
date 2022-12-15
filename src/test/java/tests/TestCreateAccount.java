package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import utilities.CommonMethod;

public class TestCreateAccount extends CommonMethod{
	FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
    
    String email = fakeValuesService.bothify("????##@gmail.com");
    Faker fake = new Faker();
    String firstName = fake.name().firstName();
    String lastName= fake.name().lastName();
	
	
@BeforeMethod
	public void CreateAccountButton() {
		cap.CreateAccountButton.click();;
		AssertJUnit.assertTrue(cap.CreateNewAccountText.getText().contains(getProperty("NactualCreateAccountText")));
	}
@Test (priority=1)
public void CreateAccount()  {
	
	cap.firstName.sendKeys(firstName);
	cap.lastName.sendKeys(lastName);
	cap.email.sendKeys(email);
	cap.password.sendKeys(getProperty("Npassword"));
	cap.confirmPassword.sendKeys(getProperty("Npassword"));
	click(cap.createAnAccountButton);
	AssertJUnit.assertTrue(cap.CreateNewAccountConfirmText.getText().contains(getProperty("AccountCreatedConfirmText")));
	cap.downArrowTriangle.click();
	cap.signOutButton.click();


}
@Test(priority=2)
public void CreateAccountWithExistingEmail()  {
	click(cap.CreateAccountButton);
	cap.firstName.sendKeys(firstName);
	cap.lastName.sendKeys(lastName);
	cap.email.sendKeys(email);
	cap.password.sendKeys(getProperty("Npassword"));
	cap.confirmPassword.sendKeys(getProperty("Npassword"));
	click(cap.createAnAccountButton);	
	System.out.println("The text is " +cap.existAccountText.getText());
	AssertJUnit.assertTrue(cap.existAccountText.getText().contains(getProperty("alreadyExistText")));
}
@Test
public void CreateAccountWithWrongEmail()  {
	cap.firstName.sendKeys(getProperty("firstName"));
	cap.lastName.sendKeys(getProperty("lastName"));
	cap.email.sendKeys(getProperty("wrongEmail"));
	cap.password.sendKeys(getProperty("Npassword"));
	cap.confirmPassword.sendKeys(getProperty("Npassword"));
	click(cap.createAnAccountButton);
AssertJUnit.assertTrue(cap.wrongEmailText.getText().contains(getProperty("wrongEmailText")));
}
}
