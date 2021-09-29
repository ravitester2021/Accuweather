package com.simple.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testUI {
	WebDriver driver;
	
	@Test
	public void testUI() {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options  = new ChromeOptions();
	    //options.addArguments("incognito");
//	    options.addArguments("--disable-popup-blocking");
//	    options.addArguments("--disable-web-security");
//	    options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
//	    DesiredCapabilities capabilities = new DesiredCapabilities();
//	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	    driver = new ChromeDriver(capabilities);
//	    WebDriverManager.chromedriver().capabilities(capabilities);
//		initialization();
//		driver = new ChromeDriver();
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
//		caps.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    FirefoxOptions options = new FirefoxOptions();
	    capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		WebDriverManager.firefoxdriver().capabilities(capabilities);
		driver = new FirefoxDriver();

		//		FirefoxDriver driver = new FirefoxDriver(customProfile);
		
		driver.get("https://www.accuweather.com/");
		driver.findElement(By.xpath("//input[@class='search-input']")).click();
//		reportLog("Search Button Clicked...");
		driver.findElement(By.xpath("//input[@class='search-input']")).clear();
//		String uiSearchLocation = prop.getProperty("ui_location");
		driver.findElement(By.xpath("//input[@class='search-input']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@class='search-input']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='text'][contains(.,'More Details')]")).click();
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//span[@class='text'][contains(.,'More Details')]")).click();
		} catch (Exception e) {

		}
//		int size = driver.findElements(By.tagName("iframe")).size();
//		for(int i=0; i<size; i++){
//			driver.switchTo().frame(i);
//			int total=driver.findElements(By.xpath("//div[@id='dismiss-button']")).size();
//			System.out.println(total);
//		    driver.switchTo().defaultContent();
//		    }
//		driver.switchTo().frame(8);
//		driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]")).click();
//		try {
////			driver.switchTo().fr
//			driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]")).click();
//			System.out.println("Successfully closed the Ad!!!");
//		} catch (Exception e) {
//			System.out.println("No AD is displayed.");
//		}
		
//		Actions action = new Actions(driver);
//		action.contextClick();
//		action.contextClick();
//		String parent = driver.getWindowHandle();
//		try {
//			driver.switchTo().alert().dismiss();
//		} catch (Exception e) {
//			
//			Set<String> hand = driver.getWindowHandles();
//			for (int i = 0; i < hand.size(); i++) {
//				driver.switchTo().activeElement().click();
//				driver.switchTo().parentFrame();
//			}
		}
		
//		HashMap<String, String> weatherUIDetails = new HashMap<String, String>();
//		weatherUIDetails.put("CloudCover", cloudCoverText.getText().replaceAll("[^\\d.]", " "));
//		reportLog("Cloud Cover collected as "+cloudCoverText.getText());
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
//		reportLog("======	Test Case Execution Completed	======");
	}


}
