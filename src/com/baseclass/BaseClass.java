package com.baseclass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {


	public static WebDriver driver;
	//browser launch
	public static void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println("Chrome Driver is Opened");
		}
		else if(browser.equalsIgnoreCase("Edge")){
			driver=new EdgeDriver();
			System.out.println("Edge Driver is opened");

		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();

			System.out.println("FireFox Driver is opened");

		}else {
			System.out.println("Driver is not available,available are chrome,firefox,edge");
		}
		driver.manage().window().maximize();
	}//UrlLaunch
	public static void launchUrl(String url) {
		driver.get(url);
	}
	//SendKeys
	public static void sendInput(WebElement element,String value) {
		element.sendKeys(value);
	}
	//DropDown
	public static void selectByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public static void selectByText(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	public static void selectByIndex(WebElement element,int value) {
		Select select=new Select(element);
		select.selectByIndex(value);
	}
	//screenshot
	public static void screenshot(String name) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\user\\eclipse-workspace\\Selenium_Projects\\ScreenShots\\"+name+".png");
		FileHandler.copy(source, destination);
	}
	//NavigationMethods
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	//getTitle
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("Page tille:"+title);
	}
	//getText
	public static void getText(WebElement element) {
		element.getText();
		System.out.println("Text From Page:"+element.getText());
	}
	//Alert
	public static void simpleAlert() {
		driver.switchTo().alert().accept();
	}
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	public static void promtAlert(String Value) {
		driver.switchTo().alert().sendKeys(Value);	
	}
	public static void AlertText() {
		String text = driver.switchTo().alert().getText();
		System.out.println("Text From Alert:"+text);
	}
	//frame
	public static void FrameByIndex() {
		driver.switchTo().frame(0);
	}
	public static void FrameByNameorId(String value) {
		driver.switchTo().frame(value);
	}
	public static void FrameBywebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	//close
	public static void close() {
		driver.close();	
	}
	//Quit
	public static void quit() {
		driver.quit();
	}        
}
