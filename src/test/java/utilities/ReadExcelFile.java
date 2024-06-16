package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelFile {
	
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow rows;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			return cell.getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
	}// to fetch cell values
	
	public static int getRowCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);
			
			int totalRows = excelsheet.getLastRowNum()+1;
			workbook.close();
			
			return totalRows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}

	}
	
	public static int getColCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);
			
			int totalCell = excelsheet.getRow(0).getLastCellNum();
			workbook.close();
			
			return totalCell;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	
}
