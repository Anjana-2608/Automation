package utils;

import java.util.Date;

public class Utilities {

	public static String generateNewEmail()
	{
		return new Date().toString().replaceAll(" ","").replaceAll(":", "")+"@gmail.com";

	}
}
