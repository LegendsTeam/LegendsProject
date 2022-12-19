package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class Test04PlaceAnOrderFunctionality extends CommonMethod{
	
	@BeforeMethod(onlyForGroups = "must_login")
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
		click(mpp.menJackets);
		click(mpp.montanaWindJacket.get(0));
		pp.selectSizeAndColor("XS", "Black");
		click(pp.addToCartButton);
		Thread.sleep(3000);
		click(hp.MyCart);
		click(hp.proceedToCheckout);
		click(cop.shippingMethod);
		click(cop.clickNextButton);
		click(cop.sameShippingAndBillingAddress);
		click(hp.proceedToCheckout);
		AssertJUnit.assertTrue(cop.continueShopping.isEnabled());
	}

	@Test(enabled = true, priority = 2, dependsOnMethods = "PlaceOrder")
	public void reOrder() throws InterruptedException {
		click(cop.comfirmationNumber);
		click(op.clickOnReorder);
		click(cop.proceedToCheeckout);
		click(cop.shippingMethod);
		click(cop.clickNextButton);
		click(cop.sameShippingAndBillingAddress);
		click(cop.placeOrderBotton);
		AssertJUnit.assertTrue(cop.continueShopping.isEnabled());
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);
	}

	@Test(enabled = true, priority = 3, groups = "must_login")
	public void viewOrder() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		click(ca.myOrderButton);
		click(op.viewOrder.get(0));
		AssertJUnit.assertEquals("Items Ordered",op.itemOrder.getText());
	}

}
