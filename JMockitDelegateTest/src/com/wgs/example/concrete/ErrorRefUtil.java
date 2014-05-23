package com.wgs.example.concrete;

import java.util.Calendar;
import java.util.Date;

/**
 * The Class ErrorRefUtil.
 * @author Warren Smith
 * @version 1.0
 */
public final class ErrorRefUtil {
	
	/** The start time. */
	private static long START_TIME;
	
	static {
		Calendar calForYearStart = Calendar.getInstance();
		calForYearStart.set(Calendar.DAY_OF_YEAR,1);
		calForYearStart.set(Calendar.HOUR_OF_DAY , 0);
		calForYearStart.set(Calendar.MINUTE, 0);
		calForYearStart.set(Calendar.SECOND, 0);
		calForYearStart.set(Calendar.MILLISECOND, 0);
		START_TIME = calForYearStart.getTimeInMillis();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		int x=0;
		while (x < 999) {
			System.out.println(ErrorRefUtil.getErrorRef());
			Thread.sleep(1);
			x++;
		}
	}

	/**
	 * Prevent Instantiation of a new error ref util.
	 */
	private ErrorRefUtil() {
		// prevent instantiation
	}
	
	/**
	 * Gets the error ref as a base 36 number which is unique within the calendar year to within
	 * millisecond resolution. So May 20th, 2014 at 9.26.20PM will return the ref 5ju0im9.
	 *
	 * @return the error ref
	 */
	public static String getErrorRef() {
		final Date now = new Date();
		System.out.println(now + " - " + (now.getTime()- START_TIME));
		return Long.toString(now.getTime() - START_TIME, Character.MAX_RADIX);
	}
}
