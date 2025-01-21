package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public By Username=By.id("user-name");
	public By Password=By.id("password");
	public By Loginbtn=By.id("login-button");
	public By LoginErrorbtn=By.xpath("//*[@data-test='error']");
	public void EnterUsername(String User)
	{
		driver.findElement(Username).sendKeys(User);
	}
	public void EnterPassword(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
	}
	public void clicklogin()
	{
		driver.findElement(Loginbtn).click();
	}
	public String getLoginError() {
		String errordetail = driver.findElement(LoginErrorbtn).getText();
		return errordetail;
	}
	

}
