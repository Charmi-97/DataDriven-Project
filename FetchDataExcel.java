package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchDataExcel {

	public static String[][] readexcel(String filename, String sheetname) throws IOException {
		File file = new File("DataSheet.xlsx");
		FileInputStream ips = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(ips);
        XSSFSheet sh = (XSSFSheet) wb.getSheet("Sheet1");
        
        int rowNum = sh.getLastRowNum();        
        int colNum = sh.getRow(0).getLastCellNum();
        
        System.out.println(rowNum);
        System.out.println(colNum);
        
        String[][] data = new String[rowNum][colNum];
        
        for (int i = 0; i < rowNum; i++) {
        	Row row = sh.getRow(i);
        	 
        	for (int j = 0; j < colNum; j++) {
        		 
        		 String value = row.getCell(j).getStringCellValue();  
        		 data[i][j] = value;
        		 }
        }
        
		return data;
	}
}

	

