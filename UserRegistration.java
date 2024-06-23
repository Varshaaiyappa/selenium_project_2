package seleniumTestNG;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



	public class UserRegistration {
		
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
			p.signup.click();
			
			
			if(p.signup_heading.isDisplayed()) {
				System.out.println("'New User Signup!' is visible");
			}
						
			else
			{
				System.out.println("'New User Signup!' is not visible");
				}
			Thread.sleep(2500);
			p.signup_name.sendKeys("user2102");
			Thread.sleep(2500);
			p.signup_email.sendKeys("vaarshaaa212@gmail.com");
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
			
			Thread.sleep(2000);
			
			p.delete_acc.click();
			
			Thread.sleep(2000);
			
			if(p.acc_deleted_heading.isDisplayed())
			{
				System.out.println("account deleted is visible");
			}
			
			
			p.acc_created_continue.click();
			
		}
		
		
	
		@AfterMethod
		public void closeWeb()throws Exception {
			
			driver.close();
		}
		}
