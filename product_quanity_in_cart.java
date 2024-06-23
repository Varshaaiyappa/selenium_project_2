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

public class product_quanity_in_cart {
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
		
		p.products.click();
		
		
		driver.navigate().refresh();
	 
	    
		
	    p.view_product2.click();
	    
	    Thread.sleep(1000);
	    
	    p.product_quantity.clear();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    p.product_quantity.sendKeys("4");
	    
	    Thread.sleep(2000);
	    
	    p.add_to_cart.click();
	    
	    Thread.sleep(2000);
	    
	           
        
        
	    
	    if (p.view_cart.isDisplayed()==true) {
	   

	    	 JavascriptExecutor jse = (JavascriptExecutor)driver;

	    	 jse.executeScript("arguments[0].scrollIntoView()", p.view_cart);
	    	 
	    	 p.view_cart.click();
	    }

	    	 Thread.sleep(1000);
	
	    	 
	    
	    List<WebElement> product_names = driver.findElements(By.xpath("*//tbody//td[@class='cart_description']/h4"));
		for(int i=0;i<product_names.size();i++) {
			
			System.out.println(product_names.get(i).getText());
		}
		 Thread.sleep(1000);
		 List<WebElement> product_price = driver.findElements(By.xpath("*//tbody//td[@class='cart_price']/p"));
			for(int i=0;i<product_price.size();i++) {
				
				System.out.println(product_price.get(i).getText());
			}
			 List<WebElement> product_quantity = driver.findElements(By.tagName("button"));
				for(int i=0;i<product_quantity.size();i++) {
					
					System.out.println(product_quantity.get(i).getText());
				}
				 List<WebElement> product_total = driver.findElements(By.xpath("*//tbody//td[@class='cart_price']/p"));
					for(int i=0;i<product_total.size();i++) {
						
						System.out.println(product_total.get(i).getText());
					}
				
	}

	

@AfterMethod
public void closeWeb()throws Exception {
	
	driver.close();
}
}


