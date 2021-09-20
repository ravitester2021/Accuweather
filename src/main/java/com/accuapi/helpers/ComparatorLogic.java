package com.accuapi.helpers;

import com.accuui.base.AccuUIBase;

public class ComparatorLogic extends AccuUIBase {

	public boolean CompareVariance(String parameter, String uiWeatherVal, String apiWeatherVal, String variance)
			throws CustomException {

		boolean result = false;
		if (parameter.equalsIgnoreCase("Humidity")) {
			result = compareDataDouble(convertToDouble(uiWeatherVal.trim()), convertToDouble(apiWeatherVal.trim()),
					variance);
			reportLog("Humidity Comparison result is : " + result);
		} else if (parameter.equalsIgnoreCase("CloudCover")) {
			result = compareDataDouble(convertToDouble(uiWeatherVal.trim()), convertToDouble(apiWeatherVal.trim()),
					variance);
			reportLog("CloudCover Comparison result is : " + result);
		} else if (parameter.equalsIgnoreCase("RealFeel")) {
			result = compareDataDouble(convertToDouble(uiWeatherVal.trim()), convertToDouble(apiWeatherVal.trim()),
					variance);
			reportLog("RealFeel Comparison result is : " + result);
		} else if (parameter.equalsIgnoreCase("Temperature")) {
			result = compareDataDouble(convertToDouble(uiWeatherVal.trim()), convertToDouble(apiWeatherVal.trim()),
					variance);
			reportLog("Temperature Comparison result is : " + result);
		} else {
			reportLog("Sorry! No parameters to compare!");
			throw new CustomException("Exception : Please provide proper value for comparision....");
		}

		return result;
	}

	public static double convertToDouble(String s) {
		return Double.parseDouble(s);
	}

	private boolean compareDataDouble(double a, double b, String varianceVal) throws CustomException {
		boolean dataResult;
		reportLog(
				"Your Value A is = " + a + " AND " + "Your Value B is = " + b + " AND Variance Val is =" + varianceVal);
		double varianceValDouble = ComparatorLogic.convertToDouble(varianceVal);
		reportLog("So, A - B is = " + (a - b) + "  AND Variance Val is = " + varianceValDouble);
		if ((a - b == 0) || ((a - b) < varianceValDouble)) {
			dataResult = true;
		} else {
			dataResult = false;
			throw new CustomException("Exception : Web Results and API results are not Matching....");
		}
		return dataResult;
	}
}
