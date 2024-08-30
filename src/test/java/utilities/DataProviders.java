package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path =".\\testData\\loginData.xlsx";
		
		ExcelUtils xlutil = new ExcelUtils(path);
		
		int rowCount = xlutil.getrowCount("Test");
		int cellCount = xlutil.getcellCount("Test", 1);
		
		String loginData[][]= new String[rowCount][cellCount];
		
		for(int r=1;r<=rowCount;r++) {
			
			for(int c=0;c<cellCount;c++){
				
			loginData[r-1][c]= xlutil.getcellData("Test", r, c);
			}
		}
		
		return loginData;
		
	}
}
