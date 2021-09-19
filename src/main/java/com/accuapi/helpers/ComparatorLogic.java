package com.accuapi.helpers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.accuapi.model.GetCurrentConditions;
import com.accuui.pages.AccuUiWeatherPage;

public class ComparatorLogic implements Comparator<ComparatorLogic> {

	private String cloudCover, humidity, weather, RealFeel;
	static HashMap<String, String> s1 = new HashMap<String, String>();
	static HashMap<String, String> s2 = new HashMap<String, String>();

	public void addData() {
		s1.put("1", "One");
		s1.put("2", "Two");

		s2.put("1", "One");
		s2.put("2", "Two");
	}

	public int compare(HashMap<String,String> s12, HashMap<String,String> s22) {
		return 0;
//		if (m1.getWeatherOfCity("") < m2.getCurrentWeatherInDetail()) return -1;
//        if (m1.getRating() > m2.getRating()) return 1;
//        else 
//        	return 0;
	}

	public int compare(ComparatorLogic o1, ComparatorLogic o2) {
		// TODO Auto-generated method stub
		System.out.println(o1.s1.equals(o2.s2));
//		if(o1.s1.equals(o2.s2)) {
			
//		}
		return 0;
	}
	
	public static void main(String[] args) {
		ComparatorLogic obj = new ComparatorLogic();
		obj.compare(s1, s2);
//		System.out.println(obj.compare(s1, s2));
//		System.out.println(s1.equals(s2));
		System.out.println(s1.keySet().equals(s2.keySet()));
		System.out.println(s1.values().equals(s2.values()));
//		s1.
//		System.out.println((asiaCapital1, asiaCapital2));
		//Compare values
	}

}
