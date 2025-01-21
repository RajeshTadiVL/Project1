package testcases;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.LoginPage;
import pages.Products;

public class Login_performance_glitch_user {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mylaptop\\Documents\\Project1\\TestProject\\Drivers\\chromedriver.exe");		
		//System.setProperty("webdriver.chrome.driver", "\\TestProject\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");			
		//Creating object of Login page
		LoginPage login = new LoginPage(driver);
		
		//Creating object of Products
		Products product = new Products(driver);
				
		//Enter username & password
		login.EnterUsername("performance_glitch_user");
		login.EnterPassword("secret_sauce");
		
		//Click on login button
		login.clicklogin();
		//Thread.sleep(3000);
	    // Wait for the login error or the products page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
              

        try {
            WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(product.title));
            System.out.println("Products page loaded successfully.");
            String pageTitle = product.gettitle();
    		//Capture the page heading and print on console
    		System.out.println("The page title is --- " +product.gettitle());
    		 // Assertion to verify that the page title is as expected after login
            Assert.assertEquals("The page title is not as expected after login", "Products", pageTitle);

        } catch (Exception e) {
            String loginError = login.getLoginError();
            System.out.println("The Login Error is --- " + loginError);
            Assert.assertEquals("The Login Error is not as expected during login", "Epic sadface: Sorry, this user has been locked out.", loginError);
        }

		
		//Click on Logout button
		//product.clickLogout();

               //Close browser instance
               driver.quit();
	}

}
