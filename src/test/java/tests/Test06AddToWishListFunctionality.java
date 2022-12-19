package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethod;

@Listeners(utilities.MyListener.class)
public class Test06AddToWishListFunctionality extends CommonMethod {

	@BeforeMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logIn() {
		hp.headerBarSelect("Sign In");
		sendKey(lp.usernameInputField, getProperty("username"));
		sendKey(lp.passwordInputField, getProperty("password"));
		click(lp.loginButton);
	}
	
	@Test(enabled = true, priority = -1, groups = "noLogin")//, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListBeforeSuccessfullyLogIn() {
		topBarSelect("What's New");
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		String expectErrorMessage = "You must login or register to add items to your wishlist.";
		AssertJUnit.assertEquals(lp.errorMessages.getText(), expectErrorMessage);

	}

	
	@Test(enabled = true, priority = 1, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListFromProductDetailPage() {
		deletingAllProductFromWishList();
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		int numOfProductInWishList = mp.getNumberOfProductsInWishList();
		topBarSelect("What's New");
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		AssertJUnit.assertEquals(mp.getNumberOfProductsInWishList(), numOfProductInWishList + 1);
	}
	
	@Test(enabled = true, priority = 2, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void deleteWishList() {
		deletingAllProductFromWishList();
		String expectedText = "You have no items in your wish list.";
		String actualText = mp.emptyWishListMessage.getText();
		AssertJUnit.assertEquals(actualText, expectedText);
	}
	
	@Test(enabled = true, priority = 3, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListByHoverProduct() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		int numOfProductInWishList = mp.getNumberOfProductsInWishList();
		topBarSelect("What's New");
		wp.addToWishListByHoverOver(2);
		AssertJUnit.assertEquals(mp.getNumberOfProductsInWishList(), numOfProductInWishList + 1);
	}
	
	@Test(enabled = true, priority = 4, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addMoreThanOneToWishListByHoverProduct() {
		deletingAllProductFromWishList();
		topBarSelect("What's New");
		int numOfProduct = 3;
		wp.addingNProductstoWishList(numOfProduct);
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		AssertJUnit.assertEquals(mp.getNumberOfProductsInWishList(), numOfProduct);
	}
	
	@Test(enabled = true, priority = 5, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void updateWishList() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		mp.editingWistList(0);
		pp.selectSizeAndColor("XS", "White");
		click(pp.updateWishListLink);
		AssertJUnit.assertTrue(mp.successMessage.getText().contains("has been updated in your Wish List"));
	}
	
	@AfterMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logOut() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);
	}

}
