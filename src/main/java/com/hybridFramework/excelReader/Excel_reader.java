package com.hybridFramework.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reader {

	public String[][] getExcelData(String excellocation, String sheetname) {

		String dataSets[][] = null;
		try {
			FileInputStream file = new FileInputStream(new File(excellocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int totalRow = sheet.getLastRowNum() + 1;
			int totalColumm = sheet.getRow(0).getLastCellNum();

			dataSets = new String[totalRow - 1][totalColumm];
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			int t = 0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (i++ != 0) {
					int k = t;
					t++;

					Iterator<Cell> cellIterator = row.cellIterator();
					int j = 0;

					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();

						switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								System.out.print(k + ",");
								System.out.print(j + " = ");
								dataSets[k][j++] = cell.getStringCellValue();
								System.out.println(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_STRING:
								System.out.print(k + ",");
								System.out.print(j + " = ");
								dataSets[k][j++] = cell.getStringCellValue();
								System.out.println(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								System.out.print(k + ",");
								System.out.print(j + " = ");
								dataSets[k][j++] = cell.getStringCellValue();
								System.out.println(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA:
								System.out.print(k + ",");
								System.out.print(j + " = ");
								dataSets[k][j++] = cell.getStringCellValue();
								System.out.println(cell.getStringCellValue());
								break;
							default:
								dataSets[k][j++] = cell.getStringCellValue();
						}
					}

				}
			}
			file.close();
			return dataSets;
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		String excellocation = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\hybridFramework\\data\\TestData.xlsx";
		String sheetname = "LoginTestData";
		Excel_reader excel = new Excel_reader();
		excel.getExcelData(excellocation, sheetname);
	}
}
