package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class CommonPage {

	public CommonPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	//@FindBy(xpath = "//*[@id='ui-id-2']/li/a/span")
	//public List<WebElement> topBarMenu;
	
	@FindBy(xpath = "//*[@class='page-header']/div/div/ul/li[2]")
	public WebElement customerMenuToggle;
//	
//	@FindBy(xpath = "//*[@class='customer-welcome active']/div/ul/li")
//	public List<WebElement> customerMenu;
	
	@FindBy(xpath = "//*[@class='level-top ui-corner-all']")
	public List<WebElement> topMenu;
	
	@FindBy(xpath = "//*[@class='level1 nav-3-1 category-item first parent ui-menu-item']/a")
	public WebElement menTopMenu;
	
	@FindBy(xpath = "//*[@class='level2 nav-3-1-1 category-item first ui-menu-item']")
	public WebElement menJackets;
	
	@FindBy(xpath = "//*[@class='products list items product-items']/li")
	public List<WebElement> montanaWindJacket;
	
	@FindBy(xpath = "//*[@class='action primary tocart']")
	public WebElement addToCart;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
	public WebElement cartShown;
	
	@FindBy(xpath = "//*[@class='action primary checkout']")
	public WebElement proceedToCheckout;
	
	@FindBy(xpath ="//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
	public WebElement shippingMethod;
	
	@FindBy(xpath ="//*[@class='button action continue primary']")
	public WebElement clickNextButton;
	
	@FindBy(xpath = "//*[@class='billing-address-same-as-shipping-block field choice']")
	public WebElement sameShippingAndBillingAddress;
	
	@FindBy(xpath = "//*[@class='action primary checkout']")
	public WebElement clickPlaceOrder;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	public WebElement profileDownArrow;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
	public WebElement clickOnMyAccount;
	
	@FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")
	public WebElement clickOnMyOrder;
	
	
	@FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[1]/span")
	public WebElement clickOnViewOrder;
	
	@FindBy(xpath = "//*[@class='action print']")
	public WebElement clickOnPrintOrder;
	
	@FindBy(xpath = "//*[@class='action order']")
	public WebElement clickOnReorder;
	
	
	
//	@FindBy(xpath = "//*[@class='action primary checkout']")
//	public void WebElement proceedToCheckout);
//	
	/*
	 * This method use for click customer menu by index
	 * 0 ===> My Account
	 * 1 ===> My Wist List
	 * 2 ===> Sign Out
	 */
	
	public void customerMenuSelect(int index) {
		customerMenu.get(index).click();
	}

}
