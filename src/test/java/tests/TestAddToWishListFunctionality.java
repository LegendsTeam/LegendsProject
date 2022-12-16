package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethod;
import utilities.MyScreenRecorder;

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
	public void addToWishListBeforeSuccessfullyLogIn() throws Exception {
		MyScreenRecorder.startRecording("addToWishListBeforeSuccessfullyLogIn");
		topBarSelect("What's New");
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		String expectErrorMessage = "You must login or register to add items to your wishlist.";
		Assert.assertEquals(expectErrorMessage, lp.errorMessages.getText());
		MyScreenRecorder.stopRecording();

	}
	
	@Test(enabled = true, priority = 0, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void removeAllWishListBeforeStartTest() throws Exception {
		MyScreenRecorder.startRecording("removeAllWishListBeforeStartTest");
		try {
			click(cp.customerMenuToggle);
			cp.customerMenuSelect(1);
			mp.deletingAllProductFromWishList();
			String expectedText = "You have no items in your wish list.";
			String actualText = mp.emptyWishListMessage.getText();
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception e) {
			System.out.println("There is product in wish list before test start");
			e.printStackTrace();
		}
		MyScreenRecorder.stopRecording();

	}
	
	@Test(enabled = true, priority = 1, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListFromProductDetailPage() throws Exception {
		MyScreenRecorder.startRecording("addToWishListFromProductDetailPage");
		topBarSelect("What's New");
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), 1);
		MyScreenRecorder.stopRecording();
	
	}
	
	@Test(enabled = true, priority = 2, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListByHoverProduct() throws Exception {
		MyScreenRecorder.startRecording("addToWishListByHoverProduct");
		topBarSelect("What's New");
		wp.addToWishListByHoverOver(2);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), 2);
		MyScreenRecorder.stopRecording();
	}
	
	@Test(enabled = true, priority = 3, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void removeAllWishList() throws Exception {
		MyScreenRecorder.startRecording("removeAllWishList");
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		mp.deletingAllProductFromWishList();
		String expectedText = "You have no items in your wish list.";
		String actualText = mp.emptyWishListMessage.getText();
		Assert.assertEquals(actualText, expectedText);
		MyScreenRecorder.stopRecording();
	}
	
	@Test(enabled = true, priority = 4, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addMoreThanOneToWishListByHoverProduct() throws Exception {
		MyScreenRecorder.startRecording("addMoreThanOneToWishListByHoverProduct");
		topBarSelect("What's New");
		int numOfProduct = 4;
		wp.addingNProductstoWishList(numOfProduct);
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), numOfProduct);
		MyScreenRecorder.stopRecording();
	}
	
	@Test(enabled = true, priority = 5, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void updateWishList() throws Exception {
		MyScreenRecorder.startRecording("updateWishList");
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		mp.editingWistList(0);
		pp.selectSizeAndColor("XS", "White");
		click(pp.updateWishListLink);
		Assert.assertTrue(mp.successMessage.getText().contains("has been updated in your Wish List"));
		MyScreenRecorder.stopRecording();
	}
	
	@AfterMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logOut() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(2);
	}

}
