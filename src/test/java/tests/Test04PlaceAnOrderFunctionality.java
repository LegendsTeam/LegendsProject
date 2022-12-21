package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class Test04PlaceAnOrderFunctionality extends CommonMethod{
	
	@BeforeMethod(onlyForGroups = "must_login")
	public void logIn() {
		signIn();
	}

	@Test(enabled = true, priority = 1, groups = "must_login")
	public void PlaceOrder() throws InterruptedException {
		hoverOver(cp.topMenu.get(2));
		hoverOver(cp.menTopMenu);
		click(mpp.menJackets);
		click(mpp.productList.get(0));
		pp.selectSizeAndColor("XS", "Black");
		click(pp.addToCartButton);
		Thread.sleep(3000);
		click(hp.MyCart);
		click(hp.proceedToCheckout);
		click(cop.shippingMethod);
		click(cop.clickNextButton);
		click(cop.sameShippingAndBillingAddress);
		click(hp.proceedToCheckout);
		Assert.assertTrue(cop.continueShopping.isEnabled());
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
		Assert.assertTrue(cop.continueShopping.isEnabled());
		signOut();
	}

	@Test(enabled = true, priority = 3, groups = "must_login")
	public void viewOrder() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		click(ca.myOrderButton);
		click(op.viewOrder.get(0));
		Assert.assertEquals("Items Ordered",op.itemOrder.getText());
	}

}
