package com.qa.Testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Homepage;
import com.pages.ProductInfoPage;

public class AddToCartTest {
	public WebDriver driver;
	public Homepage homepage;
	public ProductInfoPage productinfopage;
	
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		homepage = new Homepage(driver);
		
	}
	@Test
	public void AddToCart() {
	productinfopage = homepage.clickOnproduct();
	productinfopage.addToCartButton();
	Assert.assertTrue(productinfopage.productAddedSuccess());
	
	driver.quit();
		
	}

}
