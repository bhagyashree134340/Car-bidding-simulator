package carBidding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bidders 
{
	bidder root;		// Stores root of the tree
	
	Scanner sc  = new Scanner(System.in);
//	car c = new car();
	
	ArrayList<bidder> list = new ArrayList<bidder>(5);		// ArrayList to store eligible bidders
	
	public bidders()		// constructor of class bidders
	{
		root = null;
	}
	
	public void create()
	{							//creates a BST
		int flag = 0;
		bidder ptr = null;
		String name = null;
		float bdgt = 0.0f;
		
		System.out.print("\n\t\tEnter name: \t\t");
		name = sc.next();
		System.out.println();
		
		System.out.print("\n\t\tEnter budget: \t\t");
		bdgt = sc.nextFloat();
		System.out.println();
		
		bidder temp = new bidder(name, bdgt);
		
		if(root == null)
		{						//creating the first node i.e. the root
			root = temp;
		}
		else
		{
			ptr = root;			//ptr is a pointer to traverse the tree
			
			while(flag == 0)
			{
				if(temp.budget <= ptr.budget)			//if the data input is less than or equal to the root is added on the left side of the tree
				{
					if(ptr.left == null)
					{
						ptr.left = temp;
						flag = 1;
					}
					else
					{
						ptr = ptr.left;
					}
				}
				else if(temp.budget > ptr.budget)		//if the data input is greater than the root is added on the right side of the tree
				{
					if(ptr.right == null)
					{
						ptr.right = temp;
						flag = 1;
					}
					else
					{
						ptr = ptr.right;
					}
				}
			}
		}
	}
	
	void waitingList(bidder r, float minB)		// traverses the tree to create a waiting list						
	{
		if(r == null)
		{
			return;
		}
		else
		{
			waitingList(r.left, minB);
			waiting(r, minB);
			waitingList(r.right, minB);
		}
	}
	
	
	void waiting(bidder d, float mb)		// waiting list
	{
		//System.out.println(d.budget+" "+mb);
		if(d.budget >= mb)
		{
			d.bid=0;
			list.add(d);
			
			d.display();
		}
		/*else
		{
			System.out.println("\nName:"+d.name);
			System.out.println("Budget remanining: "+d.budget+" (Less than minimum bid required be car owner, hence not eligible!");
		}*/
	}
	
	/*void delete(bidder d)
	{
		list.remove(d);
	}*/
	
	/*void display()
	{
		System.out.println("\n\nBidders eligible to bid: ");
		for(int i = 0 ; i<list.size() ; i++)
		{
			list.get(i).display();
		}
	}*/
	
	
	
//	public bidder search()							//returns address of the value input
//	{
//		bidder ptr = null;
//		bidder addr = null;
//		float bdgt = 0.0f;
//		
//		System.out.println("enter budget: ");
//		bdgt = sc.nextFloat();
//		
//		ptr = root;
//		
//		while(ptr != null)
//		{
//			if(bdgt == ptr.budget)
//			{
//				return ptr;
//			}
//			else if(bdgt < ptr.budget)
//			{
//				ptr = ptr.left;
//			}
//			else
//			{
//				ptr = ptr.right;
//			}
//		}
//		addr = ptr;
//		
//		return addr;
//	}
	
	
}