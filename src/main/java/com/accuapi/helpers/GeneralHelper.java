package com.accuapi.helpers;

import com.accuapi.constants.AccuApiEndpoints;
import com.accuui.base.AccuUIBase;

public class GeneralHelper extends AccuUIBase {
	/**
	 * General Helper to prepare City details and prepare endoints
	 */

	AccuApiEndpoints apiEndPointConstants = new AccuApiEndpoints();
	private String apiKey;
	private String cityName;
	private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getApiKey() {
		return apiKey;
	}

	private void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getCityName() {
		return cityName;
	}

	private void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCityDetails() {
		setApiKey(prop.getProperty("api_key"));
		setCityName(prop.getProperty("ui_location"));
	}

	public String getEndPoint(String requestedApiName,String cityKey) {
		reportLog("Preparing endpoint...");
		String endPoint = "";
		if (requestedApiName.equalsIgnoreCase("CURRENT_CONDITIONS")) {
			endPoint = apiEndPointConstants.WEATHER_API_BASE_URL
					+ apiEndPointConstants.CURRENT_CONDITIONS.replace("{locationKey}", cityKey) + "?apikey="
					+ getApiKey() + "&details=" + getDetails();
		} else if (requestedApiName.equalsIgnoreCase("CITY_SEARCH")) {
			setCityDetails();
			endPoint = apiEndPointConstants.WEATHER_API_BASE_URL + apiEndPointConstants.CITY_SEARCH + "?apikey="
					+ getApiKey() + "&q=" + getCityName();
		} else {
			endPoint = "No End Point available";
		}
		reportLog("Collected endpoint :" + endPoint);
		return endPoint;
	}
}
