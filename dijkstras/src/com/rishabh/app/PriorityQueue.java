package com.rishabh.app;

import java.util.ArrayList;
public class PriorityQueue 
{
	private ArrayList<QueueItem> prique;

	public PriorityQueue()
	{
		prique=new ArrayList<QueueItem>();
		prique.sort(null);
	}
	public void enqueue(QueueItem qi)
	{
		prique.add(qi);
		prique.sort(null);
	}
	public QueueItem dequeue()
	{
		if(!prique.isEmpty())
		{
			QueueItem qi=prique.get(0);
			prique.remove(0);
			return qi;
		}
		else
			return null;
	}
	public void display()
	{
		if(!prique.isEmpty())
		{
			for(int i=0;i<prique.size();i++)
			{
				System.out.println(prique.get(i).getCumulativePathLength());
			}
		}
		else 
			System.out.println("The Priority Queue is Empty ... , nothing to Dequeue.");
		
	}
}
