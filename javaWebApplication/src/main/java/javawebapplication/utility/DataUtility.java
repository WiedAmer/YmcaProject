package javawebapplication.utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DataUtility {

	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
	// public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	/**
	 * Date formatter
	 */
	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
	// private static final SimpleDateFormat timeFormatter = new
	// SimpleDateFormat(APP_TIME_FORMAT);

	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	public static String getStringData(Object val) {

		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	public static Date getDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {
		}
		return date;
	}

	public static Date getDate1(String val) {
		Date date = null;

		try {
			date = formatter.parse(val);

		} catch (Exception e) {
		}
		return date;
	}

	public static Calendar getCalendarWithoutTime(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	public static List getDatesBetween(Date startDate, Date endDate) {
		List datesInRange = new ArrayList<>();
		Calendar calendar = getCalendarWithoutTime(startDate);
		Calendar endCalendar = getCalendarWithoutTime(endDate);

		if (calendar.equals(endCalendar)) {
			Date result = calendar.getTime();
			datesInRange.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		while (calendar.before(endCalendar)) {
			Date result = calendar.getTime();
			datesInRange.add(result);
			calendar.add(Calendar.DATE, 1);
		}

		return datesInRange;
	}

	public static String getDateString(Date date) {

		try {
			if (date != null) {
				return formatter.format(date);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}

	}

	public static Date getDate(Date date, int day) {
		return null;
	}

	public static Timestamp getTimestamp(long l) {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static Timestamp getTimestamp(String cdt) {
		Timestamp timeStamp = null;
		try {
			// timeStamp = new Timestamp((timeFormatter.parse(cdt)).getTime());
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return timeStamp;
	}
}
