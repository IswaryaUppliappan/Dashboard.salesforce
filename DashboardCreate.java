package dashboard.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardCreate {

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
		WebElement d = driver.findElement(By.xpath("//div[@title='New Dashboard']"));
		driver.executeScript("arguments[0].click();", d);
		WebElement f = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(f);
		WebElement name = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		name.sendKeys("Salesforce Automation by Iswarya");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		WebElement g = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(g);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.switchTo().defaultContent();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Dashboard saved";
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
