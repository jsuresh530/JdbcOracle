package com.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Example
{

	public static void main(String[] args)
	{
		//threadExampleDemo();
		listDemoExample();
	}
	private static void listDemoExample()
	{
		List<Integer> asList = Arrays.asList(1,2,3);
		System.out.println(asList.toString());
		
		//java 8 for each
		asList.forEach(new Consumer<Integer>()
		{
			@Override
			public void accept(Integer t)
			{
				System.out.println("------------ "+t);
			}
		});
		//java 8 makes lamda even more beautiful...
		asList.forEach((Integer i )-> System.out.println("@@@@@@@@ "+i));
		asList.forEach(i -> System.out.println(": ------> "+i));
		
	}
	private static void threadExampleDemo()
	{
		final String name ="Suresh";
		Runnable r =new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("-------------"+name);
			}
			
		};
		
		Runnable rr = () -> System.out.println("Hi "+name);
		
		Thread t = new Thread(rr);
		t.start();
		
		Thread tt =new Thread(r);
		tt.start();
		
		//java.lang.IllegalThreadStateException
	}

}
