package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
//	Get the data from properties file
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String value = pObj.getProperty(key);
		return value;
	}

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {

		FileInputStream fis1 = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);

		Sheet sh = wb.getSheet(sheetName);

		Row row = sh.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String value = cell.getStringCellValue();

		wb.close();

		return value;

	}
}
