package com.accuapi.constants;

import com.accuui.base.AccuUIBase;

public class AccuApiEndpoints extends AccuUIBase{
/**
 * End point Constants
 */
	public static final String WEATHER_API_BASE_URL = prop.getProperty("api_base_url");
	public static final String CITY_SEARCH = "/locations/v1/cities/search";
	public static final String CURRENT_CONDITIONS = "/currentconditions/v1/{locationKey}";
	
}
