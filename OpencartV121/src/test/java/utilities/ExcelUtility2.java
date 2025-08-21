package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility2 {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility2(String path)
	{
		this.path=path;
	}
	
	//getRowCount
	public int getRowCount(String SheetName) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(SheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	//getCellCount
	public int getCellCount(String sheetName, int rw) throws IOException
	{
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rw);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}
	
	//getCellValue
	public String getCellValue(String sheetName, int rw, int cl) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rw);
		cell=row.getCell(cl);
		
		String data;
		DataFormatter df=new DataFormatter();
		
		try {
			data=df.formatCellValue(cell);		//Returns the formatted value of a cell as a String
		}
		catch(Exception e)
		{
			data="";
		}
		return data;
	}

	//setCellValue
	
	public void setCellValue(String sheetName, int rw, int cl, String value) throws InvalidFormatException, IOException
	{
		File fl=new File(path);
		if(!fl.exists())			// If file not exists then create new file
		{
			workbook=new XSSFWorkbook(fl);
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		if(workbook.getSheetIndex(sheetName)==-1)		// If sheet not exists then create new Sheet
		{
			workbook.createSheet(sheetName);
		}	
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rw)==null)		// If row not exists then create new Row
		{
			sheet.createRow(rw);
		}
		row=sheet.getRow(rw);
		cell=row.createCell(cl);
		cell.setCellValue(value);
		
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
	}
	//fillRedColor
	public void fillRedColor(String sheetName, int rw, int cl) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rw);
		cell=row.getCell(cl);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	//fillGreenColor
	public void fillGreenColor(String sheetName, int rw, int cl) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rw);
		cell=row.getCell(cl);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
				
		
	}
	
	
	
	
	
	
	
}
