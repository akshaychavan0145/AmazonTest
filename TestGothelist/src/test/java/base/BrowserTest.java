package base;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	
	
	@Test(priority=0)
	public void setUpBrowser() {

		System.setProperty("webdriver.chrome.driver", "/Volumes/MacDrive/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void login() {
		 driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("akshay@gmail.com");

		driver.findElement(By.xpath("//*[@id=\'continue\'] [@type=\'submit\']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/h1")));

		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("checkout");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

	}
}