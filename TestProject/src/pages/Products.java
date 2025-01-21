package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {

	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public Products(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators for the page title and the logout button
	public By title = By.xpath("//*[@data-test=\"title\"]");
	public By logoutBtn = By.id("logout_sidebar_link");
	
	//Method to capture the page heading
	public String gettitle() {
		String title1 = driver.findElement(title).getText();
		return title1;
	}
	
	//Method to click on Logout button
	public void clickLogout() {
		driver.findElement(logoutBtn).click();
	}

}
