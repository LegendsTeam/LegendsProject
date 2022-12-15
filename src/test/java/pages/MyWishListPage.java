package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethod;

public class MyWishListPage {
	
	public MyWishListPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='product-items']/li")
	public List<WebElement> myWishListProducts;
	
	@FindBy(xpath = "//*[@class='toolbar wishlist-toolbar'][1]/div/p/span")
	public WebElement numOfProductInWishList;
	
	@FindBy(xpath = "//*[@class='product-item-inner']/div[3]/a[1]")
	public List<WebElement> editWishListIcon;
	
	@FindBy(xpath = "//*[@class='product-item-inner']/div[3]/a[2]")
	public List<WebElement> removeWishListIcon;
	
	@FindBy(xpath = "//*[@class='message info empty']/span")
	public WebElement emptyWishListMessage;
	
	@FindBy(xpath = "//*[@class='message-success success message']")
	public WebElement successMessage;
	
	
	
	
	
	
	
	
	
	
	/*
	 * This method use for geting number of products in wish list
	 */
	
	public int getNumberOfProductsInWishList() {
		String numOfProductsInWishList = numOfProductInWishList.getText();
		return  Integer.parseInt(numOfProductsInWishList.substring(0, numOfProductsInWishList.indexOf(" ")));
	}
	
	/*
	 * This method use for removing products from wish list by index
	 */
	
	public void deletingAllProductFromWishList() {
		if(removeWishListIcon.size() != 0) {
			for(int i = removeWishListIcon.size() - 1; i >= 0; i--) {
				CommonMethod.hoverOver(myWishListProducts.get(i));
				removeWishListIcon.get(i).click();
			}	
		}
	}
	
	/*
	 * This method use for editing any product wish list by index
	 */
	
	public void editingWistList(int index) {
		CommonMethod.hoverOver(myWishListProducts.get(index));
		editWishListIcon.get(index).click();
	}

}
