package seleniumTestNG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scrollup_arrowbutton {
	WebDriver driver;
	
	@BeforeMethod
	public void launchWeb() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	 
		driver.navigate().refresh();
		
	}
	
	
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
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,8400)");
        
        if(p.subscription.isDisplayed()) {
	    	System.out.println("SUBSCRIPTION is present");
	    }
	    else
	    {
	    	System.out.println("SUBSCRIPTION is not present");
	    }
	    
	    Thread.sleep(1500);
	    
	    p.scroll_up_button.click();
	    
	    Thread.sleep(1500);
	    
	   
	     if( p.heading3.isDisplayed()==true) {
	    	 System.out.println("page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen");
	     }
	     else
	     {
	    	 System.out.println("page is not scrolled up!");
	     }
	}
	@AfterMethod
	public void closeWeb()throws Exception {

	driver.close();
	}
}
