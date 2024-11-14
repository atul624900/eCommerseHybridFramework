package utils_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Utilities  {
	

	public static String timeStamp()
	{
	Date date =new Date();
	String str=date.toString();
	str=str.replace(" ","_").replace(":","_");
	return str;
	
	}
	
	public static Object[][] supplyTestData(String sheet) throws IOException
	{
		
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\PropertiesPackage\\TestData.xlsx");
		XSSFWorkbook testData = null;
		try {
		FileInputStream fisData = new FileInputStream(excelFile);
		testData = new XSSFWorkbook(fisData);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		XSSFSheet sheetName=testData.getSheet(sheet);
		int rows=sheetName.getLastRowNum();
		int column = sheetName.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][column];
		int i=0,j=0;
		
		for(i=0;i<rows;i++)
		{
			XSSFRow row = sheetName.getRow(i+1);
			for(j=0;j<column;j++)
			{
				XSSFCell col = row.getCell(j);
				CellType cell = col.getCellType();
				
				switch(cell){
				
				case STRING:
				{
					data[i][j]=col.getStringCellValue();
					break;
				}
				case NUMERIC:
				{
					data[i][j]=Integer.toString((int)col.getNumericCellValue());
					break;
				}
				case BOOLEAN:
				{
					data[i][j]=col.getBooleanCellValue();
				}
				
				}
					
			}
			
		}
		return data;
		
		
		
	}
	
	

}
