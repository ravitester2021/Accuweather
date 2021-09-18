package com.accuapi.model;

import java.util.HashMap;

import com.accuapi.constants.AccuApiEndpoints;
import com.accuapi.helpers.GeneralHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCurrentConditions {
	/**
	 * Get the Current Weather of the given City
	 */
	GeneralHelper helper = new GeneralHelper();
	AccuApiEndpoints apiEndPoints = new AccuApiEndpoints();
	GetCitySearch getCitySearch = new GetCitySearch();
	String cityKey = getCitySearch.getCityKey();
	HashMap<String, String> weatherFromApi = new HashMap<String, String>();
	String currentConditionsEndpoint;

	public HashMap<String, String> getWeatherOfCity() {
		helper.setCityDetails();
		helper.setDetails("true");
		currentConditionsEndpoint = helper.getEndPoint("CURRENT_CONDITIONS");
		
		String weatherText = (String) getValue("[0].WeatherText");
		System.out.println("WeatherText = " + weatherText);
	
		Float temperatureValue = (Float)getValue("[0].Temperature.Metric.Value");
		System.out.println("temperatureValue = " + temperatureValue);
		
		int relativeHumidityValue = (Integer) getValue("[0].RelativeHumidity");
		System.out.println("relativeHumidityValue = " + relativeHumidityValue);
		
		int cloudCoverValue = (Integer) getValue("[0].CloudCover");
		System.out.println("cloudCoverValue = " + cloudCoverValue);
		
		return weatherFromApi;
	}
	
	public Object getValue(String val){
		Response respone = RestAssured.given().get(currentConditionsEndpoint).then().extract().response().body().path(val);
		System.out.println("Current Conditions : "+respone.asPrettyString());
		return respone.toString();
	}
}
