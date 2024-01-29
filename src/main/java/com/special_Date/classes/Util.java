package com.special_Date.classes;

import java.util.Date;

public class Util {

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		System.out.println(date);	
		String emailTimeStamp = date.toString().replace(" ","_").replace(":","_");
		System.out.println(emailTimeStamp);
		return "Seleniumpanda"+emailTimeStamp+"@gmail.com";
}

}
