package com.accuui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accuapi.helpers.PopUpCloser;
import com.accuui.base.AccuUIBase;

public class AccuUiHomePage extends AccuUIBase{
	
	String uiSearchLocation = prop.getProperty("ui_location");
	PopUpCloser popupCloser = new PopUpCloser();
	@FindBy(xpath = "//input[@class='search-input']")
	WebElement searchTextBox;
	
	@FindBy(xpath = "//div[@class=\"locations-list content-module\"]/a[1]")
	WebElement citySelectionListAftersearch;
	
	
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
		searchTextBox.sendKeys(Keys.ENTER);
		try {
			citySelectionListAftersearch.click();
			reportLog("Search List Displayed and City is selected from List...");
			popupCloser.closePopUp();
		} catch (Exception e) {
			reportLog("Search List Not Displayed...");
			popupCloser.closePopUp();
		}
		reportLog("Search weather for  location : "+uiSearchLocation);
		return new AccuUiWeatherPage();
	}
}
