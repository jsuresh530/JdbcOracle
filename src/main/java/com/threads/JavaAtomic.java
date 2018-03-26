package com.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class JavaAtomic
{

	public static void main(String[] args) throws InterruptedException
	{
		SureshThread st =new SureshThread();
		Thread t1 =new Thread(st, "t1");
		t1.start();
		
		Thread t2 =new Thread(st, "t2");
		t2.start();
		
		t1.join();
		t2.join();
		
        System.out.println("Processing count=" + st.getCount());

		
	}

}

class SureshThread implements Runnable
{
	//public int count = 0;
	
	AtomicInteger count = new AtomicInteger();
	@Override
	public void run()
	{
		for (int i = 1; i < 5; i++)
		{
			runToCount(i);
			//count++;
			count.incrementAndGet();
		}
	}
	
	public int getCount()
	{
		return this.count.get();
	}
	private void runToCount(int i)
	{
		try
		{
			Thread.sleep(i*10);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
