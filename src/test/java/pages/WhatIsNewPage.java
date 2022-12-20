package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethod;

public class WhatIsNewPage {

	public WhatIsNewPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='product-item-info']")
	public List<WebElement> productList;

	@FindBy(xpath = "//*[@class='price-container price-final_price tax weee']/span/span")
	public List<WebElement> productPrice;

	@FindBy(xpath = "//*[@class='product-item-inner']/div/div[2]/a[1]")
	public List<WebElement> listOfWishListIcon;

	/*
	 * This method use for adding product by hover over product
	 */
	public void addToWishListByHoverOver(int productIndex) {
		CommonMethod.hoverOver(productList.get(productIndex));
		CommonMethod.click(listOfWishListIcon.get(productIndex));

	}

	/*
	 * This method use for addind n products to wish list
	 */

	public void addingNProductstoWishList(int numOfProduct) {

		try {

			for (int i = 0; i < numOfProduct; i++) {
				addToWishListByHoverOver(i);
				CommonMethod.topBarSelect("What's New");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
