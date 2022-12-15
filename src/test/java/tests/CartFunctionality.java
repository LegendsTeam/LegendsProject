package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class CartFunctionality extends CommonMethod{
	
	
	public void logIn() {
		hp.headerBarSelect("Sign In");
		sendKey(lp.usernameInputField, getProperty("username"));
		sendKey(lp.passwordInputField, getProperty("password"));
		click(lp.loginButton);
		
	}
	@Test(enabled = true, priority = 1, groups = "AddToCart")
	public void AddToCart() {
		logIn();
		click(hp.homePageProduct.get(0));
		pp.selectSizeAndColor("XS", "Blue");
		click(hp.addToCart);
		int itemIncartAfter = Integer.parseInt(pp.itemInCart.getText());
		Assert.assertEquals(itemIncartAfter, 1);
	}
	@Test(enabled = true, priority = 2, groups = "AddToCart")
	public void ChangeQuantity() {
		
		int itemIncartBefore = Integer.parseInt(pp.itemInCart.getText());
		sendKey(hp.ChangeQuantity, getProperty("number"));
		click(hp.addToCart);
		int itemIncartAfter = Integer.parseInt(pp.itemInCart.getText());
		Assert.assertEquals(itemIncartAfter, itemIncartBefore + Integer.parseInt(getProperty("number")));
		
	}
	@Test(enabled = true, priority = 3, groups = "AddToCart")
	public void RemoveFromCart() {
		click(hp.MyCart);
		click(hp.ViewCart);
		click(hp.RemoveFromCart);
		Assert.assertTrue(hp.emptyCartText.getText().contains("no items"));
		
	
	}
	
	
	

}
