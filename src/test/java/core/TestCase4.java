package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;




/**
 * @author Dmitry Nakhabtsev
 */
public class TestCase4 {

//TestNG execution	
@org.junit.Test
public void test1() throws InterruptedException, IOException {
	
/*	ChromeOptions options = new ChromeOptions();
	options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	options.addArguments("start-maximized");
	WebDriver driver = new ChromeDriver(options);*/
	
/*	// новая схема более явно (этот способ указания опций рекомендуется, начиная с версии 3.3):
	FirefoxOptions options = new FirefoxOptions().setLegacy(false);
	WebDriver driver = new FirefoxDriver(options);
*/
	
/*	// старая схема более явно (этот способ указания опций рекомендуется, начиная с версии 3.3):
	FirefoxOptions options = new FirefoxOptions().setLegacy(true);
	WebDriver driver = new FirefoxDriver(options);*/
	
	
	// Указание пути к браузеру при использовании Selenium 3.3 и новее:
	FirefoxOptions options = new FirefoxOptions();
	options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Nightly\\firefox.exe"))); //C:\Program Files\Nightly
	WebDriver driver = new FirefoxDriver(options);
	
	String url="http://localhost/litecart/admin/";
    
/*	String driverPath = "./src/main/resources/webdrivers/pc/MicrosoftWebDriver.exe";
    System.setProperty("webdriver.edge.driver", driverPath);*/
/*    System.out.println("driver initialization...");
    WebDriver driver = new EdgeDriver();
    System.out.println("continue...");*/
    

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	driver.get(url); //launch litecart
	driver.findElement(By.xpath(".//*[@id='box-login']/form/div[1]/table/tbody/tr[1]/td[2]/span/input")).sendKeys("admin");
	driver.findElement(By.xpath(".//*[@id='box-login']/form/div[1]/table/tbody/tr[2]/td[2]/span/input")).sendKeys("admin");
	driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
	
	
	Thread.sleep(3000);
	driver.quit();

}
}


