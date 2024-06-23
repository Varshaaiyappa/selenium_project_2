package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout {

	WebDriver driver;
	@BeforeMethod
	public void launchWeb() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testcase1() throws Exception {
		
		PageObjModel p = PageFactory.initElements(driver,PageObjModel.class );
	
		if(driver.getTitle().contains("Automation")) {
        System.out.println("the webpage is visible");				
		}
		else
		{
			System.out.println("webpage is not visible");
		}

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		p.signup.click();
		if (p.login_heading.isDisplayed()) {
			System.out.println("Login to your account is visible");
		}
		else {
			System.out.println("Login to your account is not visible");
		}
		
		p.login_email.sendKeys("demo12@gmail.com");
		Thread.sleep(2500);
		
		p.login_password.sendKeys("MAvarsha2102");
		Thread.sleep(2500);
		
		p.login_button.click();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement h=  driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
		if(h.isDisplayed())
		{
			System.out.println("logged in as username is visible");
		}
		Thread.sleep(2000);
		
		p.logout.click();
		
		if(driver.getCurrentUrl().contains("login")) {
	        System.out.println(" user is navigated back to login page");				
			}
			else
			{
				System.out.println(" user is not navigated back to login page");
			}
	
		
		}
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
}
