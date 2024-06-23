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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verify_address_details_in_checkout_page {

	String address_info;
	String delivery_add;
	String billing_address;
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
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		p.signup.click();
		
		
		if(p.signup_heading.isDisplayed()) {
			System.out.println("'New User Signup!' is visible");
		}
					
		else
		{
			System.out.println("'New User Signup!' is not visible");
			}
		Thread.sleep(2500);
		p.signup_name.sendKeys("user2366518");
		Thread.sleep(2500);
		p.signup_email.sendKeys("user2366518@gmail.com");
		Thread.sleep(2500);
		p.signup_button.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		if(p.signup_heading2.isDisplayed()) {
			System.out.println("'ENTER ACCOUNT INFORMATION' is visible");
		}
					
		else
		{
			System.out.println("'ENTER ACCOUNT INFORMATION' is visible");
			}
		Thread.sleep(2500);
		
		p.gender_female.click();
		Thread.sleep(1000);
		p.signup_form_name.clear();
		Thread.sleep(1000);
		p.signup_form_name.sendKeys("varsha");
		p.signup_form_password.sendKeys("Varsha@102?!");
		Thread.sleep(1000);

		Select obj1 = new Select(p.day); //select by value
		obj1.selectByValue("21");
		Thread.sleep(2000); 
		Select obj2 = new Select(p.month); //select by value
		obj2.selectByValue("2");
		Thread.sleep(2000); 
		Select obj3 = new Select(p.year); //select by value
		obj3.selectByValue("2002");
		Thread.sleep(2000); 
		
		p.newsletter.click();
		Thread.sleep(1000);
		p.offers.click();
		Thread.sleep(1000);
		
		p.address_firstname.sendKeys("varsha");
		p.address_last_name.sendKeys("aiyappa");
		p.company_name.sendKeys("conventrix");
		p.address.sendKeys("no.21 , 7 th main");
		p.address1.sendKeys("begur,banglore");
		Thread.sleep(1000);
		
		Select obj4 = new Select(p.country); //select by value
		obj4.selectByValue("India");
		Thread.sleep(2000); 
		
		p.state.sendKeys("karnataka");
		p.city.sendKeys("bangalore");
		p.zipcode.sendKeys("560062");
		p.mobile_number.sendKeys("7688798353");
		Thread.sleep(2000);
		
		 List<WebElement> address_information = driver.findElements(By.tagName("p"));
	 		for(int i=0;i<address_information.size();i++) {
	 			
	 			 address_info = address_information.get(i).getText(); 
	 			System.out.println(address_information.get(i).getText());
	 		}
	 	
		p.create_acc.click();
		
		
		
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		if(p.acc_created_heading.isDisplayed()) {
			System.out.println("ACCOUNT CREATED! is visible");
		}
		
		p.acc_created_continue.click();
		
		WebElement h=  driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
		if(h.isDisplayed())
		{
			System.out.println("logged in as username is visible");
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
    		 
    		 p.view_cart.click();

    		 Thread.sleep(2000);

    		 p.checkout_button.click();	  

    		 List<WebElement> delivery_address = driver.findElements(By.tagName("li"));
    		 		for(int i=0;i<delivery_address.size();i++) {
    		 			
    		 			delivery_add =  delivery_address.get(i).getText();
    		 			System.out.println(delivery_address.get(i).getText());
    		 		}
    		 		
    		 		List<WebElement> review_order = driver.findElements(By.tagName("td"));
    		 		for(int i=0;i<review_order.size();i++) {
    		 			
    		 			billing_address = review_order.get(i).getText();
    		 			System.out.println(review_order.get(i).getText());
    		 		}
    		 		
    		 		if(delivery_add==billing_address) {
    		 			System.out.println("delivery and billing address is same");
    		 		}
    		 				
    		 		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    				
    				p.delete_acc.click();
    				
    				Thread.sleep(2000);
    				
    				if (p.acc_deleted_heading.isDisplayed()) {
    					System.out.println("ACCOUNT DELETED is visible");
    				}
    				else {
    					System.out.println("ACCOUNT DELETED is not visible");
    				}
    				
    		
	
}
	
	@AfterMethod
	public void closeWeb()throws Exception {

	driver.close();
	}
}
