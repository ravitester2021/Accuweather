package com.accuapi.model;

import java.util.HashMap;

import com.accuapi.constants.AccuApiEndpoints;
import com.accuapi.helpers.GeneralHelper;
import com.accuui.base.AccuUIBase;
import io.restassured.RestAssured;

public class GetCurrentConditions extends AccuUIBase{
	/**
	 * Get the Current Weather of the given City
	 */
	GeneralHelper helper = new GeneralHelper();
	AccuApiEndpoints apiEndPoints = new AccuApiEndpoints();
	GetCitySearch getCitySearch = new GetCitySearch();
	String cityKey = getCitySearch.getCityKey();
	HashMap<String, String> weatherFromApi = new HashMap<String, String>();
	String currentConditionsEndpoint;

	public HashMap<String, String> getWeatherOfCity(String cityKey) {
		helper.setCityDetails();
		helper.setDetails("true");
		currentConditionsEndpoint = helper.getEndPoint("CURRENT_CONDITIONS",cityKey);
		reportLog("currentConditionsEndpoint ==="+currentConditionsEndpoint);
		
		String weatherText = (String) getValue("[0].WeatherText");
		reportLog("WeatherText = " + weatherText);
		weatherFromApi.put("weather", weatherText);
	
		Float realFeelValue = (Float)getValue("[0].Temperature.Metric.Value");
		reportLog("temperatureValue = " + realFeelValue);
		weatherFromApi.put("RealFeel", Float.toString(realFeelValue));
		
		int relativeHumidityValue = (Integer) getValue("[0].RelativeHumidity");
		reportLog("relativeHumidityValue = " + relativeHumidityValue);
		weatherFromApi.put("Humidity", Integer.toString(relativeHumidityValue));
		
		int cloudCoverValue = (Integer) getValue("[0].CloudCover");
		reportLog("cloudCoverValue = " + cloudCoverValue);
		weatherFromApi.put("CloudCover", Integer.toString(cloudCoverValue));
		
		Float temperatureValue = (Float) getValue("[0].Temperature.Metric.Value");
		reportLog("temperatureValue = " + temperatureValue);
		weatherFromApi.put("Temperature", Float.toString(temperatureValue));
		
		return weatherFromApi;
	}
	
	public Object getValue(String val){
		return RestAssured.given().get(currentConditionsEndpoint).then().extract().response().body().path(val);
	}
}
