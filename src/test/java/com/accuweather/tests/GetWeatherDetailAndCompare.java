package com.accuweather.tests;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accuapi.model.GetCitySearch;
import com.accuapi.model.GetCurrentConditions;
import com.accuui.base.AccuUIBase;
import com.accuui.pages.AccuUiHomePage;
import com.accuui.pages.AccuUiWeatherPage;

public class GetWeatherDetailAndCompare extends AccuUIBase {
	AccuUiHomePage uiHomePage;
	AccuUiWeatherPage uiWeatherPage;
	GetCurrentConditions getConditions;
	GetCitySearch getCitySearch;
	HashMap<String, String> weatherFromUI = new HashMap<String, String>();
	HashMap<String, String> weatherFromAPI = new HashMap<String, String>();
	String cityKey;

	public GetWeatherDetailAndCompare() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		reportLog("======	Test Case Execution Started	======");
		initialization();
		uiHomePage = new AccuUiHomePage();
		uiWeatherPage = new AccuUiWeatherPage();
		getConditions = new GetCurrentConditions();
		getCitySearch = new GetCitySearch();
	}

	@Test
	public void getWeatherfromUI() {
		uiHomePage.searchByLocation();
		weatherFromUI = uiWeatherPage.getCurrentWeatherInDetail();
		reportLog("Weather From UI :" + weatherFromUI);
		cityKey = getCitySearch.getCityKey();
		weatherFromAPI = getConditions.getWeatherOfCity(cityKey);
		reportLog("weatherFromAPI :" + weatherFromAPI);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		reportLog("======	Test Case Execution Completed	======");
	}

}
