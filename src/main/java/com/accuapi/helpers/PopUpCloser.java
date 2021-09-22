package com.accuapi.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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

	public void closePopUpUpdated() {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
		} catch (Exception e) {
		}
	}

}
