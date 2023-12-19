package Data_Driven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class TestDataReading {
	
	public static RemoteWebDriver driver;
	public static ExtentSparkReporter exp;
	public static ExtentReports exe;
	
	@BeforeSuite
	
	public void extendReportreading() throws IOException {
		
		
		
		exeRepo();
		
		
		

	}
	
	
	
	
	
	public void exeRepo() {
		
		exp = new ExtentSparkReporter("Myreort.html");
		exe = new ExtentReports();
		
		exe.attachReporter(exp);
		

	}
	
	
	@DataProvider(name = "login")
	
	public String[][] dataDist() throws IOException {
		
		String [][] dat = excelReading();
		
		return dat;

	}
	
	
	public String[][] excelReading() throws IOException {
		
		FileInputStream fs = new FileInputStream("C:\\Users\\navve\\eclipse-workspace\\DataDriven_Framework\\TestNG_TestData.xlsx");
		
		XSSFWorkbook sheet = new XSSFWorkbook(fs);
		
		XSSFSheet sheetAt = sheet.getSheetAt(0);
		
		int NumberOfRows = sheetAt.getPhysicalNumberOfRows();
		int Numberofcolumn = sheetAt.getRow(0).getPhysicalNumberOfCells();
		
		//System.out.println(NumberOfRows);
		
		//System.out.println(Numberofcolumn);
		
		String stringCellValue = sheetAt.getRow(1).getCell(1).getStringCellValue();
		
		//System.out.println(stringCellValue);
		
		
		
		String data[][] = new String[NumberOfRows-1][Numberofcolumn];
		
		for (int i = 1; i < NumberOfRows; i++) {
			
			for (int j = 0; j < Numberofcolumn; j++) {
				
				data[i-1][j] = sheetAt.getRow(i).getCell(j).getStringCellValue();
				
			}
			
		}
		
		return data;

	}
	
	//@AfterSuite
	public void tearDwn() {
		 
		driver.close();

	}

}
