package practiseProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr2 = {1,2,3,4,5,8,9,23,56};
		
		for (int i=0;i<arr2.length;i++) 
		{
			if (arr2[i] % 2 == 0)
			{
				System.out.println(arr2[i] +" is multiple of 2");
			}
			else
			{
				System.out.println(arr2[i] +" is not multiple of 2");
			}
		}
		System.out.println("********** check that array has multiple of 2 **************");
		//check that array has multiple of 2 (only one value)
		for (int i=0;i<arr2.length;i++) 
		{
			if (arr2[i] % 2 == 0)
			{
				System.out.println(arr2[i] +" is multiple of 2");
				break;
			}
			else
			{
				System.out.println(arr2[i] +" is not multiple of 2");
			}
		}
		System.out.println("********** Array List **************");
		//Below arrayList will save only string values as we have add string after arraylist
		ArrayList<String> a = new ArrayList<String>();
		//What to access method of the class then need to create object of the class
		a.add("Jitendra");
		a.add("Jeetu");
		a.add("Selenium");
		//to remove value from the array, it would remove selenium from the list
		//a.remove(2);
		//to extract value in the array list use get method, it will print "jeetu" in output
		System.out.println(a.get(1));
		
		//In arrayList we will use size method to get the count
		//But in array we will use length method to get the count 
		//In array its static size but in arraylist you can dynamically grow by adding multiple items into list
		
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		
		System.out.println("********** Enhanced for loop **************");
		
		//Enhanced for loop
		for(String val:a)
		{
			System.out.println(val);
		}
		System.out.println("********** Item is present in ArrayList **************");
		
		// item is present in arraylist or not, then use contains method
		System.out.println(a.contains("Selenium"));
		
		System.out.println("********** Convert array to ArrayList **************");
		
		String[] name = {"jitendra", "jeetu","selenium"};
		List<String> nameArrList = Arrays.asList(name);
		System.out.println(nameArrList.contains("jeetu"));
	}

}
