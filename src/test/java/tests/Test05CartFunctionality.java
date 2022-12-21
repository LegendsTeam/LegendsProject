package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommonMethod;

public class Test05CartFunctionality extends CommonMethod {

	@Test(enabled = true, priority = 1, groups = "AddToCart")
	public void AddToCart() {
		signIn();
		int itemIncartBefore = pp.getItemInCart();;
		click(hp.homePageProduct.get(0));
		pp.selectSizeAndColor("XS", "Blue");
		click(hp.addToCart);
		int itemIncartAfter = Integer.parseInt(pp.itemInCart.getText());
		Assert.assertEquals(itemIncartAfter, itemIncartBefore + 1);
	}

	@Test(enabled = true, priority = 2, groups = "AddToCart")
	public void ChangeQuantity() {

		int itemIncartBefore = Integer.parseInt(pp.itemInCart.getText());
		sendKey(hp.changeQuantity, getProperty("number"));
		click(hp.addToCart);
		int itemIncartAfter = Integer.parseInt(pp.itemInCart.getText());
		Assert.assertEquals(itemIncartAfter, itemIncartBefore + Integer.parseInt(getProperty("number")));

	}

	@Test(enabled = true, priority = 3, groups = "AddToCart")
	public void RemoveFromCart() {
		click(hp.MyCart);
		click(hp.viewCart);
		click(hp.removeFromCart);
		Assert.assertTrue(hp.emptyCartText.getText().contains("no items"));
	}

}
