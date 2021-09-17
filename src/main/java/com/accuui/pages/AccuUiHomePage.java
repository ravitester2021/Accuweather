package com.accuui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accuui.base.AccuUIBase;

public class AccuUiHomePage extends AccuUIBase{

	@FindBy(xpath = "//input[@class='search-input']")
	WebElement searchTextBox;

	public AccuUiHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public AccuUiWeatherPage searchByLocation(){
		searchTextBox.click();
		searchTextBox.clear();
		searchTextBox.sendKeys(prop.getProperty("ui_location"));
		searchTextBox.sendKeys(Keys.ENTER);
		return new AccuUiWeatherPage();
	}
}
