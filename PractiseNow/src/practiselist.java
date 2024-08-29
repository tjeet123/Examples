import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class practiselist {
	  //@Test
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
	 
	 //@Test
	 public void streamFilter()
	 {
		 ArrayList<String> names = new ArrayList<String>();
		  names.add("Abhijeet");
		  names.add("Don");
		  names.add("Alekiya");
		  names.add("Adam");
		  names.add("Ram");
		  
		  Long number = names.stream().filter(s->s.startsWith("A")).count();
		  //OR
		  //Long number = Stream.of("Abhijeet","Don","Alekiya","Adam","Ram").filter(s->s.startsWith("A")).count();
		  System.out.println(number);
		  
		  //Any operation you do but it would not affect your original source here names datatype is original source
		  //If there is anything wrong then there would be no output for stream
		  //there is no life for intermediate operation if there is no terminal operation
		  //terminal operation will execute only if intermediate operation (filter) returns true
		  //how to use filter in stream API
		  //if it not returns true then it will not execute
		  Long d = names.stream().filter(s->
		  {
			  s.startsWith("A"); 
			  //return false;
			  return true;
		  }).count();
		 System.out.println(d);
		 
		 
		 //print all the names of ArrayList
		 //print name which is greater then 4 character
		 names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		 
		 //need to get sample of only one result
		 names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	 }
	 
	 //@Test
	 public void streamMap()
	 {
		 //print name which has last letter "a" with Uppercase
		 Stream.of("Abhijeet","Don","Alekiya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.
		 toUpperCase()).forEach(s->System.out.println(s));
		 
		 //print the names in uppercase
		 
		 Stream.of("Abhijeet","Don","Alekiya","Adam","Rama").map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		 
		 //print names which have first letter as "A" with uppercase and sorted
		 //convert array to arrayList
		 List<String> names = Arrays.asList("Azbhijeet","Don","Alekiya","Adam","Rama");
		 names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	 }
	 
	 //@Test
	 public void mergeList()
	 {
		 ArrayList<String> name = new ArrayList<String>();
		 name.add("Men");
		 name.add("Don");
		 name.add("Women");
		 
		 List<String> names = Arrays.asList("Azbhijeet","Don","Alekiya","Adam","Rama");
		 //Merging 2 different lists in sorted order and no repeat name
		 
		 Stream<String> NewStream =Stream.concat(name.stream(), names.stream());
		 //NewStream.sorted().distinct().forEach(s->System.out.println(s));
		 
		 //To match any name is present inside the list
		 boolean flag = NewStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		 System.out.println(flag);
		 Assert.assertTrue(flag);
		 
		 
	 }
	 
	 @Test
	 public void collectStream()
	 {
		 //create a list and collect it another list
		 List<String> ls = Stream.of("Abhijeet","Don","Alekiya","Adam","Rama").filter(s->s.endsWith("a")).
				 map(s->s.toUpperCase()).collect(Collectors.toList());
		 //to print only single value
		 System.out.println(ls.get(0));
		 
		 //other way to get only single value printed
		 Stream.of("Abhijeet","Don","Alekiya","Adam","Rama").filter(s->s.endsWith("a")).
		 map(s->s.toUpperCase()).limit(1).forEach(s->System.out.println(s));
		 
		 //print unique number from this array & sort the array
		 List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		 values.stream().distinct().sorted().forEach(s->System.out.println(s));
		 
		 //sorted and give 3rd index (here need to apply distinct to get unique value) 1,2,3,5,7,9
		 List<Integer> nv=values.stream().distinct().sorted().collect(Collectors.toList());
		 System.out.println(nv.get(2));
	 }
}
