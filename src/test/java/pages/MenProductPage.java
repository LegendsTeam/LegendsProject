package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class MenProductPage {
	
	public MenProductPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='level2 nav-3-1-1 category-item first ui-menu-item']")
	public WebElement menJackets;
	
	@FindBy(xpath = "//*[@class='products list items product-items']/li")
	public List<WebElement> montanaWindJacket;
}
