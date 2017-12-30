
package com.logic;

import java.util.HashSet;
import java.util.Set;

public class ExceptionHandling
{
	public static void main(String[] args) throws Exception
	{
		//numberOrNot("notepad.exe");
		//stringReverse("suresh");
		//noTemp();
		removeDuplicates();
	}

	private static boolean numberOrNot(String input) throws Exception
	{
		boolean number = false;
		try
		{
			// Shutdown.exe
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(input);
			// int parseInt = Integer.parseInt(input);
			if (Integer.parseInt(input) > 0 && (input.length() ==4))
			{
				System.out.println("I am integer");
			}
			/*if (null == null)
			{
				System.out.println("equal");
			}
			if ("null".equalsIgnoreCase("null"))
			{
				System.out.println("null equal");
			}*/
		} catch (NumberFormatException nfe)
		{
			System.out.println("********" + nfe.getMessage());
			if (Float.parseFloat(input) > 0)
			{
				System.out.println("i am from long: "+input);
			}
			if(Double.valueOf(input) != null)
			{
				System.out.println("i am double");
			}
		}
		return number;
	}
	private static void stringReverse(String input)
	{
		/*String reverse = "";
		for (int i = input.length()-1; i >=0; i--)
		{
			reverse += input.charAt(i);
		}
		System.out.println(reverse);*/
		char[] charArray = input.toCharArray();
		for (int i =input.length()-1; i>=0; i--)
		{
			System.out.print(charArray[i]);
		}
		/*if((input == null) || input.length() <= 1)
		{
			return input;
		}
		
		return stringReverse(input.substring(1))+input.charAt(0);*/
	}
	
	private static void noTemp()
	{
		int i=1, j=20; int temp;
		System.out.println("Before temp: "+i+" "+j);
		/*i = i^j;
		j = j^i;
		i = i^j;*/
		
		/*i = i+j;
		j = i-j;
		i = i-j;*/
		
		temp =i;
		i=j;
		j=temp;
		
		i =i^j;
		j = j^i;
		i = i^j;
		System.out.println(i+" "+j+" "+i);
		System.out.println("After temp: "+i+" "+j);
	}

	private static void removeDuplicates()
	{
		String[] str ={"babu","jay","babu1","jay"};
		for (int i = 0; i < str.length-1; i++)
		{
			for (int j = i+1; j < str.length; j++)
			{
				if((str[i].equals(str[j])) && i != j){
					System.out.println("Duplicate elements are: "+str[i]);
				}
			}
		}
		Set<String> hashSet =new HashSet<String>();
		for (String dd : str)
		{
			if(!hashSet.add(dd))
			{
				System.out.println(dd);
			}
		}
		String ss="hi dgdfgk suresh babu  ";
		System.out.println(ss.replaceAll("\\s", ""));
		
		 char[] strArray = ss.toCharArray();
		 
	        StringBuilder sb = new StringBuilder();
	 
	        for (int i = 0; i < strArray.length; i++)
	        {
	            if( (strArray[i] != ' ') && (strArray[i] != '\t') )
	            {
	                sb.append(strArray[i]);
	            }
	        }
	 
	        System.out.println(sb);  
	}
}
