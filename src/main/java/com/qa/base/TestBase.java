package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.TestUtils;
import com.qa.utils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("C:\\Users\\Sourabh Agrawal\\PageObjectDesignPattern\\src\\main\\java\\com\\qa\\config\\config.properties");
			try {
				prop.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Sourabh Agrawal\\PageObjectDesignPattern\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\USER\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		event = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		event.register(eventListener);
		driver = event;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.implicitwait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
