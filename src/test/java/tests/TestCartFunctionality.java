package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonMethod;

public class TestCartFunctionality extends CommonMethod {

	public void logIn() {
		hp.headerBarSelect("Sign In");
		sendKey(lp.usernameInputField, getProperty("username"));
		sendKey(lp.passwordInputField, getProperty("password"));
		click(lp.loginButton);

	}

	@Test(enabled = true, priority = 1, groups = "AddToCart", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void AddToCart() {
		logIn();
		click(hp.homePageProduct.get(0));
		pp.selectSizeAndColor("XS", "Blue");
		click(hp.addToCart);
		int itemIncartAfter = Integer.parseInt(pp.itemInCart.getText());
		AssertJUnit.assertEquals(itemIncartAfter, 1);
	}

	@Test(enabled = true, priority = 2, groups = "AddToCart", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void ChangeQuantity() {

		int itemIncartBefore = Integer.parseInt(pp.itemInCart.getText());
		sendKey(hp.ChangeQuantity, getProperty("number"));
		click(hp.addToCart);
		int itemIncartAfter = Integer.parseInt(pp.itemInCart.getText());
		AssertJUnit.assertEquals(itemIncartAfter, itemIncartBefore + Integer.parseInt(getProperty("number")));

	}

	@Test(enabled = true, priority = 3, groups = "AddToCart", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void RemoveFromCart() {
		click(hp.MyCart);
		click(hp.ViewCart);
		click(hp.RemoveFromCart);
		AssertJUnit.assertTrue(hp.emptyCartText.getText().contains("no items"));

	}

}
