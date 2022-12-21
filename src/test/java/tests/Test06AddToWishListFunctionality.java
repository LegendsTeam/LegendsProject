package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethod;

@Listeners(utilities.MyListener.class)
public class Test06AddToWishListFunctionality extends CommonMethod {

	@BeforeMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logIn() {
		signIn();
	}
	
	@Test(enabled = true, priority = -1, groups = "noLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListBeforeSuccessfullyLogIn() {
		topBarSelect(getProperty("menu"));
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		String expectErrorMessage = getProperty("expectErrorMessage");
		Assert.assertEquals(lp.errorMessages.getText(), expectErrorMessage);

	}

	
	@Test(enabled = true, priority = 1, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListFromProductDetailPage() {
		deletingAllProductFromWishList();
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		int numOfProductInWishList = mp.getNumberOfProductsInWishList();
		topBarSelect(getProperty("menu"));
		click(wp.productList.get(0));
		click(pp.addToWishListLink);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), numOfProductInWishList + 1);
	}
	
	@Test(enabled = true, priority = 2, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void deleteWishList() {
		deletingAllProductFromWishList();
		String expectedText = getProperty("expectedText") ;
		String actualText = mp.emptyWishListMessage.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(enabled = true, priority = 3, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addToWishListByHoverProduct() {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(1);
		int numOfProductInWishList = mp.getNumberOfProductsInWishList();
		topBarSelect(getProperty("menu"));
		wp.addToWishListByHoverOver(2);
		Assert.assertEquals(mp.getNumberOfProductsInWishList(), numOfProductInWishList + 1);
	}
	
	@Test(enabled = true, priority = 4, groups = "mustLogin", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addMoreThanOneToWishListByHoverProduct() {
		deletingAllProductFromWishList();
		topBarSelect(getProperty("menu"));
		int numOfProduct = 3;
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
		pp.selectSizeAndColor(getProperty("size"), getProperty("color"));
		click(pp.updateWishListLink);
		Assert.assertTrue(mp.successMessage.getText().contains(getProperty("successMessage")));
	}
	
	@AfterMethod(enabled = true, onlyForGroups = "mustLogin")
	public void logOut() {
		signOut();
	}

}
