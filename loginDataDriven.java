package dataDriven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginDataDriven {

WebDriver driver;
	
	@BeforeTest
	public void openbrowser() {
		driver=  new EdgeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}           
	
	@Test
	public void testfb() throws IOException, InterruptedException {
		String [][] dataip = FetchDataExcel.readexcel("DataSheet", "Sheet1");
		for(int i = 1; i<dataip.length; i++) {
			String user = dataip[i][0];
			String pass = dataip[i][1];	
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(user);
			System.out.println(user);
			driver.findElement(By.id("pass")).sendKeys(pass);
			WebElement fplink = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
			fplink.click();			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.navigate().back();		
		}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
