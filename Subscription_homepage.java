package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Subscription_homepage {

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
	

	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,4000)");
	 
	    if(p.subscription.isDisplayed()) {
	    	System.out.println("SUBSCRIPTION is present");
	    }
	    else
	    {
	    	System.out.println("SUBSCRIPTION is not present");
	    }
	    
	    Thread.sleep(1500);
	    
	    p.subscription_input.sendKeys("abcdef@gmail.com");
	    
	    Thread.sleep(2500);
	    
	    p.subscription_button.click();
	    
	    if(p.subscription_success_alert.isDisplayed()) {
    		System.out.println(p.subscription_success_alert.getText());
    	}
    	else {
    		System.out.println("no alerts displayed");
    	}
	}
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
	
	
	    
	}

