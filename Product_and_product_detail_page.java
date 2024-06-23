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

public class Product_and_product_detail_page {


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

System.out.println(driver.getCurrentUrl());

if(driver.getCurrentUrl().contains("Products")){
	System.out.println("user is navigated to ALL PRODUCTS page successfully");
	}
else {
	System.out.println("user is not navigated to ALL PRODUCTS page successfully");
}

if(p.featured_products.isDisplayed()==true) {
	System.out.println("The products list is visible");
}

driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

p.view_product.click();

Thread.sleep(2500);

if(driver.getCurrentUrl().contains("product_details")) {
	System.out.println("User is landed to product detail page");
}

Thread.sleep(2500);

System.out.println(p.product_name.getText());

List<WebElement> product =  p.product_details.findElements(By.tagName("p"));
for(int i=0;i<product.size();i++) {
	
	System.out.println(product.get(i).getText());
}


}
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
}