package com.accuui.pages;

import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accuui.base.AccuUIBase;

public class AccuUiWeatherPage extends AccuUIBase {
	
	HashMap<String, String> weatherUIDetails = new HashMap<String, String>();
	
	@FindBy(xpath = "(//div[contains(@class,'temp')])[3]")
	WebElement weatherInDegree;

	public AccuUiWeatherPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public HashMap<String, String> getCurrentWeatherInDetail() {
		weatherUIDetails.put("weatherInDegree", weatherInDegree.getText());
		return weatherUIDetails;
	}
}
