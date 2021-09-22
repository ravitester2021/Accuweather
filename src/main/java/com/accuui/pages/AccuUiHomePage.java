package com.accuui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accuapi.helpers.PopUpCloser;
import com.accuui.base.AccuUIBase;

public class AccuUiHomePage extends AccuUIBase {

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

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void clickOnSearchList() {
		try {
			citySelectionListAftersearch.click();
//			popupCloser.closePopUpUpdated();
			reportLog("Search Details Link Displayed now...");
			reportLog("Clicked on Search List now...");
		} catch (Exception e) {
//			try {
				reportLog("Could not find Search List.. May be Pop up Displayed...");
//				String url = driver.getCurrentUrl();
				popupCloser.closePopUpUpdated();
//				driver.get(url);
				citySelectionListAftersearch.click();
				reportLog("After popup close.. Search Details Link Clicked now...");
//			} catch (Exception e2) {
//				reportLog("No popup and No Search Details Link Displayed now... Proceed");
//			}
		}
	}

	public AccuUiWeatherPage searchByLocation() {
		searchTextBox.click();
		reportLog("Search Button Clicked...");
		searchTextBox.clear();
		searchTextBox.sendKeys(uiSearchLocation);
		searchTextBox.sendKeys(Keys.ENTER);
		clickOnSearchList();
		reportLog("Search weather for  location : " + uiSearchLocation);
		return new AccuUiWeatherPage();
	}
}
