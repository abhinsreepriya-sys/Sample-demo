package com.org.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TricentisLoginPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Scenario1
		// Navigate to the Site
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		// Click on the Login Button
		WebElement LoginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
		LoginBtn.click();
		Thread.sleep(2000);

		// Enter the username and password
		WebElement EmailTB = driver.findElement(By.id("Email"));
		EmailTB.sendKeys("abhinsreepriya@gmail.com");
		Thread.sleep(2000);

		WebElement PwdTB = driver.findElement(By.id("Password"));
		PwdTB.sendKeys("test123!");
		Thread.sleep(2000);

		// Click on login button
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		// Scenario1 completed

		// Scenario2
		// navigate to apparel and shoes
		WebElement AppandShoeBtn = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a"));
		AppandShoeBtn.click();
		Thread.sleep(4000);
		// driver.findElement(By.xpath("//a[@href='/blue-jeans']/img")).click();
		driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/a/img"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.id("addtocart_36_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_36_EnteredQuantity")).sendKeys("5");
		WebElement AddToCart = driver.findElement(By.id("add-to-cart-button-36"));
		AddToCart.click();
		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		WebElement ShCtLink = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		actions.moveToElement(ShCtLink).perform();
		Thread.sleep(7000);
		WebElement GoToCart = driver.findElement(By.xpath("//input[@class='button-1 cart-button']"));
		GoToCart.click();
		Thread.sleep(2000);
		// scenario2 completed

		// Scenario3
		Select s=new Select(driver.findElement(By.id("CountryId")));
		s.selectByVisibleText("India");
		Thread.sleep(2000);
		driver.findElement(By.id("ZipPostalCode")).sendKeys("670620");
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/ul/li[4]/a")).click();
		if(driver.getPageSource().contains("Put your conditions of use information here"))
		{
			System.out.println("Text is displayed");
		}
		else {
			System.out.println("Text not present");
		}
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(4000);
		// driver.close();

	}

}
