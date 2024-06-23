package seleniumTestNG;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class View_Cart_Brand_Products {

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
		

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds('5'));
		
		
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,500)");	
		
		 List<WebElement> brands = driver.findElements(By.xpath("//div[@class='brands-name']/ul/li"));
			for(int i=0;i<brands.size();i++) {
				
				System.out.println(brands.get(i).getText());
			}
			
			p.HM.click();
			
			Thread.sleep(2500);
			
			driver.navigate().refresh();
			
			p.HM.click();
						
			Thread.sleep(2500);
			
				if(p.women_product_heading.isDisplayed()==true) {
					
					
					System.out.println(" user is navigated to H&M brand page");
					System.out.println(p.women_product_heading.getText());
				}
				
				Thread.sleep(2500);
				
				System.out.println("the productsare displayed");
				
				List<WebElement> product_names = p.single_products.findElements(By.xpath("//div[@class='single-products']//p"));
				for(int i=0;i<product_names.size();i++) {
					
					
					System.out.println(product_names.get(i).getText());
				}

				Thread.sleep(2500);
			
				
				p.MastnHarbour.click();
				

				driver.navigate().refresh();
				
				p.MastnHarbour.click();
				
		       Thread.sleep(2500);
				

				if(p.women_product_heading.isDisplayed()==true) {
					
					
					System.out.println(" user is navigated to Mast&Harbour  brand page");
					System.out.println(p.women_product_heading.getText());
				}
				
				Thread.sleep(2500);
				
				System.out.println("the products are displayed");
				
				List<WebElement> product_names2 = p.single_products.findElements(By.xpath("//div[@class='single-products']//p"));
				for(int i=0;i<product_names2.size();i++) {
					
					
					System.out.println(product_names2.get(i).getText());
				}

	}
	
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
}
