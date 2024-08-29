package practiseProject;

public class CoreJava3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String is an object, that represent sequence of character
		//If string are same then in backend only one object would be created
		//its string literal
		String s1="Rahul Shetty Acadamy";
		String s2="Rahul Shetty Acadamy";
		String s3="Hello";
		//new object
		//Created one objct s4 and storing value welcome in it (another way to declare string)
		// Here 2 objects are created, 
		//Using new operator each item you say that go and create space for my object in java memory
		
		String s4= new String("Welcome");
		String s5 = new String("Welcome");
		
		System.out.println("********** String Split **************");
		String s="Rahul Shetty Academy";
		String[] splittedString = s.split(" ");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		System.out.println("********** String Split & trim **************");
		//Split with Shetty word
		String[] ss1= s.split("Shetty");
	
		System.out.println(ss1[0]);
		System.out.println(ss1[1]);
		//trim will remove white spaces
		System.out.println(ss1[1].trim());
		
		System.out.println("********** String converted in Character **************");
		for (int i=0;i<s.length();i++)
		{
			System.out.println(s.charAt(i));
		}
		
		System.out.println("********** Print string in reverse order **************");
		for (int i=s.length()-1;i>=0;i--)
		{
			System.out.println(s.charAt(i));
			
		}
		
		
	}

	// What is string?
	//Ans: String is an object, that represent sequence of character 
	//How many way you can define string
	//Ans: 2 Ways, one is string literal & another way to new memory allocate operator
	//Difference between declaring s1 & s4?
	//Ans: In string literal if you have same multiple value with same name then it won't create new object, it would refer to existing object
	// No matter it same string value it will create new object in memory space
}
