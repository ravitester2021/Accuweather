package com.accuweather.tests;

import com.accuapi.model.GetCitySearch;
import com.accuapi.model.GetCurrentConditions;

public class testApi {

	public static void main(String[] args) {
		GetCitySearch getCitySearch = new GetCitySearch();
		getCitySearch.getCityKey();
		GetCurrentConditions con = new GetCurrentConditions();
		con.getWeatherOfCity();

	}

}
