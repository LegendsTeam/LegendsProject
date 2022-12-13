package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class ProductDetailPage {
	
	public ProductDetailPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='swatch-attribute-options clearfix']/div")
	public List<WebElement> sizeAndColorList;
	
	@FindBy(xpath = "//*[@class='product-addto-links']/a[1]")
	public WebElement addToWishListLink;
	
	@FindBy(xpath = "//*[@class='product-addto-links']/a[2]")
	public WebElement addToWishCompareLink;
	
	@FindBy(id = "product-addtocart-button")
	public WebElement addToCartButton;
	
	@FindBy(id = "qty")
	public WebElement qtyInputField;
	
	@FindBy(xpath = "//*[@class='product-addto-links']/a[1]")
	public WebElement updateWishListLink;
	
	@FindBy(xpath = "//*[@class='counter qty']/span")
	public WebElement itemInCart;	
	
	
	
	
	
	
	
	/*
	 * This method  use to select size and color on ProductDetailPage
	 */

	public void selectSizeAndColor(String size, String color) {
		for (WebElement webElement1 : sizeAndColorList) {
			if (webElement1.getText().equalsIgnoreCase(size)) {
				webElement1.click();
				break;
			}

		}
		for (WebElement webElement2 : sizeAndColorList) {
			if (webElement2.getAttribute("aria-label").equalsIgnoreCase(color)) {
				webElement2.click();
				break;
			}
		}

	}

}
