package br.com.bruno.financas.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverterUtil {

	private static DateFormat df = new SimpleDateFormat("dd/MM/YYYY");

	public static String DateToString(Date date) {
		String dateString = null;
		try {
			dateString = df.format(date);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;
	}

	public static String CalToString(Calendar cal) {
		String dateString = null;
		try {
			dateString = df.format(cal.getTime());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;
	}
}
