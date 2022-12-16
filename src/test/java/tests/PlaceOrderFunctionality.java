package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class PlaceOrderFunctionality extends CommonMethod {
	
	@BeforeMethod(onlyForGroups = "must_login" )
	public void logIn() {
		hp.headerBarSelect("Sign In");
		sendKey(lp.usernameInputField, getProperty("username"));
		sendKey(lp.passwordInputField, getProperty("password"));
		click(lp.loginButton);
	}
	@Test(enabled = true, priority = 1, groups = "must_login")
	public void PlaceOrder() throws InterruptedException {
		
		hoverOver(cp.topMenu.get(2));
		hoverOver(cp.menTopMenu);
		click(cp.menJackets);
		click(cp.montanaWindJacket.get(0));
		pp.selectSizeAndColor("XS", "Black");
		click(cp.addToCart);
		Thread.sleep(3000);
		jsClick(cp.cartShown);
		jsClick(cp.proceedToCheckout);
		click(cp.shippingMethod);
		click(cp.clickNextButton);
		click(cp.sameShippingAndBillingAddress);
		click(cp.clickPlaceOrder);
		String expectedResult = "success";
		
		
		Assert.assertTrue(driver.getCurrentUrl().contains(expectedResult));
		
		
		
	}
	@Test(enabled = true, priority = 3)
	public void viewAndPrintOrder() {
		click(hp.ComfNumber);
		click(cp.clickOnPrintOrder);		
	}
	@Test(enabled = true, priority = 2)
	public void reOrder() {
//		click(cp.profileDownArrow);
//		click(cp.clickOnMyAccount);
//		click(cp.clickOnMyOrder);
//		click(cp.clickOnViewOrder);
		click(hp.ComfNumber);
		click(cp.clickOnReorder);
		click(cp.proceedToCheckout);
		click(cp.shippingMethod);
		click(cp.clickNextButton);
		click(cp.sameShippingAndBillingAddress);
		click(cp.clickPlaceOrder);
	}
	
	@AfterMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logOut() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);
	}
	
	
	
}

