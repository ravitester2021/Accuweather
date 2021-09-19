package com.accuweather.tests;

import com.accuapi.model.GetCitySearch;
import com.accuapi.model.GetCurrentConditions;

public class testApi {

	public static void main(String[] args) {
		GetCitySearch getCitySearch = new GetCitySearch();
		String cityKey =  getCitySearch.getCityKey();
		GetCurrentConditions con = new GetCurrentConditions();
		System.out.println(con.getWeatherOfCity(cityKey));

	}

}
