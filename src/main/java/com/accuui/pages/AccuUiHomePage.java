package com.accuui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accuui.base.AccuUIBase;

public class AccuUiHomePage extends AccuUIBase{
	
	String uiSearchLocation = prop.getProperty("ui_location");
	@FindBy(xpath = "//input[@class='search-input']")
	WebElement searchTextBox;

	public AccuUiHomePage() {
		PageFactory.initElements(driver, this);
		reportLog("Initialised AccuUiHomePage Elements...");
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public AccuUiWeatherPage searchByLocation(){
		searchTextBox.click();
		reportLog("Search Button Clicked...");
		searchTextBox.clear();
		searchTextBox.sendKeys(uiSearchLocation);
		reportLog("Search weather for  location : "+uiSearchLocation);
		searchTextBox.sendKeys(Keys.ENTER);
		return new AccuUiWeatherPage();
	}
}
