package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 public class BerlinClockUtil {

	public static boolean validate24HrsClockTime(String time) {
		Pattern pattern;
		Matcher matcher;
		final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
		matcher = pattern.matcher(time);
		return matcher.matches();
	}
}



