package SP1;

public class Multidimensional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[][] = {{3,5,7},{8,15,10},{6,1,9},{5,8,7}};
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
		
		//To get min & max value from the above array
		
		int min=a[0][0]; //just to assign one number in variable to compare
		int max=a[0][0];
		for(int k=0;k<4;k++)
		{
			for(int l=0;l<3;l++)
			{
				if(a[k][l]<min)
				{
					min=a[k][l];
					System.out.println(a.length);
				}
				if(a[k][l]>max)
				{
					max=a[k][l];
				}
			}
		}
		
		System.out.println("Minimum nuber is: " +min);
		System.out.println("Maximum number is: " +max);
		
		
		
	}

}
