package tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.CommonMethod;
import utilities.ExcelUtility;

@Listeners(utilities.MyListener.class)
public class Test07WriteExcelFromOrderHistory extends CommonMethod {

	@BeforeMethod(enabled = true)
	public void logIn() {
		signIn();
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void testWriteExcelFromOrderHistory() throws IOException {
		click(cp.customerMenuToggle);
		cp.customerMenuSelect(0);
		click(ca.myOrderButton);
		selectItem(op.seleclPerPage, "50");
		ExcelUtility.getExelFileOfOrderHistory(op.allRoll, op.allCell, op.headerRoll, "OrderHistory", "Order");

	}

}
