package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageLogin {
	
	private WebDriver driver;
	private By userField;
	private By passwordField;
	private By loginBotton;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("username");
		passwordField = By.name("password");
		loginBotton = By.xpath("//*[@id=\"formLogin\"]/div[4]/div/button");
	}

	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginBotton).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
	}

}
