package com.patterns;

public class PatternTest
{

	public static void main(String[] args)
	{
		//pattern1();
		//pattern2();
		//pattern3();
		//pattern4();
		//patten5();
		floydsTriangle();
	}
	/*
		1  
		1 2  
		1 2 3  
		1 2 3 4  
		1 2 3 4 5  
		1 2 3 4 5 6  
		1 2 3 4 5 6 7  
	 */
	private static void pattern1()
	{
		for (int i = 1; i <= 7; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(j+" ");
			}
			System.out.println(" ");
		}
	}
	/*
	1  
	2 2  
	3 3 3  
	4 4 4 4  
	5 5 5 5 5  
	6 6 6 6 6 6  
	7 7 7 7 7 7 7
	 */
	private static void pattern2()
	{
		for (int i=0; i <=7; i++)
		{
			for (int j = 1; j <=i; j++)
			{
				System.out.print(i+" ");
			}
			System.out.println(" ");
		}
	}
	
	/*
	1  
	1 2  
	1 2 3  
	1 2 3 4  
	1 2 3 4 5  
	1 2 3 4 5 6  
	1 2 3 4 5 6 7  
	1 2 3 4 5 6  
	1 2 3 4 5  
	1 2 3 4  
	1 2 3  
	1 2  
	1  
	 */
	private static void pattern3()
	{
		//Upper pattern
		for (int i = 1; i <= 7; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(j+" ");
			}
			System.out.println(" ");
		}
		//Lower pattern
		for (int i=6; i>=1; i--)
		{
			for (int j = 1; j <=i; j++)
			{
				System.out.print(j+" ");
			}
			System.out.println(" ");
		}
	}
	/*
 	1 2 3 4 5 6 7  
	1 2 3 4 5 6  
	1 2 3 4 5  
	1 2 3 4  
	1 2 3  
	1 2  
	1 
	 */
	private static void pattern4()
	{
		for (int i = 7; i >= 1; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(j+" ");
			}
			System.out.println(" ");
		}
	}
	/*
		7 6 5 4 3 2 1  
		7 6 5 4 3 2  
		7 6 5 4 3  
		7 6 5 4  
		7 6 5  
		7 6  
		7  
	 */
	private static void patten5()
	{
		for (int i = 1; i<=7; i++)
		{
			for (int j =7; j>=i; j--)
			{
				System.out.print(j+" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ******************** ");
		for (int i = 7; i >= 1; i--) 
        {
            for (int j = 7; j >= i; j--)
            {
                System.out.print(j+" ");
            }
             
            System.out.println();
        }
	}
	/*
	1	 
	2	3	 
	4	5	6	 
	7	8	9	10	 
	11	12	13	14	15	 
	16	17	18	19	20	21	 
	22	23	24	25	26	27	28	 
	 */
	private static void floydsTriangle()
	{
		int value =1;
		for (int i = 1; i <=7; i++)
		{
			for (int j = 1; j <=i; j++)
			{
				System.out.print(value+"\t");
				value++;
			}
			System.out.println(" ");
		}
	}

}
