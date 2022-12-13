package pages;

import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AddToCartPage {
	
	public AddToCartPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

}
