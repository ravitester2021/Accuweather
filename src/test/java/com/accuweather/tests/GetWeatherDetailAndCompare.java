package com.accuweather.tests;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accuui.base.AccuUIBase;
import com.accuui.pages.AccuUiHomePage;
import com.accuui.pages.AccuUiWeatherPage;

public class GetWeatherDetailAndCompare extends AccuUIBase {
	AccuUiHomePage uiHomePage;
	AccuUiWeatherPage uiWeatherPage;
	HashMap<String, String> weatherFromUI = new HashMap<String, String>();

	public GetWeatherDetailAndCompare() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		uiHomePage = new AccuUiHomePage();
		uiWeatherPage = new AccuUiWeatherPage();
	}

	@Test()
	public void getWeather() {
		uiHomePage.searchByLocation();
		weatherFromUI = uiWeatherPage.getCurrentWeatherInDetail();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
