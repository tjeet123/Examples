package SP1;

import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Calendar;

public class CalenderDemo {
	
	public static void main(String[] args)
	{
		//Calendar has more feature then date class
		//Here we have used calendar instance to get system date & time
		//In the date class we have used date instance to get system date & time
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		System.out.println(sd.format(cal.getTime()));
		
		
		
		//Unique feature which calendar provides but not date class provides
		//How to get todays day
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		//Need to check its Am or PM : Output 0=AM & 1=PM
		System.out.println(cal.get(Calendar.AM_PM));
		
		//Need to check current minute
		System.out.println(cal.get(Calendar.MINUTE));
	}

}
