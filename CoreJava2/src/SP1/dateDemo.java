package SP1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//How to display system (current) date
		Date d = new Date();
		System.out.println(d.toString());
		
		//How to print date in format. Need to set date format in argument
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyy");
		//But date is in d object so need to combine it with sdf object
		System.out.println(sdf.format(d));
		//Ref of the date format can be get from : https://www.tutorialspoint.com/java/java_date_time.htm
		
		SimpleDateFormat sd=new SimpleDateFormat("M/d/yyy hh:mm:ss");
		System.out.println(sd.format(d));
		
	}

}
