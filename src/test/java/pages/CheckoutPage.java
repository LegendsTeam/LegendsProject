package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class CheckoutPage {
	
	public CheckoutPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath ="//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
	public WebElement shippingMethod;
	
	@FindBy(xpath ="//*[@class='button action continue primary']")
	public WebElement clickNextButton;
	
	@FindBy(xpath = "//*[@class='billing-address-same-as-shipping-block field choice']/input")
	public WebElement sameShippingAndBillingAddress;
	
	@FindBy(xpath = "//*[@class='checkout methods items checkout-methods-items']/li/button")
	public WebElement proceedToCheeckout;
	
	@FindBy(xpath = "//*[@class='primary']/a")
    public WebElement continueShopping;
	
	@FindBy(xpath = "//*[@class='action primary checkout']")
	public WebElement placeOrderBotton;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a/strong")
    public WebElement comfirmationNumber;


}
