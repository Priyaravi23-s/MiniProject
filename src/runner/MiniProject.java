package runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class MiniProject extends BaseClass{
	
	
	    @Test(priority = -5)
		public void browserLunch() {
		
		launchBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		launchUrl("https://www.bigbasket.com");
		}
		@Test(priority = -4)
		public void productSearch() {
		
		WebElement search = driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]"));
		search.sendKeys("almond");
		WebElement almo = driver.findElement(By.xpath("(//span[text()='bb Popular'])[1]"));
		
		Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(almo));
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", almo);
		}
		@Test(priority = -3)
		public void productAdd() {
		
		WebElement add = driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]"));
		Wait<WebDriver> wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(add));
		
		JavascriptExecutor js1 =(JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", add);
		WebElement addcart = driver.findElement(By.xpath("//div[@class='px-1.5 w-9cursor-pointer rounded-2xs py-1.5  bg-rossoCorsa-50 relative']"));
		addcart.click();
		
		WebElement phoneNo = driver.findElement(By.id("multiform"));
		phoneNo.sendKeys("7402026871");
		}
		@Test(priority = -2)
		public void productCheckout() throws InterruptedException {
		
			
		WebElement button = driver.findElement(By.xpath("//button[text()='Continue']"));
		button.click();
		
		Thread.sleep(40000);
		WebElement log = driver.findElement(By.xpath("//button[text()='Verify & Continue']"));
		log.click();
		
		WebElement checkout = driver.findElement(By.xpath("//button[text()='Checkout']"));
		Wait<WebDriver> wait2=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOf(checkout));
		
		JavascriptExecutor js2 =(JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", checkout); 
		
	}
}


