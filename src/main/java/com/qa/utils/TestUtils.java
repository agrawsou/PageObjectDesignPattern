package com.qa.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.base.TestBase;

public class TestUtils extends TestBase {

	public static long pageLoad = 20;
	public static long implicitwait = 20;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeTheScreenshot() {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("C:\\Games\\error.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
