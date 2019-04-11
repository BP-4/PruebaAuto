package com.bp4.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageLogin;

public class GoogleTest {
	
	private WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.drive", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://test.comercios2.firstdata.com.ar/comercios/");
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
			
	}
	@Test
	public void LoginExitoso() {
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("anticipacion_amigo_perf@gmail.com", "comercio007*");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"ultimos-movimientos\"]/div/div[2]/div/div/h1")).getText().contains("Últimos movimientos"));
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
	}

	@Test
	public void redireccionPreguntas(){
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("anticipacion_amigo_perf@gmail.com", "comercio007*");
		driver.findElement(By.className("modal_custom_x")).click();
		driver.findElement(By.className("banner_merchant_preguntas")).click();
		Assert.assertEquals("https://test.comercios2.firstdata.com.ar/comercios/download/PREGUNTAS_FRECUENTES_CLIENTE_MP.pdf", "https://test.comercios2.firstdata.com.ar/comercios/download/PREGUNTAS_FRECUENTES_CLIENTE_MP.pdf" );
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);

	}

	@Test
	public void  redireccionPosnet(){
		PageLogin pagelogin = new PageLogin(driver);
		pagelogin.login("anticipacion_amigo_perf@gmail.com", "comercio007*");
		driver.findElement(By.className("modal_custom_x")).click();
		driver.findElement(By.className("banner-posnet")).click();
		Assert.assertEquals("https://test.comercios2.firstdata.com.ar/comercios/portal-autogestion#!%2Fanp-posnet-wizzard", "https://test.comercios2.firstdata.com.ar/comercios/portal-autogestion#!%2Fanp-posnet-wizzard");

	}

     @AfterMethod
	 public void tearDown() {
	driver.close();
  }
}
