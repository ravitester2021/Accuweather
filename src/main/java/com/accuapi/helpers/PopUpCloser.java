package com.accuapi.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import com.accuui.base.AccuUIBase;

public class PopUpCloser extends AccuUIBase {

	public void closePopUp() {
		try {
			((JavascriptExecutor) driver).executeScript("window.onbeforeunload = function(e){};");
		} catch (Exception e) {
			Alert alertCancel = driver.switchTo().alert();
			alertCancel.dismiss();
		}

	}

}
