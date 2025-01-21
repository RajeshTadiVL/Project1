package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.Products;

public class Login_standard_user {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mylaptop\\Documents\\Project1\\TestProject\\Drivers\\chromedriver.exe");		
		System.setProperty("webdriver.chrome.driver", "\\TestProject\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");			
		//Creating object of Login page
		LoginPage login = new LoginPage(driver);
		
		//Creating object of Products
		Products product = new Products(driver);
				
		//Enter username & password
		login.EnterUsername("standard_user");
		login.EnterPassword("secret_sauce");
		
		//Click on login button
		login.clicklogin();
		 Thread.sleep(3000);
		 String pageTitle = product.gettitle();
		
		//Capture the page heading and print on console
		System.out.println("The page title is --- " +product.gettitle());
		 // Assertion to verify that the page title is as expected after login
        Assert.assertEquals("The page title is not as expected after login", "Products", pageTitle);

		
		//Click on Logout button
		//product.clickLogout();

               //Close browser instance
               driver.quit();
	}

}
