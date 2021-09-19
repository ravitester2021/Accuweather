package com.accuweather.tests;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accuapi.helpers.ComparatorLogic;
import com.accuapi.helpers.CustomException;
import com.accuapi.model.GetCitySearch;
import com.accuapi.model.GetCurrentConditions;
import com.accuui.base.AccuUIBase;
import com.accuui.pages.AccuUiHomePage;
import com.accuui.pages.AccuUiWeatherPage;

public class GetWeatherDetailAndCompare extends AccuUIBase {
	AccuUiHomePage uiHomePage;
	AccuUiWeatherPage uiWeatherPage;
	GetCurrentConditions getConditions;
	ComparatorLogic compareLogic;
	GetCitySearch getCitySearch;
	HashMap<String, String> weatherFromUI = new HashMap<String, String>();
	HashMap<String, String> weatherFromAPI = new HashMap<String, String>();
	String cityKey,humidityVariance;

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
		compareLogic = new ComparatorLogic();
		humidityVariance = prop.getProperty("Humidity_variance");
	}

	@Test
	public void getWeatherfromUI() throws CustomException {
		uiHomePage.searchByLocation();
		weatherFromUI = uiWeatherPage.getCurrentWeatherInDetail();
		reportLog("Weather From UI :" + weatherFromUI);
		cityKey = getCitySearch.getCityKey();
		weatherFromAPI = getConditions.getWeatherOfCity(cityKey);
		reportLog("weatherFromAPI :" + weatherFromAPI);
		compareLogic.CompareVariance("Humidity", weatherFromUI.get("Humidity"), weatherFromAPI.get("Humidity"), humidityVariance);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		reportLog("======	Test Case Execution Completed	======");
	}

}
