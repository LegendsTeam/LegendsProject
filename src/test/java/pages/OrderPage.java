package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class OrderPage {
	
	public OrderPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id='my-orders-table']/thead/tr/th")
	public List<WebElement> headerRoll;
	
	@FindBy(xpath = "//*[@id='my-orders-table']/tbody/tr")
	public List<WebElement> allRoll;
	
	@FindBy(xpath = "//*[@id='my-orders-table']/tbody/tr/td")
	public List<WebElement> allCell;
	
	@FindBy(id = "limiter")
	public WebElement seleclPerPage;

	@FindBy(xpath = "//*[@class='action order']")
	public WebElement clickOnReorder;
	
	@FindBy(xpath = "//*[@id='my-orders-table']/tbody/tr/td/a[1]")
	public List<WebElement> viewOrder;
	
	@FindBy(xpath = "//*[@class='items order-links']/li")
	public WebElement itemOrder;

}
