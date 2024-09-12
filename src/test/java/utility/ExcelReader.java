package utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] getValueFromExcel(String excelName) {
		
		Object[][] data = null;
		
		try {
			
			String fileLocation = "/home/ramkumarra/eclipse-workspace/HybridFrameworkOrange/src/test/resources/data/login.xlsx";
			FileInputStream excelFile = new FileInputStream(fileLocation);
			
			XSSFWorkbook work = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = work.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);
			int columnCount= sheet.getRow(0).getLastCellNum();
			System.out.println(columnCount);
			
			data = new Object[rowCount][columnCount];
			
			for(int i=0;i<rowCount;i++) {
				
				try {
					
					XSSFRow row = sheet.getRow(i);
					
					for(int j=0;j<columnCount;j++) {
						String cellValue = "";
						try {
							cellValue = row.getCell(j).getStringCellValue();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						data[i][j] = cellValue;
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			work.close();
			excelFile.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return data;
 		
	}

}
