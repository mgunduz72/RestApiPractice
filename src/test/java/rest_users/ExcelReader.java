package rest_users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public static void main(String[] args) throws Exception {
		
    	File driverData = new File("/Users/emin/Desktop/DriverData.xlsx");
		
		Workbook wb = WorkbookFactory.create(driverData);
		Sheet sh = wb.getSheetAt(0);
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(0);
		
		System.out.println(cl);
		
		int rows = sh.getLastRowNum();
		System.out.println(rows);
		
		int column = rw.getLastCellNum();
		System.out.println(column);
		
		
		Cell cell = sh.getRow(1).getCell(2);
		System.out.println(cell);
		
		String cellK = sh.getRow(0).getCell(1).toString();
		System.out.println(cellK);
		
//		for (int i = 1; i <=rows; i++) {
//			System.out.println("rows number = "+(i+1));
//			//Row row = sh.getRow(i);
//			for (int j = 0; j <column; j++) {
//				
//				Cell cellAll = sh.getRow(i).getCell(j);
//				
//				System.out.print(cellAll + "=======");
//			}
//			
//			System.out.println();
//		}
		
		List<Map<String, String>> lst = new ArrayList<>();
		Map<String, String> map = new HashMap();
		
		for (int i = 0; i <rows; i++) {
			System.out.println("rows number = "+(i+1));
			//Row row = sh.getRow(i);
			
			for (int j = 0; j <column; j++) {
				
				String cellKey = sh.getRow(0).getCell(j).toString();
				String cellValue = sh.getRow(i+1).getCell(j).toString();
				map.put(cellKey, cellValue);
				
		
			}
			
			lst.add(map);
			System.out.println(map);
		}

		
		List<Driver> dr = new ArrayList<>();
		for (int i = 1; i <=rows; i++) {
		
			
			String driverId = sh.getRow(i).getCell(0).toString();
			String nationality = sh.getRow(i).getCell(5).toString();
			String givenName = sh.getRow(i).getCell(2).toString();
			String familyName = sh.getRow(i).getCell(3).toString();
			String dateOfBirth = sh.getRow(i).getCell(4).toString();
			String url = sh.getRow(i).getCell(1).toString();
			
			Driver driver = new Driver(driverId, nationality, givenName, familyName, dateOfBirth,
					url);
			
			dr.add(driver);
	
		}
		System.out.println(dr);
		
		
		
		
		
		
		
		
	
	}
	
	

}
