package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='panel header']/ul/li/a")
	public List<WebElement> headerMenu;
	
	@FindBy(xpath = "//*[@class='product-items widget-product-grid']/li")
	public List<WebElement> homePageProduct;
	
	@FindBy(id = "product-addtocart-button")
	public WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='qty']")
	public WebElement ChangeQuantity;
	
	@FindBy(xpath = "//*[@class='action showcart']")
	public WebElement MyCart;
	//*[@class = 'action viewcart']
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a") 
	public WebElement ViewCart;
	
	@FindBy(xpath = "//*[@class = 'action action-delete']")
	public WebElement RemoveFromCart;
	
	@FindBy(xpath = "//*[@class = 'cart-empty']")
	public WebElement emptyCartText;
	
	@FindBy(xpath = "//*[@class='action primary checkout']")
	public WebElement proceedToCheckout;
	
	public void headerBarSelect(String menu) {
		for(WebElement eachElement : headerMenu) {
			if(eachElement.getText().trim().equalsIgnoreCase(menu)) {
				eachElement.click();
				break;
			}		
		}
	}
  
}
