package seleniumTestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjModel {


		@FindBy(linkText = "Signup / Login")WebElement signup;
	    @FindBy(xpath = "//div[@class='signup-form' ]/h2")WebElement signup_heading;
	    @FindBy(xpath  = "//input[@data-qa='signup-name']")WebElement signup_name;
        @FindBy(xpath  = "//input[@data-qa='signup-email']")WebElement signup_email;
        @FindBy(xpath = "//button[@data-qa='signup-button']")WebElement signup_button;
        @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")WebElement signup_heading2;
        
        
        @FindBy(id = "uniform-id_gender2")WebElement gender_female;
        @FindBy(id = "name")WebElement signup_form_name;
        @FindBy(id = "password")WebElement signup_form_password;
        @FindBy(id = "days")WebElement day;
        @FindBy(id = "months")WebElement month;
        @FindBy(id = "years")WebElement year;
        @FindBy(id = "newsletter")WebElement newsletter;
        @FindBy(id = "optin")WebElement offers;
        
        //address information
        @FindBy(id = "first_name")WebElement address_firstname;
        @FindBy(id = "last_name")WebElement address_last_name;
        @FindBy(id = "company")WebElement company_name;
        @FindBy(id = "address1")WebElement address;
        @FindBy(id = "address2")WebElement address1;
        @FindBy(id = "country")WebElement country;
        @FindBy(id = "state")WebElement state;
        @FindBy(id = "city")WebElement city;
        @FindBy(id = "zipcode")WebElement zipcode;
        @FindBy(id = "mobile_number")WebElement mobile_number;
        @FindBy(xpath = "//*[@id='form']/div/div/div/div[1]/form/button")WebElement create_acc;

//account created
        
        @FindBy(xpath = "//h2[@data-qa='account-created']")WebElement acc_created_heading;
        @FindBy(xpath = "//a[@data-qa='continue-button']")WebElement acc_created_continue;
        @FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")WebElement delete_acc; 
        @FindBy(xpath = "//h2[@data-qa='account-deleted']")WebElement acc_deleted_heading;

//login 
        @FindBy(xpath = "//div[@class='login-form' ]/h2")WebElement login_heading;
        @FindBy(xpath  = "//input[@data-qa='login-email']")WebElement login_email;
        @FindBy(xpath  = "//input[@data-qa='login-password']")WebElement login_password;
        @FindBy(xpath = "//button[@data-qa='login-button']")WebElement login_button;
        
        @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div[1]/form/p")WebElement login_error;
        @FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")WebElement logout;
        @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/p")WebElement signup_error ;
      
 //contact       
        @FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")WebElement contact_us;
        @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")WebElement contact_heading;
        @FindBy(xpath="//input[@name='name'][@data-qa='name']")WebElement contact_name;
        @FindBy(xpath="//input[@name='email'][@data-qa='email']")WebElement contact_email;
        @FindBy(xpath="//input[@name='subject'][@data-qa='subject']")WebElement contact_subject;
        @FindBy(id = "message")WebElement contact_msg;
        @FindBy(xpath="//input[@data-qa='submit-button'][@name='submit']")WebElement contact_submit;
        @FindBy(xpath="//*[@id='contact-page']/div[2]/div[1]/div/div[2]")WebElement contact_success_alert;

        //testcases
        
        @FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")WebElement test_cases;

        //products
        
        @FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")WebElement products;
        @FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")WebElement cart;
        @FindBy(xpath = "//section[2]/div/div/div[2]/div/h2")WebElement product_heading;
        @FindBy(xpath="/html/body/section[2]/div/div/div[2]/div")WebElement featured_products;
        @FindBy(css= "a[href='/product_details/1']")WebElement view_product;
        @FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div")WebElement product_details;
        
        @FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")WebElement product_name;
        
        @FindBy(css= "input[id='search_product']")WebElement search_product;
        @FindBy(css= "button[id='submit_search']")WebElement submit_search;
        @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")WebElement searched_products;
        @FindBy(xpath = "//div[@class='single-products']")WebElement single_products ;


        //subscription
        
        @FindBy(xpath ="//*[@id='footer']/div[1]/div/div/div[2]/div/h2")WebElement subscription;
        @FindBy(css= "input[id='susbscribe_email']")WebElement subscription_input;
        @FindBy(css= "button[id='subscribe']")WebElement subscription_button;
        @FindBy(css="div[id='success-subscribe']")WebElement subscription_success_alert;

        
        @FindBy(xpath ="//a[@data-product-id=\"1\"]")WebElement Add_cart;
        @FindBy(xpath ="//*[@id=\"cartModal\"]/div/div/div[3]/button")WebElement continue_shopping;
        @FindBy(xpath ="//a[@data-product-id=\"2\"]")WebElement Add_cart2;
        @FindBy(xpath= "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")WebElement view_cart;
        @FindBy(xpath ="//a[@href='/product_details/5']")WebElement view_product2;
        @FindBy(css= "input[id='quantity']")WebElement product_quantity;
        @FindBy(xpath ="//section/div/div/div[2]/div[2]/div[2]/div/span/button")WebElement add_to_cart;
        @FindBy(xpath ="//*[@id='do_action']/div[1]/div/div/a")WebElement checkout_button;
        @FindBy(xpath ="//*[@id=\"ordermsg\"]/textarea")WebElement add_comments;
        @FindBy(xpath ="//*[@id='cart_items']/div/div[7]/a")WebElement place_order;

       //payment form
        @FindBy(css ="input[data-qa='name-on-card']")WebElement payment_name;
        @FindBy(css ="input[name = 'card_number']")WebElement payment_card_number;
        @FindBy(xpath ="//*[@id='checkoutModal']/div/div/div[2]/p[2]/a")WebElement checkout_signin_link;
        @FindBy(xpath ="//*[@id='payment-form']/div[3]/div[1]/input")WebElement payment_cvv;
        @FindBy(xpath =" //*[@id='payment-form']/div[3]/div[2]/input")WebElement payment_month;
        @FindBy(css ="input[name = 'expiry_year']")WebElement payment_year;
        @FindBy(css ="button[id ='submit']")WebElement payment_submit;
       @FindBy(xpath ="//*[@id=\"form\"]/div/div/div/p")WebElement payment_order_status;
       @FindBy(xpath ="//*[@id='product-1']/td[6]/a")WebElement cart_delete;
       @FindBy(xpath ="//a[@href='#Women']")WebElement women;
       @FindBy(xpath ="//a[@href='/category_products/1']")WebElement women_dress;
       @FindBy(xpath ="//section/div/div[2]/div[2]/div/h2")WebElement women_product_heading;
       @FindBy(xpath ="//a[@href='#Men']")WebElement men;
       @FindBy(xpath ="//a[@href='/category_products/3']")WebElement Tshirts;
       @FindBy(xpath ="//a[@href=\"/brand_products/H&M\"]")WebElement HM;
       @FindBy(xpath ="//a[@href='/brand_products/Mast & Harbour']")WebElement MastnHarbour;


       @FindBy(css ="input[id ='name']")WebElement review_name;
       @FindBy(css ="input[id ='email']")WebElement review_email;
       @FindBy(css ="textarea[id ='review']")WebElement review;
       @FindBy(css ="button[id ='button-review']")WebElement submit_review;
       @FindBy(xpath ="//div[@id='review-section']/div/div/span")WebElement review_success;

       //recommended products
       
       @FindBy(xpath ="//*[@id='recommended-item-carousel']/div/div[1]/div[1]/div/div/div/a")WebElement recommended_add_to_cart;
       @FindBy(xpath ="//*[@id=\"form\"]/div/div/div/a")WebElement download_invoice;
       @FindBy(css ="a[id ='scrollUp']")WebElement scroll_up_button;
       @FindBy(xpath ="//*[@id='slider-carousel']/div/div[2]/div[1]/h2")WebElement heading3;
       
       @FindBy(xpath ="//a[@data-product-id='2']")WebElement search_element1;
      
       @FindBy(xpath ="//a[@data-product-id='11']")WebElement search_element2;
}