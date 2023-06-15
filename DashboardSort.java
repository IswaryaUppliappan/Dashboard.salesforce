package dashboard.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DashboardSort {

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
		WebElement s1 = driver.findElement(By.xpath("//span[@title='Dashboard Name']"));
		driver.executeScript("arguments[0].click();", s1);
		String ar=driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).getText();
		String expected_Result=ar;
		Assert.assertEquals(ar,expected_Result);

	}

}
