package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtility {

	private static XSSFWorkbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {

		try {
			FileInputStream files = new FileInputStream(filePath);
			book = new XSSFWorkbook(files);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// load the worksheet
	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	// row count
	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	// col count
	private static int colCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		if (sheet.getRow(rowIndex).getCell(colIndex) == null) {
			return "";
		} else {
			return sheet.getRow(rowIndex).getCell(colIndex).toString();
		}
	}

	public static Object[][] excelIntoArray(String filePath, String sheetName) {
		openExcel(filePath);
		loadSheet(sheetName);
		int rows = rowCount();
		int cols = colCount();

		Object[][] data = new Object[rows - 1][cols];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = cellData(i, j);
			}
		}
		return data;

	}
	
	public static void getExelFileOfOrderHistory(List<WebElement> allRoll, List<WebElement> allCell, List<WebElement> headerRoll, String fileName, String sheetName)
			throws IOException {

		// workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet = workbook.createSheet(sheetName);

		// creating a row object
		XSSFRow row;

		// This data needs to be written (Object[])
		Map<Integer, Object[]> orderHistory = new TreeMap<Integer, Object[]>();

		int numColum = headerRoll.size();
		int cellIndex = 0;
		for (int i = 0; i < allRoll.size(); i++) {

			// Order # Date Ship To Order Total Status Action
			if (i == 0) {
				Object[] obj = new Object[numColum];
				for (int j = 0; j < numColum; j++) {
					obj[j] = headerRoll.get(j).getText();
				}
				orderHistory.put(i, obj);

			} else {
				Object[] obj1 = new Object[numColum];
				for (int j = 0; j < numColum; j++) {
					obj1[j] =  allCell.get(cellIndex +j).getText();
				}
				orderHistory.put(i, obj1);
				cellIndex += numColum;
			}
		}

		Set<Integer> keyid = orderHistory.keySet();

		int rowid = 0;

		// writing the data into the sheets...

		for (Integer key : keyid) {

			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = orderHistory.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}

		// .xlsx is the format for Excel Sheets...
		// writing the workbook into the file...
		
		FileOutputStream out = new FileOutputStream(new File("src/test/resources/excelFiles/"+ fileName + CommonMethod.getTimeStemp() +".xlsx"));

		workbook.write(out);
		out.close();
		workbook.close();
	}

}
