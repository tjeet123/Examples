package excelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// if u pass the path of excel,make sure extension should be xlsx
		// fis object would have permission to read file, u have pass object to read the file 
		// FileinputStream is a class in java which have permission to read the file
		FileInputStream fis = new FileInputStream("C:\\Users\\jitendra\\Desktop\\demodata.xlsx");
		// how workbook know which file need to access, so need to set path of excel in
		// file input stream
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify testcases column, by scanning the entire first row
				// Once column is identified, then scan entire testcase column to identify
				// purchase testcase row
				// after you grab purchase testcase row, pull all the data of that row and feed
				// it into test

				// This Sheet will have all the rows, how to iterator each and every row
				Iterator<Row> row = sheet.rowIterator(); // sheet is collection of rows
				// First need access of first row,we need access and scan this first row, Access
				// to specific row is done by
				// assigning it as firstrow
				Row firstRow = row.next();
				// To scan that row by reading each and every cell
				Iterator<Cell> cell = firstRow.cellIterator(); // row is collection of cell
				// Row is collection of cell, so it would be at first cell
				cell.next();
				// Need to read each and every cell value and compare cell value with the
				// "Testcases"
				// hasNext will see whether next cell is present in the sheet or not, it will
				// not move
				int k = 0, column = 0;
				while (cell.hasNext()) {
					// It will move cursor to next cell
					Cell value = cell.next();
					// Need to read that cell entirely & compare it with testcases text
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						// We have reached but yet not grab the index of that column
						// Column no. for TestCases text would be 0.
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// Once column is identified, then scan entire testcase column to identify
				// purchase testcase row
				// Now need to scan each and every row in the sheet to get purchase text
				while (row.hasNext()) {
					Row r = row.next();
					// Here we are first getting the column 0 value and then verifying it
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
						// if r matches then need to grab all the cell of that row
						// after you grab purchase testcase row, pull all the data of that row and feed
						// it into test
						Iterator<Cell> cellVaule = r.cellIterator();
						while (cellVaule.hasNext()) {
							System.out.println(cellVaule.next().getStringCellValue());

						}
					}
				}

			}
		}

	}

}
