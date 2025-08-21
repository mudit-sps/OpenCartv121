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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	public CellStyle style;
	
	public ExcellUtility(String path)
	{
		this.path=path;
	}
	
	public String getFirstSheetName() throws IOException
	{
		String sheetName="";
		try
		{
			fi=new FileInputStream(path);
			// Create a Workbook instance from the Excel file
			Workbook wb= WorkbookFactory.create(fi);
			sheetName = wb.getSheetName(0);
		     // Close the workbook
	        wb.close();
	        fi.close();
	        return sheetName;
    	} 
		catch (IOException e) 
		{
				e.printStackTrace();
				sheetName="";
				return sheetName;
		}
		
	}
	//getrowcount
	public int getRowCount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
		
	//getCell count
	public int getCellCount(String sheetname, int rw) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rw);
		int cellCount=row.getLastCellNum();
		return cellCount;
	}
	//getcelldata
	public String getCellData(String sheetName, int rw, int cl) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rw);
		cell=row.getCell(cl);
		
		DataFormatter df=new DataFormatter();		
		String data;
		try
		{
			data=df.formatCellValue(cell);		//Returns the formatted value of a cell as a String
		}
		catch(Exception e)
		{
			data="";
		}
		
		return data;
	}
	
	//setcelldata
	public void setCellData(String sheetName, int rw, int cl, String data) throws InvalidFormatException, IOException
	{
		File fl=new File(path);
		if(!fl.exists())		// If file not exists then create new file
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
		cell.setCellValue(data);
		
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
		
	}
	//fillgreencolor
	public void fillGreenColor(String sheetname, int rw, int cl) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rw);
		cell= row.getCell(cl);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	//fillredcolor
	public void fillRedColor(String sheetname, int rw, int cl) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rw);
		cell=row.getCell(cl);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
}
