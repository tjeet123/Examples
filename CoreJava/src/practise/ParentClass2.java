package practise;

public class ParentClass2 extends ParentClass3{
	//"a" called as class variable
	int a;
	//Default constructor is created
	
	public ParentClass2(int a) {
		//3 value is coming from test case to your constructor. And this class will also access your parent class methods as it
		//has an access.So what ever receive from your test should also be send to parent class to activate
		//Super keyword: Is only use only in inheritance place
		//Super keyword: It should be first line in your child constructor
		super(a); //Parent class constructor is invoked
		// TODO Auto-generated constructor stub
		//Constructor name will always be a class name
		//Constructor would also reflect how many numbers of parameter we need to create
		//We have created object with one parameter so need to crate one constructor with one parameter
		//In constructor variable is given is call instance variable
		//Scope of constructor integer would lie only in this method(block)
		this.a=a;
		//This. refers to current class variables; here this.a refers to your global variable "a" of this class
		
	}
	//public int increment(int a)
	public int increment()
	{
		a=a+1;
		return a;
	}
	//public int decrement(int a)
	public int decrement()
	{
		a=a-1;
		return a;
	}

}
