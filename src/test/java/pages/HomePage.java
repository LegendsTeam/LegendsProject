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
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a/strong")
	public WebElement ComfNumber;
	
	public void headerBarSelect(String menu) {
		for(WebElement eachElement : headerMenu) {
			if(eachElement.getText().trim().equalsIgnoreCase(menu)) {
				eachElement.click();
				break;
			}
			
		}
	}
	
	
	
	

}
