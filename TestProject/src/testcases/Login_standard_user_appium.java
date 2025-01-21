package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import pages.LoginPage;
import pages.Products;

public class Login_standard_user_appium {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		  // Set up Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");  // Use actual device name for real device
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");  // Use this for web testing on mobile browser
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

        // Instantiate Appium Driver
        AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        // Navigate to the URL
        driver.get("https://www.saucedemo.com/");

        // Creating object of Login page
        LoginPage login = new LoginPage(driver);

        // Creating object of Products
        Products product = new Products(driver);

        // Enter username & password
        login.EnterUsername("standard_user");
        login.EnterPassword("secret_sauce");

        // Click on login button
        login.clicklogin();
        Thread.sleep(3000);
        String pageTitle = product.gettitle();

        // Capture the page heading and print on console
        System.out.println("The page title is --- " + product.gettitle());

        // Assertion to verify that the page title is as expected after login
        Assert.assertEquals("The page title is not as expected after login", "Products", pageTitle);

        // Close driver instance
        driver.quit();
	}

}
