package utilities;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CommonMethod extends PageInitializer {

	public static void hoverOver(WebElement element) {
		Actions act = new Actions(getDriver());
		act.moveToElement(element).build().perform();
	}

	public static void sendTextToAlert(String text) {
		try {
			Alert alert = getDriver().switchTo().alert();
			alert.sendKeys(text);
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.screenshot_filepath + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
		return picBytes;
	}

	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("-yyyy-MM-dd HH.mm.ss");
		return sdf.format(date.getTime());
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.explicit_wait_time);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean isDemoMode = true;
	public static Faker faker = new Faker();

	public String randomFirstName() {

		return faker.name().firstName();
	}

	public String randomFlag() {
		faker = new Faker();

		return faker.country().flag();
	}

	public String randomState() {
		return faker.address().state();
	}

	/*
	 * 
	 * This method for sending String(text) to the element we have given.
	 * 
	 * @params: Webelement element = it is accepting the webelement where we are
	 * sending the text String text = it is the parameter tha we are sending the
	 * String
	 */
	public static void sendKey(WebElement element, String text) {
		highLightElementMethod(element);
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * This method for clicking the given element
	 * 
	 */
	public static void click(WebElement element)  {
		highLightElementMethod(element);
		waitForClickability(element).click();
	}

	/*
	 * This method for assertion check the title
	 */
	public static void assertTitle(String text) {
		assertTrue(driver.getTitle().contains(text));

		/*
		 * This is just wait from mili sec. to sec
		 */
	}

	public static void wait(double second) {
		try {
			Thread.sleep((int) (second * 1000));
		} catch (Exception e) {

		}

	}

	/*
	 * this is indicator for element blinks
	 */
	public static void highLightElementMethod(WebElement element) {

		try {
			if (isDemoMode) {
				for (int i = 0; i <= 2; i++) {

					// Create object of a JavascriptExecutor interface
					JavascriptExecutor js = (JavascriptExecutor) driver;
					// use executeScript() method and pass the arguments
					// Here i pass values based on css style. Yellow background color with solid red
					// color border.
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							element);

					wait(0.2);

					// Create object of a JavascriptExecutor interface
					js = (JavascriptExecutor) driver;
					// use executeScript() method and pass the arguments
					// Here i pass values based on css style. Yellow background color with solid red
					// color border.
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');",
							element);

					wait(0.2);

					// Create object of a JavascriptExecutor interface
					js = (JavascriptExecutor) driver;
					// use executeScript() method and pass the arguments
					// Here i pass values based on css style. Yellow background color with solid red
					// color border.
					js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');",
							element);
				}
			}
		} catch (Exception e) {

		}

	}

	/*
	 * this is getting the title
	 */
	public static void getTittle() {
		driver.getTitle();
	}

	/*
	 * this is getting the title
	 */
	public static void getTittlez() {
		driver.getTitle();
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	// methods checks if radio/checkbox is enabled and clicks on it
	public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String valueToBeSelected) {
		String actualValue;
		for (WebElement el : radioOrcheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(valueToBeSelected)) {
				el.click();
				break;
			}
		}
	}

	public static void selectDropDownValue(WebElement dropDownElement, String textToSelect) {
		try {
			Select select = new Select(dropDownElement);
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	public static void selectDropDownIndex(WebElement dropDownElement, int indexValue) {
		try {
			Select select = new Select(dropDownElement);
			int size = select.getOptions().size();
			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	public static WebElement waitForVisibility(WebElement element) throws Exception {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	// js executer
	public static JavascriptExecutor getJSObject() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;
	}

	public static void jsClick(WebElement element) throws Exception {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static String jsGetText(WebElement element) throws Exception {
		return (String) getJSObject().executeScript("return arguments[0].value", element);
	}

	/*
	 * This method use for selecting top bar menu
	 * 
	 */

	public static void topBarSelect(String menu) {
		for (WebElement eachElement : cp.topBarMenu) {
			if (eachElement.getText().equalsIgnoreCase(menu)) {
				eachElement.click();
				break;
			}

		}
	}

	public static void selectItem(WebElement element, String item) {

		Select sec = new Select(element);
		sec.selectByVisibleText(item);

	}

	/*
	 * This method use for removing products from wish list by index
	 */

	public void deletingAllProductFromWishList() {
		try {
			click(cp.customerMenuToggle);
			cp.customerMenuSelect(1);
			if (mp.removeWishListIcon.size() != 0) {
				for (int i = mp.removeWishListIcon.size() - 1; i >= 0; i--) {
					CommonMethod.hoverOver(mp.myWishListProducts.get(i));
					mp.removeWishListIcon.get(i).click();
				}
			}
		} catch (Exception e) {
			System.out.println("There is no product in wish list before test start");
			e.printStackTrace();
		}
	}

}
