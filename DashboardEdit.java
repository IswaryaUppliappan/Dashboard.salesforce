package dashboard.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardEdit {

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
		WebElement d = driver.findElement(By.xpath("//span[text()='Edit']"));
		driver.executeScript("arguments[0].click();", d); 
		Thread.sleep(2000);
		WebElement y = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(y);
		WebElement z = driver.findElement(By.xpath("//div[@class='toolbar']"));
		driver.executeScript("arguments[0].click();", z);
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();		
		WebElement g = driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", g);  
		driver.executeScript("arguments[0].click();", g); 
		g.clear();
		g.sendKeys("Salesforce");
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		WebElement h = driver.findElement(By.xpath("//div[@class='toolbarActions']"));
		driver.executeScript("arguments[0].click();", h); 
		WebElement i = driver.findElement(By.xpath("//button[text()='Done']"));
		driver.executeScript("arguments[0].click();", i);
		WebElement j = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click();", j);
		String actual_Result=driver.findElement(By.xpath("//p[text()='Salesforce']")).getText();
		String expected_Result="Salesforce";
		Assert.assertEquals(actual_Result,expected_Result);
	
	}}