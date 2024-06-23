package seleniumTestNG;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Contact_form {

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
		
		p.contact_us.click();
		
		Thread.sleep(2500);
		
		if (p.contact_heading.isDisplayed()) {
			System.out.println("get in touch is displayed");
		}
		else
		{
			System.out.println("get in touch is not displayed");
		}
	    
		Thread.sleep(1500);
		
		p.contact_name.sendKeys("varsha");
		Thread.sleep(1500);
		p.contact_email.sendKeys("varshaaiyappa212@gmail.com");
		Thread.sleep(1500);
		p.contact_subject.sendKeys("payment issues");
		Thread.sleep(1500);
		p.contact_msg.sendKeys("sfdhgjugugjhkjkhkjg");
		Thread.sleep(1500);
		
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", upload );
		Thread.sleep(3000);



		//driver.switchTo().activeElement().sendKeys("");
		Thread.sleep(3000);

		// creating object of Robot class
		Robot rb = new Robot();

		// copying File path to Clipboard
		StringSelection str = new StringSelection("C:\\Users\\Varsha\\OneDrive\\Desktop\\Landscape-Color.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		
		p.contact_submit.click();
		
	Thread.sleep(1000);
		
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000); 
        a.accept();      
       
        
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    	if(p.contact_success_alert.isDisplayed()) {
    		System.out.println(p.contact_success_alert.getText());
    	}
    	else {
    		System.out.println("no alerts displayed");
    	}
	}
	
	@AfterMethod
	public void closeWeb()throws Exception {
		
		driver.close();
	}
	
}
