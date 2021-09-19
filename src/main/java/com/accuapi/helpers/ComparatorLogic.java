package com.accuapi.helpers;

import com.accuui.base.AccuUIBase;

public class ComparatorLogic extends AccuUIBase {

	public boolean CompareVariance(String parameter, String uiWeatherVal, String apiWeatherVal, String variance)
			throws CustomException {

		boolean result = false;

		if (parameter.equalsIgnoreCase("Humidity")) {
			result = compareData(covertToInteger(uiWeatherVal.trim()), covertToInteger(apiWeatherVal.trim()), variance);
			reportLog("Humidity Comparison result is : " + result);
		} else if (parameter.equalsIgnoreCase("CloudCover")) {
			result = compareData(covertToInteger(uiWeatherVal.trim()), covertToInteger(apiWeatherVal.trim()), variance);
			reportLog("CloudCover Comparison result is : " + result);
		} else if (parameter.equalsIgnoreCase("RealFeel")) {
			result = compareData(covertToInteger(uiWeatherVal.trim()), covertToInteger(apiWeatherVal.trim()), variance);
			reportLog("RealFeel Comparison result is : " + result);
		} else {
			reportLog("Sorry! No parameters to compare!");
			throw new CustomException("Exception : Please provide proper value for comparision....");
		}
		return result;
	}

	public static int covertToInteger(String s) {
		return Integer.parseInt(s);
	}

	private boolean compareData(int a, int b, String varianceVal) throws CustomException {
		boolean dataResult;
		int varianceValInt = ComparatorLogic.covertToInteger(varianceVal);
		if (a == b) {
			dataResult = true;
		} else if ((a + varianceValInt == b) || (b + varianceValInt == a)) {
			dataResult = true;
		} else {
			dataResult = false;
			throw new CustomException("Exception : Web Results and API results are not Matching....");
		}
		return dataResult;
	}
}
