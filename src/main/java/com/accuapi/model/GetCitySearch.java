package com.accuapi.model;

import com.accuapi.helpers.GeneralHelper;
import com.accuui.base.AccuUIBase;
import io.restassured.RestAssured;

public class GetCitySearch extends AccuUIBase{
	/**
	 * Get the given City Key (Location Key)
	 */
	GeneralHelper helper = new GeneralHelper();
	String citySearchEndpoint, locationKey;

	public String getCityKey() {
		citySearchEndpoint = helper.getEndPoint("CITY_SEARCH","");
		locationKey = (String) getValue("[0].Key");
		reportLog("Location Key collected is : "+locationKey);
		return locationKey;
	}

	public Object getValue(String val) {
		return RestAssured.given().get(citySearchEndpoint).then().extract().response().body().path(val);
	}
}
