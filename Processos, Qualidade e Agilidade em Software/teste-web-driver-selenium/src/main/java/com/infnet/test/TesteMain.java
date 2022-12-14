package com.infnet.test;

import java.util.Random;

public class TesteMain {

	public static void main(String[] args) {

		int id = (int) (Math.random()) + 2;
		
		System.out.println(new Random().nextInt(50000));

//		WebDriver driver = new ChromeDriver();
//
//		driver.get("https://selenium.dev");
//
//		driver.findElement(By.cssSelector("a[class='selenium-button selenium-webdriver text-uppercase font-weight-bold']")).click();
//		driver.findElement(By.cssSelector("a[href='/documentation/webdriver/getting_started/']")).click();
//
//		driver.quit();

	}

}
