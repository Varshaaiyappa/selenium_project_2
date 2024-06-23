package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User_registration_invalid {

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

		if(p.signup_heading.isDisplayed()) {
			System.out.println("'New User Signup!' is visible");
		}
					
		else
		{
			System.out.println("'New User Signup!' is not visible");
			}
		Thread.sleep(2500);
		p.signup_name.sendKeys("M A varsha");
		Thread.sleep(2500);
		p.signup_email.sendKeys("demo12@gmail.com");
		Thread.sleep(2500);
		p.signup_button.click();
	    if(	p.signup_error.isDisplayed()){
       
	    	System.out.println(p.signup_error.getText());
	}
	    
	    }

	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}

}
