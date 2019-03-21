package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	public static ArrayList<Object[]> excelData(String fileName) throws Exception {
		ArrayList<Object[]> list= new ArrayList<Object[]>();
		FileInputStream file = new FileInputStream(fileName);
         wb = new XSSFWorkbook(file);
         sh = wb.getSheetAt(0);
         System.out.println(sh.getLastRowNum());
         for(int i=1;i<=sh.getLastRowNum();i++) {
        	 //for(int j=0;j<=sh.getRow(i).getLastCellNum();j++) {
        	String title = sh.getRow(i).getCell(0).getStringCellValue();
        	String firstName = sh.getRow(i).getCell(1).getStringCellValue();
        	String lastName = sh.getRow(i).getCell(2).getStringCellValue();
        	String company = sh.getRow(i).getCell(3).getStringCellValue();
        	Object[] obj = {title,firstName,lastName,company};
        	list.add(obj);
        	 
        	}
         return list;
	}


}
