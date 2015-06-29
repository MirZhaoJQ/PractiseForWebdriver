package mavenhw;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FailTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://testerhome.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSignIn() throws Exception {
		driver.navigate().to(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href, '/account/sign_in')]"))
				.click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		driver.findElement(By.id("user_login")).sendKeys(
				"miraclezhao1988@163.com");
		Thread.sleep(2000);
		driver.findElement(By.id("user_password")).sendKeys("zhaojiaqi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(2000);
		assertEquals(
				"fail",
				driver.findElement(By.xpath("//a[contains(text(),'mir_zhao')]"))
						.getText());

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
