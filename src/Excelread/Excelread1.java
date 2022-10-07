package Excelread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread1 {
  /* read the data from excel with the help of Apache POI
   * Whole table is printed on console
   */
	public static void main(String[] args) throws IOException {
	String Filepath=".\\Data1.xlsx";
	
	FileInputStream inputstream=new FileInputStream (Filepath);
	     
	System.out.println(inputstream);
	
	XSSFWorkbook workbook = new XSSFWorkbook (inputstream);

	//XSSFSheet sheet=workbook.getSheet("sheet1");
	XSSFSheet sheet=workbook.getSheetAt(0);

	int rows=sheet.getLastRowNum();

	int cols=sheet.getRow(0).getLastCellNum();

	System.out.println(rows);
	System.out.println(cols);

	for (int r=0;r<=rows;r++) {
		
		XSSFRow row1=sheet.getRow(r);
		for(int c=0;c<cols;c++) 
		{
			
	    XSSFCell cell=row1.getCell(c);
	    
	   switch (cell.getCellType()) {
	   case STRING : System.out.print(cell.getStringCellValue()+" ");break;
	   case NUMERIC :System.out.print(cell.getNumericCellValue()+" ");break;
	   case BOOLEAN : System.out.print(cell.getBooleanCellValue()+" ");break;
	   
	                               }      
	    System.out.print("  -  ");
		}      
		System.out.println();
	}
}}


