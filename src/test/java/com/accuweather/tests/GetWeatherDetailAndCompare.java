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
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GetWeatherDetailAndCompare extends AccuUIBase {
	AccuUiHomePage uiHomePage;
	AccuUiWeatherPage uiWeatherPage;
	HashMap<String, String> weatherFromUI = new HashMap<String, String>();
	public static ExtentTest logger;
	HashMap<String, String> weatherFromAPI = new HashMap<String, String>();
	String cityKey;
	GetCurrentConditions getConditions;
	GetCitySearch getCitySearch;

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
		reportLog("Weather From UI :"+weatherFromUI);
	}
	
	@Test
	public void getWeatherFromApi() {
		cityKey =  getCitySearch.getCityKey();
		weatherFromAPI = getConditions.getWeatherOfCity(cityKey);
		reportLog("weatherFromAPI :"+weatherFromAPI);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver.close();
	}
	
}
