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

public class Search_Products_Verify_Cart_After_Login {

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
		
		p.products.click();
	       

		driver.getTitle();
if(driver.getTitle().contains("Product")){
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

Thread.sleep(1000);

JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,500)");

Thread.sleep(2500);

p.search_element1.click();

Thread.sleep(1000);

//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("window.scrollBy(0,300)");


if (p.continue_shopping.isDisplayed()==true) {

p.continue_shopping.click();
}
else {
	System.out.println("continue shopping isnt visible");
}

 Thread.sleep(1000);

 p.search_element2.click();
 
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

 p.view_cart.click();

 Thread.sleep(2000);

 if(driver.getCurrentUrl().contains("view_cart")) {
 	System.out.println(" cart page is displayed");
 }
 else
 {
 	System.out.println(" cart page is not displayed");
 }

 Thread.sleep(2000);
 
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
	
	Thread.sleep(2500);
	
	 p.cart.click();
	 
	 Thread.sleep(2500);
	 
	 
	  List<WebElement> product_names2 = driver.findElements(By.xpath("*//tbody//td[@class='cart_description']/h4"));
		for(int i=0;i<product_names2.size();i++) {
			
			System.out.println(product_names2.get(i).getText());
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
