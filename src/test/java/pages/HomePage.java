package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethod;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='panel header']/ul/li/a")
	public List<WebElement> headerMenu;
	
	@FindBy(xpath = "//*[@class='product-items widget-product-grid']/li")
	public List<WebElement> homePageProduct;
	
	
	
	@FindBy(xpath = "//*[@class='action showcart']")
	public WebElement MyCart;
	//*[@class = 'action viewcart']
	@FindBy(xpath = "//*[@class='actions']/div/a") 
	public WebElement viewCart;
	
	@FindBy(xpath = "//*[@class = 'action action-delete']")
	public WebElement removeFromCart;
	
	@FindBy(xpath = "//*[@class = 'cart-empty']")
	public WebElement emptyCartText;
	
	@FindBy(xpath = "//*[@class='action primary checkout']")
	public WebElement proceedToCheckout;
	
	
	/*
	 * This method use for clicking top bar menu
	 */
	public void headerBarSelect(String menu) {
		for(WebElement eachElement : headerMenu) {
			if(eachElement.getText().trim().equalsIgnoreCase(menu)) {
				CommonMethod.click(eachElement);
				break;
			}		
		}
	}
  
}
