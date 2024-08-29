package practise;

public class ParentClass3 {

	int a;
	
	public ParentClass3(int a) {
		
		this.a=a;
		//This. refers to current class variables; here this.a refers to your global variable "a" of this class
		
	}
	public int multiplyTwo()
	{
		a= a*2;
		return a;
	}
	
	public int multiplyThree()
	{
		a=a*3;
		return a;
	}
	
}
