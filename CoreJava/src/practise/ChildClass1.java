package practise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Child class is acquiring the properties of parent class by the extends word
//Parent child relationship will establish
public class ChildClass1 extends parentClassInheritence {
	

	// If you add before method in parent class then also it would run first if you execute the child code
	
	@Test
	public void testRun()
	{
		//If there is no concept of inheritance, you cannot call any method which is present in another class. The only way you call another class method is by creating object of that class
//		parentClassInheritence pc = new parentClassInheritence();
//		pc.firstMethod();
		firstMethod(); // parent class
		int a=3;
		//Single responsibility principles in frameworks
		//Directly we cannot call this method, as there is no connection between class
		ParentClass2 pc2 = new ParentClass2(3);// Parameterized Constructor
		System.out.println(pc2.increment());
		System.out.println(pc2.decrement());
		//2 Types of creating and calling the method from other class: One is inheritance & other by creating object
		//As the value of "a" doesnot passes to its parentclass, so it can be done by assigning value to its method from child class
		//Eg: System.out.println(pc2.increment(3)); But here each time you have to give value to each method instead of it
		// just pass value to the parent class once by passing when object is created Eg: ParentClass2 pc2 = new ParentClass2(3);
		
		//Constructor : Default When u create any object of any class, a constructor will be called and if you dont send any parameter then 
		//default constructor would be called in backend and one cannot be aware
		//If you are creating object of class with parameter in place, explicitly you have to call constructor
		
		//Through inheritance you can access the method of the parent class by just calling its child class object
		//ParentClass3 pc3 = new ParentClass3(3);
		System.out.println(pc2.multiplyTwo());
		System.out.println(pc2.multiplyThree());
		
		
	}
	
	


}
