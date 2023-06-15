package dashboard.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DashboardSubscribe {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		WebElement drop = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", drop);
		WebElement a = driver.findElement(By.xpath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']"));
		a.click();
		a.sendKeys("Salesforce automation by Iswarya");
		 JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,3000)");
			Thread.sleep(2000);
			WebElement b = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small'])[1]"));
			driver.executeScript("arguments[0].scrollIntoView(true)", b);  
			driver.executeScript("arguments[0].click();", b); 
		WebElement d = driver.findElement(By.xpath("//span[text()='Subscribe']"));
		driver.executeScript("arguments[0].click();", d); 
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//span[text()='Daily']"));
		driver.executeScript("arguments[0].click();", e); 
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="You started a dashboard subscription.";
		Assert.assertEquals(actual_Result,expected_Result);
		

	}

}
