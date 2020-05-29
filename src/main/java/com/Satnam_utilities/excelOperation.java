package com.Satnam_utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelOperation {
	public static String readData(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException

	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//textData//userdata.xlsx");
		Workbook w1 = WorkbookFactory.create(fis);
		String s=w1.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return s;
	}
	public static void writeData(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//textData//userdata.xlsx");	
		Workbook w2 = WorkbookFactory.create(fis);
		w2.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//textData//user.xlsx");
		w2.write(fos);
	}
}
