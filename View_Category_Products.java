package seleniumTestNG;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class View_Category_Products {

	
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
		

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds('5'));

		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,400)");
		  
	    List<WebElement> categories = driver.findElements(By.className("panel-title"));
		for(int i=0;i<categories.size();i++) {
			
			System.out.println(categories.get(i).getText());
		}
		
		p.women.click();
		
		Thread.sleep(2500);
		
		driver.navigate().refresh();
		
        p.women.click();
		
		Thread.sleep(2500);
		
		p.women_dress.click();
		

		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		if(p.women_product_heading.isDisplayed()==true) {
			
			System.out.println(p.women_product_heading.getText());
		}
		
		Thread.sleep(2500);
		
		p.men.click();
		

		driver.navigate().refresh();
		
		p.men.click();
		
       Thread.sleep(2500);
		
		p.Tshirts.click();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
			if(p.women_product_heading.isDisplayed()==true) {
				
				
				System.out.println(p.women_product_heading.getText());
			}
			
			if(p.women_product_heading.getText().contains("MEN - TSHIRTS PRODUCTS")) {
				
				System.out.println("user successfuly navigated to men category page");
			}
			
		 
		}
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
}
