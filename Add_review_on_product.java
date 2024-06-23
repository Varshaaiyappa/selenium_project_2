package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Add_review_on_product {

	
WebDriver driver;
	
	@BeforeMethod
	public void launchWeb() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notifications");
	    driver = new ChromeDriver(option);
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
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		p.products.click();
		
		
		driver.navigate().refresh();
		
	
		p.products.click();
		
		Thread.sleep(2500);
		
		driver.getTitle();
		
		if(driver.getTitle().contains("Product")){
			System.out.println("user is navigated to ALL PRODUCTS page successfully");
			}
		else {
			System.out.println("user is not navigated to ALL PRODUCTS page successfully");
		}
	       
	  
p.view_product2.click();

Thread.sleep(1000);


	
p.review_name.sendKeys("varsha");

Thread.sleep(1000);

p.review_email.sendKeys("vaersha212@gmail.com");

Thread.sleep(1000);

p.review.sendKeys("good product");

Thread.sleep(1000);

p.submit_review.click();



if(p.review_success.isDisplayed()==true) {

	System.out.println(p.review_success.getText());
}
else
{
	System.out.println("review not submitted properly");
}
}
	@AfterMethod
	public void closeWeb()throws Exception {

	driver.close();
	}

}