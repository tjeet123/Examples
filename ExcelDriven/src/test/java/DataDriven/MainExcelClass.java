package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainExcelClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//if u pass the path of excel,make sure extension should be xlsx
		//fis object would have permission to read file, u have pass object to read the file
		//FileinputStream is a class in java which have permission to read the file
		FileInputStream fis = new FileInputStream("C:\\Users\\jitendra\\Desktop\\demodata.xlsx");
		//how workbook know which file need to access, so need to set path of excel in file input stream 
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		
		int sheetCount = workbook.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//Identify testcases column, by scanning the entire first row
				//Once column is identified, then scan entire testcase column to identify purchase testcase row
				//after you grab purchase testcase row, pull all the data of that row and feed it into test
				int rowCount = sheet.getFirstRowNum();
				System.out.println(rowCount);
				
				
			}
		}
		
	}

}
