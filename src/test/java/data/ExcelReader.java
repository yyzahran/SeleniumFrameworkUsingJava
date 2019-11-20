package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;
	
	public FileInputStream getFileInputStream() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\User Data.xlsx";
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file not found. Terminating process... Check file path of the test data");
			System.exit(0);
		}
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException {
		fis = getFileInputStream();
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int rowsNumber = (sheet.getLastRowNum() + 1);
		int columnsNumber = 4;
		
		String [][] excelDataArray = new String[rowsNumber][columnsNumber];
		
		for (int i = 0; i < rowsNumber; i++) {
			for (int j = 0; j < columnsNumber; j++) {
				XSSFRow row = sheet.getRow(i);
				excelDataArray[i][j] = row.getCell(j).toString();
			}
		}
		workBook.close();
		return excelDataArray;
	}
	
}
