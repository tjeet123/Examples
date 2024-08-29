package Practise;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class regular {
  @Test
  public void series() {
	  
	  //Count the number of names starting with alphabet A in list
	  ArrayList<String> names = new ArrayList<String>();
	  names.add("Abhijeet");
	  names.add("Don");
	  names.add("Alekiya");
	  names.add("Adam");
	  names.add("Ram");
	  int count = 0;
	  for(int i=0;i<names.size();i++)
	  {
		  String actualName = names.get(i);
		  if(actualName.startsWith("A")) 
		  {
			  count++;
		  }
		  
	  }
	 System.out.println(count);
	  
  }
}
