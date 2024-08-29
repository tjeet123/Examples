package SP1;

public class PractiseofArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//In multi dimensional array first find min value then for that column of min value find max value
		
		/*
		 First write the steps or ellobrate what need to do (analyze it & then start)
		 Step1: Find the min number
		 Step2: Identify the column of min number
		 Step3: Find the max number in identified column
		 */

		int a[][]= {{2,4,5},{3,2,10},{1,2,0}};
		int min=a[0][0];
		int mincolumn = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(a[i][j]<min)
				{
					//Step1: Find the min number
					min=a[i][j];
					//Step2: Identify the column of min number
					mincolumn=j;
				}
			}
		}
		System.out.println("Min number is: " +min);
		System.out.println("Min column is: " +mincolumn);
		
		// Step3: Find the max number in identified column
		
		int k=0;
		int max = a[0][mincolumn];
		while(k<3)
		{
			if(a[k][mincolumn]>max)
			{
				max=a[k][mincolumn];
			}
			k++;
		}
		
		System.out.println("Max number of specified column is:" +max);
	}

}
