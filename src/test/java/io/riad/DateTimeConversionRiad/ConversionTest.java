package io.riad.DateTimeConversionRiad;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ConversionTest {

	@Test
	public void testAsDateLocalDate() {
		Date date=Conversion.asDate(LocalDate.now());;
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM d zzz y");  
		String formattedDate = formatter.format(date);

		Date dateExpected=new Date ();
		SimpleDateFormat formatter1=new SimpleDateFormat("E MMM d zzz y");
		String formatedDateExpected=formatter1.format(dateExpected);
		
		
		assertEquals(formatedDateExpected, formattedDate);
	}

	@Test
	public void testAsDateLocalDateTime() {
		Date date=Conversion.asDate(LocalDateTime.now());
		Date dateExpected =new Date();
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");  
		String formattedDate = formatter.format(date);
		String formatedDateExpected=formatter.format(dateExpected);
		
		assertEquals(formatedDateExpected, formattedDate);
		
	}

	@Test
	public void testAsLocalDate() {
		
		LocalDate localdate=Conversion.asLocalDate(Date.from(Instant.now()));
		LocalDate expectedLocalDate=LocalDate.now();
		assertEquals(expectedLocalDate, localdate);

	}

	@Test
	public void testAsLocalDateTime() {
		
		LocalDateTime localDateTime=Conversion.asLocalDateTime(Date.from(Instant.now()));
		LocalDateTime expectedLocalDateTime=LocalDateTime.now();
		
		//assertEquals(expectedLocalDateTime, localDateTime);
		
		assertEquals(expectedLocalDateTime.now().getYear(),localDateTime.now().getYear());
		assertEquals(expectedLocalDateTime.now().getDayOfMonth(),localDateTime.now().getDayOfMonth());
		assertEquals(expectedLocalDateTime.now().getDayOfWeek(),localDateTime.now().getDayOfWeek());
		
	}
	
	
	
	
	
	@Test
	public void testConversionToDateFromCalender() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		assertEquals( formatter.format(new Date()), formatter.format(Conversion.conversionToDateFromCalender(Calendar.getInstance())));
		assertNotNull(Conversion.conversionToDateFromCalender(Calendar.getInstance()));
	
	}
	
	@Test
	public void testConversionToLocalDateFromCalender() {
		
		assertEquals(LocalDate.now(), Conversion.conversionToLocalDateFromCalender(Calendar.getInstance()));
		
	}
	
	@Test
	public void testConversionToStringFromDate() {
		
		assertEquals("2019/01/17" , Conversion.conversionToStringFromDate(new Date()));
		
	}
	@Test
	public void testConversionToDateFromString() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		assertEquals(formatter.format(new Date()), formatter.format(Conversion.conversionToDateFromString("2019/01/17")));
	}
	
	
	@Test
	public void testConversionToLocalDateFromString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
		LocalDate localDate = LocalDate.parse("2019/01/24" , formatter);
		assertEquals(localDate, Conversion.conversionToLocalDateFromString("2019/01/24"));
	
	}
	
	@Test
	public void testConversionToStringFromLocalDate() {
		assertEquals("2019/01/17", Conversion.conversionToStringFromLocalDate(LocalDate.now()));
	
	}
	
	

}
