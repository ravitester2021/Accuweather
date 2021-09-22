package com.accuui.pages;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.accuapi.helpers.PopUpCloser;
import com.accuui.base.AccuUIBase;

public class AccuUiWeatherPage extends AccuUIBase {

	HashMap<String, String> weatherUIDetails = new HashMap<String, String>();
	PopUpCloser popupCloser = new PopUpCloser();

	@FindBy(xpath = "(//div[contains(@class,'temp')])[3]")
	WebElement weatherInDegree;

	@FindBy(xpath = "//span[@class='text'][contains(.,'More Details')]")
	WebElement moreDetailsLink;

	@FindBy(xpath = "//div[@class='current-weather-details']/div[1]/div[3]/div[2]")
	WebElement windSpeed;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='current-weather-details']/div[1]/div[3]/div"))
	List<WebElement> windDetailElements;

	@FindBy(xpath = "//div[@class=\"current-weather-card card-module content-module non-ad\"]/div[@class='phrase']")
	WebElement weatherText;

	@FindBy(xpath = "//div[@class='current-weather-extra']/div[1]")
	WebElement realFeelText;

	@FindBy(xpath = "//div[@class='current-weather-details']/div[1]/div[5]/div[2]")
	WebElement humidityText;

	@FindBy(xpath = "//div[@class='current-weather-details']/div[2]/div[3]/div[2]")
	WebElement cloudCoverText;

	@FindBy(xpath = "(//div[contains(@class,\"temp\")])[3]")
	WebElement temperatureText;

	public AccuUiWeatherPage() {
		PageFactory.initElements(driver, this);
		reportLog("Initialised AccuUiWeatherPage Elements...");
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public HashMap<String, String> getCurrentWeatherInDetail() {
		addWindDetails();
		return weatherUIDetails;
	}

	public void clickOnMoreDetailsLink() {
		try {
			moreDetailsLink.click();
//			popupCloser.closePopUpUpdated();
			reportLog("More Details Link Displayed now...");
			reportLog("Clicked on More Details now...");
			reportLog("No popup Displayed...");
		} catch (Exception e) {
			reportLog("Could not find More Details... May be Pop up Displayed...");
//			String url = driver.getCurrentUrl();
			popupCloser.closePopUpUpdated();
			moreDetailsLink.click();
//			driver.get(url);
//			popupCloser.closePopUpUpdated();
//			moreDetailsLink.click();
			reportLog("After popup close.. More Details Link Clicked now...");
		}
	}

	public void addWindDetails() {
		clickOnMoreDetailsLink();
		weatherUIDetails.put("CloudCover", cloudCoverText.getText().replaceAll("[^\\d.]", " "));
		reportLog("Cloud Cover collected as " + cloudCoverText.getText());
		weatherUIDetails.put("Humidity", humidityText.getText().replaceAll("[^\\d.]", " "));
		reportLog("Humidity Info collected as " + humidityText.getText());
		weatherUIDetails.put("weather", weatherText.getText());
		reportLog("Weather Info collected as " + weatherText.getText());
		weatherUIDetails.put("RealFeel", realFeelText.getText().replaceAll("[^\\d.]", " "));
		reportLog("RealFeel Info collected as " + realFeelText.getText());
		weatherUIDetails.put("Temperature", temperatureText.getText().replaceAll("[^\\d.]", " "));
		reportLog("Temperature Info collected as " + temperatureText.getText());
	}
}
