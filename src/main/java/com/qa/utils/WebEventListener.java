package com.qa.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating to: " + url);

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("User navigated to: " + url);

	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("User is navigating back in the browser");

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("User has navigated back in the browser");

	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("User is navigating forward in the browser");

	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("User has navigated forward in the browser");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("User is trying to refresh the browser");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("User has refreshed the browser");

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Element to be clicked " + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Element clicked " + element.toString());

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

		System.out.println("Trying to switch to " + windowName);

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Switched to " + windowName);

	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception is: "+throwable.getMessage());
		TestUtils.takeTheScreenshot();

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Trying to get the text of :" + element.toString());

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("The text of the element " + element.toString() + " is" + text);

	}

}
