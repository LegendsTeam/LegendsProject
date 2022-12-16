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

	@FindBy(xpath = "//*[@id='ui-id-2']/li/a/span")
	public List<WebElement> topBarMenu;

	@FindBy(xpath = "//*[@class='page-header']/div/div/ul/li[2]")
	public WebElement customerMenuToggle;

	@FindBy(xpath = "//*[@class='customer-welcome active']/div/ul/li")
	public List<WebElement> customerMenu;
	
	@FindBy(xpath = "//*[@class='level-top ui-corner-all']")
	public List<WebElement> topMenu;
	
	@FindBy(xpath = "//*[@class='level1 nav-3-1 category-item first parent ui-menu-item']/a")
	public WebElement menTopMenu;
	
	@FindBy(xpath = "//*[@class='header content']/a]")
	public WebElement homepageLink;

	/*
	 * This method use for click customer menu by index 0 ===> My Account 1 ===> My
	 * Wist List 2 ===> Sign Out
	 */

	public void customerMenuSelect(int index) {
		customerMenu.get(index).click();
	}

	
}
