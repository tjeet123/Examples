package practiseProject;

public class CoreJava1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter ='r';
		double dec = 3.99;
		boolean myCard = true;
		
		System.out.println(myNum +" is the value stored in myNum variable");
		System.out.println(website);
		
		//Arrays- it can store multiple values in one variable, so that variable is called array
		int[] arr = new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		int[] arr2 = {1,2,3,4,5,8,9,23,56};
		
		//for loop arr.length -1
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	
		for(int i=0;i<arr2.length;i++)
		{
			System.out.println(arr2[i]);
		}
		
		String[] name = {"jitendra", "jeetu","selenium"};
		for (int i=0;i<name.length;i++)
		{
			System.out.println(name[i]);
		}
		
		//Enhanced for loop
		for (String s:name)
		{
			System.out.println(s);
		}
		
		
		
	}

}
