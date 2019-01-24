package io.riad.DateTimeConversionRiad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Conversion {

	
	public static Date asDate(LocalDate localDate) {

		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	    
	    
	  }

	  public static Date asDate(LocalDateTime localDateTime) {
	    
		
		  return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static LocalDate asLocalDate(Date date) {
	    
		 
		  return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	  }

	  public static LocalDateTime asLocalDateTime(Date date) {
		  
		  
		  return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	  	  
	  }
	  
	  
	  
//	  public static Calendar dateToCalendar(Date date) {
//
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
//			return calendar;
//
//		}
//
//		//Convert Calendar to Date
//	  public static Date calendarToDate(Calendar calendar) {
//			return calendar.getTime();
//		}
	  
	  
	  public static Date conversionToDateFromCalender(Calendar calender) {
			Date date = new Date();
			date = calender.getTime();
			return date;
			
		}
	  
	  public static LocalDate conversionToLocalDateFromCalender(Calendar calender) {
			return calender.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
		}
	  public static String conversionToStringFromDate(Date date) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
			return formatter.format(date);
		}
	  
	  public static Date conversionToDateFromString(String string) throws ParseException {
			
			return new SimpleDateFormat("yyyy/MM/dd").parse(string);
		}
	  
	  public static LocalDate conversionToLocalDateFromString(String string) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
	        LocalDate localDate = LocalDate.parse(string , formatter);
	        return localDate;
		}
	  
	  public static String conversionToStringFromLocalDate(LocalDate localDate) {
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
			return localDate.format(formatter);
			
		}
	  

	  public static void main(String[] args)  {


	}

}
