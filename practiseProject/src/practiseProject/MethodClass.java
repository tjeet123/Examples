package practiseProject;

public class MethodClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********** Below method is called by creating object of the class **************");
		//if you want to access any methods of that class then created object of that class
		MethodClass mc = new MethodClass();
		mc.getData();
		//What this method return we capture it in string name
		String name = mc.getData1();
		System.out.println(name);
		System.out.println("********** Below method is called from other class by creating object of that class **************");
		//Create object of that class
		MethodClassDemo mcd = new MethodClassDemo();
		String name1 = mcd.getUserData();
		System.out.println(name1);
		System.out.println("********** No need to access data by creating object as method is static **************");
		getData2();
		
		
	}
	//Some line of code if its reuse then create method
	//Method should not be created inside the main block
	//Getdata method can be access by other classed also as its declared as public
	//void means what this method returns(its return type) if method is returning nothing then put void
	public void getData()
	{
		System.out.println("Hello World");
	}
	
	public String getData1()
	{
		System.out.println("Hello World");
		return "Jitendra";
	}
	//Is there any way to access own class methods without creating any object
	//It can be done by mark your method as static, then that method will belong to class and not object
	//As we add static keyword then class level access is provided to the method
	public static void getData2()
	{
		System.out.println("Hello World");
	}
}
