package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethod;

@Listeners(utilities.ListenerTestNG.class)
public class TestAddToWishListFunctionality extends CommonMethod {

	@BeforeMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logIn() {
		hp.headerBarSelect("Sign In");
		sendKey(lp.usernameInputField, getProperty("username"));
		sendKey(lp.passwordInputField, getProperty("password"));
		click(lp.loginButton);
	}
	
	@Test(enabled = true, priority = -1, groups = "noLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListBeforeSuccessfullyLogIn() {
		topBarSelect("What's New");
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		String currentURL = getDriver().getCurrentUrl();
		Assert.assertTrue(currentURL.contains("login"));

	}
	
	@Test(enabled = true, priority = 0, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void removeAllWishListBeforeStartTest() {
		try {
			click(cp.customerMenuToggle);
			cp.customerMenuSelect(1);
			mp.deletingAllProductFromWishList();
		} catch (Exception e) {
			System.out.println("There is product in wish list before test start");
			e.printStackTrace();
		}

	}
	
	@Test(enabled = true, priority = 1, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListFromProductDetailPage() {
		topBarSelect("What's New");
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), 1);
	
	}
	
	@Test(enabled = true, priority = 2, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListByHoverProduct() {
		topBarSelect("What's New");
		wp.addToWishListByHoverOver(2);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), 2);
	}
	
	@Test(enabled = true, priority = 3, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void removeAllWishList() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		mp.deletingAllProductFromWishList();
		String expectedText = "You have no items in your wish list.";
		String actualText = mp.emptyWishListMessage.getText();
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test(enabled = true, priority = 4, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addMoreThanOneToWishListByHoverProduct() {
		topBarSelect("What's New");
		int numOfProduct = 4;
		wp.addingNProductstoWishList(numOfProduct);
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), numOfProduct);
	}
	
	@Test(enabled = true, priority = 5, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void updateWishList() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		mp.editingWistList(0);
		pp.selectSizeAndColor("XS", "White");
		click(pp.updateWishListLink);
		String currentURL = getDriver().getCurrentUrl();
		Assert.assertTrue(currentURL.contains("wishlist"));
	}
	
	@AfterMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logOut() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);
	}

}
