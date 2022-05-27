package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static  WebDriver driver ;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\BDD\\TestProject\\src\\main\\java\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() throws InterruptedException {

		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/umesh/Downloads/Chromedriver/chromedriver.exe");	
			//System.setProperty("webdriver.chrome.driver", "C:/Users/umesh/Downloads/chromedriver_win32 (6)/chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver","C:/Users/umesh/Downloads/Chromedriver/geckDriver.exe");
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}



}
