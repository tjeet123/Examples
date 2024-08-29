package SP1;

public class loop1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
// Need this pattern
//	   1 2 3 4
//	   5 6 7
//	   8 9
//	   10   
	 int k=1;
	for (int i=1;i<=4;i++) // or can be done through for (int i=0;i<4;i++)
	{
		for(int j=i;j<=4;j++) //or can be done through for (int j=1;j<=4-i;j++)
		{
		System.out.print(k);
		System.out.print("\t");
		k++;
		}


		System.out.println("");
	}
	
	//for loop output
//	1	
//	2	3	
//	4	5	6	
//	7	8	9	10
	int n=1;
	for (int l=1;l<=4;l++)  // or can be done through for (int l=1;l<5;l++)
	{
		for (int m=0;m<l;m++)  // or can be done through for (int m=1;m<=l;m++)
		{
			System.out.print(n);
			System.out.print("\t");
			n++;
		}
		System.out.println("");
	}
	
	
	//for loop output
//	1	
//	1	2	
//	1	2	3	
//	1	2	3	4
	
	for (int o=1;o<=4;o++) // or can be done through for (int o=1;o<5;o++)
	{
		for (int p=1;p<=o;p++) // or can be done through for (int p=1;p<=o;p++)
		{
			System.out.print(p);
			System.out.print("\t");
		}
		System.out.println("");
	}
	
	//for loop output
//	3	
//	6	9	
//	12	15	18	
	int s= 3;
	for (int q=1;q<=3;q++)
	{
		for (int r=1;r<=q;r++)
		{
			System.out.print(s);
			System.out.print("\t");
			s=s+3;
		}
		System.out.println("");
	}
	
	}
}
