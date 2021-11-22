package com.mindtree.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReading {
	static FileInputStream excelFilePath ;
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	static XSSFCell cell;

	public ExcelReading(String path) throws IOException{
		excelFilePath= new FileInputStream(path);
		wb = new XSSFWorkbook(excelFilePath);
	}
	public int get_Number_Of_Rows(int Sheetindex) throws IOException {
		ws = wb.getSheetAt(Sheetindex);
		int rows = ws.getLastRowNum();
		return rows;
	}
	public int get_Number_Of_Cols(int Sheetindex,int rownum) throws IOException {
		ws = wb.getSheetAt(Sheetindex);
		XSSFRow row = ws.getRow(rownum);
		int col = row.getLastCellNum();
		return col;
	}
	public String get_data(int Sheetindex,int rownum,int colnum) {
		ws = wb.getSheetAt(Sheetindex);
		XSSFRow row = ws.getRow(rownum);
		DataFormatter dataFormat = new DataFormatter();
		cell=row.getCell(colnum);
		String cellData = dataFormat.formatCellValue(cell);
		return cellData;

	}




}
