package com.comcast.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream("/ComcastCRMGUI/testscript-data/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;

	}

	public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String data)
			throws Exception, IOException {
		FileInputStream fis = new FileInputStream("/ComcastCRMGUI/testscript-data/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Cell cel = sh.createRow(rowNum).createCell(cellNum);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("/ComcastCRMGUI/testscript-data/Book2.xlsx");
		wb.write(fos);
		wb.close();

	}
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream("/ComcastCRMGUI/testscript-data/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh  = wb.getSheet(sheetName);
	    int rowCount = sh.getLastRowNum();
		return rowCount;
	}

}
