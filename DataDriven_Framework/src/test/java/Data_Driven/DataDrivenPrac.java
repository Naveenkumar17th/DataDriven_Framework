package Data_Driven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenPrac extends TestDataReading {
	public static int count = 1;
	
	@Test(dataProvider = "login", dataProviderClass = TestDataReading.class)
	
	
	public void checkingLogin(String[] str) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		exe.createTest("test:"+ count);
		
		System.out.println(str[0] +":"+ str[1]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		TestDataReading.driver.findElement(By.name("username")).sendKeys(str[0]);
		
		TestDataReading.driver.findElement(By.name("password")).sendKeys(str[1]);
		
		TestDataReading.driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
		exe.flush();
		
		count++;

	}
	


	
	

}
