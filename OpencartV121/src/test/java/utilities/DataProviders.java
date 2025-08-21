package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\LoginTestDataOpenCart.xlsx";	//taking excel file path for test data.
		ExcellUtility xlutil=new ExcellUtility(path);	//creating object for excel utility.
		//String sheetname=xlutil.getFirstSheetName();	// taking first sheet Name 
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String[][] logindata = new String[totalrows][totalcols];	//created for two dimensional array which can store email & password
		for(int i=1;i<=totalrows;i++)	//1		//read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++)		//0		i is row j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);		//1,0
			}
		}
		return logindata;	//returning two dimension array.
		
	//DataProvider 2
	
	//DataProvider 3
		
	//DataProvider 4
		
	}
}
