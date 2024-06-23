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

public class Remove_Products_From_Cart {

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
	 
       
        p.Add_cart.click();
        
        Thread.sleep(1000);
       
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
        
        
        if (p.continue_shopping.isDisplayed()==true) {
   
      p.continue_shopping.click();
        }
        else {
        	System.out.println("continue shopping isnt visible");
        }
        
		 Thread.sleep(1000);
	
	     p.Add_cart2.click();
	     
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		 p.cart.click();

			Thread.sleep(2000);

			if(driver.getCurrentUrl().contains("view_cart")) {
				System.out.println(" cart page is displayed");
			}
			else
			{
				System.out.println(" cart page is not displayed");
			}

			Thread.sleep(2000);
			
			System.out.println("the cart before removing products");
			

	    	 Thread.sleep(1000);
	
	   
	    	 List<WebElement> total_products = driver.findElements(By.tagName("tr"));
	    	 int total_products1 = total_products.size();
	    	 System.out.println("total number of products : " + total_products1);
	    	 

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

					 Thread.sleep(1000);
						
					p.cart_delete.click();
					
					

			    	 Thread.sleep(1000);
			
					
					 List<WebElement> total_products2 = driver.findElements(By.tagName("tr"));
			    	 int total_products_new = total_products2.size();
			    	 System.out.println("total number of products : " + total_products_new);
			    	 
					
			    	 if(total_products1>total_products_new) {
			    		 System.out.println("blue top is removed from the cart");
			    	 }

			    	 List<WebElement> product_names2 = driver.findElements(By.xpath("*//tbody//td[@class='cart_description']/h4"));
			 		for(int i=0;i<product_names2.size();i++) {
			 			
			 			System.out.println(product_names2.get(i).getText());
			 		}
}
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
}
