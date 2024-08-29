package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReturn {


	public ArrayList<String> getData(String testcaseName) throws IOException 
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\ExcelData\\ExcelSheetData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheetCount = workbook.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("loginDetails"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row =sheet.rowIterator();
				Row firstRow = row.next();
				
				Iterator<Cell> cell =firstRow.cellIterator();
				cell.next();
				int k=0, column=0;
				while(cell.hasNext())
				{
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Username"))
					{
						column = k;
					}
					k++;
				}
				
				System.out.println(column);
				while(row.hasNext())
				{
					Row rowCell = row.next();
					if(rowCell.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						Iterator<Cell> cellValue = rowCell.cellIterator();
						while(cellValue.hasNext())
						{	
							//This code is limited to string value only,so if we pass any numeric value in excelsheet this code will get fail
							//So will add wrapper to the code to check the numeric value or string value
							//a.add(cellValue.next().getStringCellValue()); // Extracting value from here and it send string value only
							//will pass excel next value to cell c
							Cell c = cellValue.next();
							//Now need to check what data it is (will check the data as what kind of datatype cell c has)
							
//							if(c.getCellTypeEnum()==CellType.STRING)
//							{
//								a.add(c.getStringCellValue());
//							}
//							else {
//								//Here we are adding to arrrayList are String we told that in begining
//								//Here we are sending numeric value to arraylist
//								//So need to convert numeric value to String through POI API
//								//In excel data would pass in string only eventhough its numeric value
//								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
//								
//							}
							switch(c.getCellType()) {
								
							case STRING : 
								a.add(c.getStringCellValue());
								break;
								
							case NUMERIC:
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								break;
							}
							
						}
					}
					
				}
				
			}
		}
	
	return a;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
	}
}