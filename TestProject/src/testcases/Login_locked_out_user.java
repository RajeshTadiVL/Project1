package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.Products;


public class Login_locked_out_user {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mylaptop\\Documents\\Project1\\TestProject\\Drivers\\chromedriver.exe");		
		System.setProperty("webdriver.chrome.driver", "\\TestProject\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");			
		//Creating object of Login page
		LoginPage login = new LoginPage(driver);
		
		//Creating object of Products
		Products product = new Products(driver);
				
		//Enter username & password
		login.EnterUsername("locked_out_user");
		login.EnterPassword("secret_sauce");
		
		//Click on login button
		login.clicklogin();
		Thread.sleep(3000);
		 String loginError = login.getLoginError();
		
		//Capture the login Error and print on console
		System.out.println("The Login Error is --- " +login.getLoginError());
		 // Assertion to verify that the Login Error is as expected after login
        Assert.assertEquals("The Login Error is not as expected during login", "Epic sadface: Sorry, this user has been locked out.", loginError);

		
		//Click on Logout button
		//product.clickLogout();

               //Close browser instance
               driver.quit();
	}

}
