package seleniumTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search_Product {
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
	
		p.products.click();

		Thread.sleep(2500);
		
		System.out.println(driver.getTitle());

		if(driver.getTitle().contains("All Products")){
			System.out.println("user is navigated to ALL PRODUCTS page successfully");
			}
		else {
			System.out.println("user is not navigated to ALL PRODUCTS page successfully");
		}

		Thread.sleep(2500);
		
		p.search_product.sendKeys("shirt");
		Thread.sleep(1000);
		p.submit_search.click();
		Thread.sleep(2500);
		if(p.searched_products.isDisplayed()) {
			System.out.println("SEARCHED PRODUCTS is visible");
		}
		else
		{
			System.out.println("SEARCHED PRODUCTS is not visible");
		}
		
		List<WebElement> product_names = p.single_products.findElements(By.xpath("//div[@class='single-products']//p"));
		for(int i=0;i<product_names.size();i++) {
			
			System.out.println(product_names.get(i).getText());
		}

	}
	
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
}
