package com.accuapi.model;

import com.accuapi.constants.AccuApiEndpoints;
import com.accuapi.helpers.GeneralHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class GetCitySearch {
	/**
	 * Get the given City Key (Location Key)
	 */
	GeneralHelper helper = new GeneralHelper();
	String citySearchEndpoint, locationKey;

	public String getCityKey() {
		helper.setCityDetails();
		citySearchEndpoint = helper.getEndPoint("CITY_SEARCH");
		locationKey = (String) getValue("[0].Key");
		System.out.println("locationKey = " + locationKey);
		return locationKey;
	}

	public Object getValue(String val) {
		return RestAssured.given().get(citySearchEndpoint).then().extract().response().body().path(val);
	}
}
