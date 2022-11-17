package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_apmosys {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("E:\\Eclipse data\\Apmo\\excel sheet\\ApmoLogin.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		String uname=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String pass=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String url=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\admin\\\\Downloads\\\\chromedriver.exe");		
		WebDriver driver=new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(url);
	
	
	//	driver.findElement(By.name("email-address")).sendKeys(uname);	
		driver.findElement(By.xpath("//input[@name='email-address']")).sendKeys(uname);
		driver.findElement(By.name("next")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@name='next']")).click();
		
		
		
		
	}
	}
