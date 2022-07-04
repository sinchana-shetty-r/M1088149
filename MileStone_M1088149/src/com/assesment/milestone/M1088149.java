package com.assesment.milestone;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class M1088149 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Web Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.moneycontrol.com/");
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		Actions a = new Actions(driver);

		WebElement move = driver.findElement(By.xpath("//li[@cid=\"8\"]"));

		a.moveToElement(move);
		
		WebElement moveSub = driver.findElement(By.xpath("//a[contains(text(),'Income Tax Calculator')]"));
		
		a.moveToElement(moveSub).click().build().perform();
		
		driver.findElement(By.xpath("//input[@value=\"without\"]")).click();
		
		driver.findElement(By.xpath("//input[@value=\"with\"]")).click();
		
		driver.findElement(By.id("age")).sendKeys("21");
		
		driver.findElement(By.xpath("//select[@class='custselect']")).click();
		
		driver.findElement(By.xpath("//option[contains(text(),'Stay in Non Metro city')]")).click();
		
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		
		driver.findElement(By.id("annual_salary")).sendKeys("15000");
		
		driver.findElement(By.id("other_income")).sendKeys("15000");
		
		driver.findElement(By.id("tax_saving_investment")).sendKeys("2000");
		
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		
		String tax = driver.findElement(By.id("display_tax")).getText();
		
		System.out.println("The taxed amount is " + tax);
		
		WebElement moveMutual = driver.findElement(By.xpath("//li[@cid='2']"));

		a.moveToElement(moveMutual);
		
		WebElement moveSubTwo = driver.findElement(By.xpath("//a[@title=\"Top Ranked Funds\"]"));
		
		a.moveToElement(moveSubTwo).click().build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),\"IDFC Tax Advantage (ELSS) Fund - Direct Plan - Growth\")]")).click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		String funds = driver.findElement(By.xpath("(//span[@class='amt'])[2]")).getText();
		
		System.out.println("The funds are " + funds);
		
		
	}
}
