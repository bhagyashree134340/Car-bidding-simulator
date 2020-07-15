package carBidding;

import java.util.Scanner;

import java.util.regex.Pattern;

public class cars 
{
	car select;		//Selects a car from the hash
	static int index;		//Address of the hash
	int max;		// Stores size of the hash
	car carStore[];		// Stores the hash
	
	Scanner sc=new Scanner(System.in);
	
	public cars()		// constructor of class cars 
	{
		index=0;
		max=15;
		carStore=new car[max];
		select=carStore[index];
	}
	
	void insert()		// inserts entries in the hash
	{
		String name;
		String num;	
		String brand;
		String model;
		float cost;	
		float bid;	
		int hash_add;
		
		
		System.out.print("\n\t\tEnter car Owner Name: \t\t");
		name=sc.next();
		System.out.println();
		
		int flag=0;
		
		do
		{
			flag=0;
			
			System.out.print("\n\t\tEnter license plate number of the car: (LL-XX-LL-XXXX)\t\t");
			num=sc.next();
			System.out.println();
			
			if(validator(num))
			{
			}
			else
			{
				System.out.println("\n\t\tInvalid format of License plate number! Enter in (LL-XX-LL-XXXX) format:");
				flag=1;
			}
			
			if(search(num))
			{
				System.out.println("\n\t\tDuplicate license plate number!");
				System.out.println("\n\t\tRe-enter!");
				flag=1;
			}
			
			
		}while(flag == 1);

		System.out.print("\n\t\tEnter car brand: \t\t");
		brand=sc.next();
		System.out.println();
		
		System.out.print("\n\t\tEnter car model name: \t\t");
		model=sc.next();
		System.out.println();
		
		System.out.print("\n\t\tEnter original cost of the car: \t\t");
		cost=sc.nextFloat();
		System.out.println();
		
		System.out.print("\n\t\tEnter minimum bid expectes by the owner for this car: \t\t");
		bid=sc.nextFloat();
		System.out.println();
		
		car temp=new car(name,num,brand,model,cost,bid);
		
		int key=Integer.parseInt(num.substring(9));		//converts string to integer data type
		
		hash_add=(key%max);
				
		if(carStore[hash_add]==null)
		{
			carStore[hash_add]=temp;
		}
		else
		{
			car add=carStore[hash_add];
			while(add.next!=null)		
			{
				add=add.next;				
			}
			add.next=temp;
		}
	}
	
	void display(car ptr)
	{
		System.out.println("\n\tCar Brand name: "+ptr.brand);
		System.out.println("\tCar Model Name: "+ptr.modelName);
		System.out.println("\tCar Owner name: "+ptr.name);
		System.out.println("\tCar License Plate Number: "+ptr.licPNo);
		
		if(ptr.soldprice==0)
		{
			System.out.println("\tOriginal cost of the car --> $"+ptr.originalCost);
			System.out.println("\tMinimum bid expected by owner --> $"+ptr.minBid);
		}
		else
		{
			System.out.println("\tCar sold at a price of --> $"+ptr.soldprice);
			System.out.println("\tTo-->"+ptr.buyer);
		}
		
		System.out.println("\t-----------------------------");
		
	}
	
	void displayAll()
	{
		car ptr=null;
		
		for(int i=0; i<max; i++)
		{
			ptr=carStore[i];
			while(ptr!=null)
			{
				System.out.println("\t\tCar Brand name: "+ptr.brand);
				System.out.println("\t\tCar Model Name: "+ptr.modelName);
				System.out.println("\t\tCar Owner name: "+ptr.name);
				System.out.println("\t\tCar License Plate Number: "+ptr.licPNo);
				
				if(ptr.soldprice==0)
				{
					System.out.println("\n\t\tCar Not Sold Yet!");
				}
				else
				{
					System.out.println("\n\t\tCar sold at a price of --> $"+ptr.soldprice);
					System.out.println("\n\t\tTo --> "+ptr.buyer);
				}
				ptr=ptr.next;
				System.out.println("\t\t-----------------------------");
			}
		}
	}
	
	boolean search(String str)		//str is license plate number of the car which is dequeued
	{
		int flag = 0;
		
		if(validator(str))
		{
			int key=Integer.parseInt(str.substring(8, 13));
			int addr=(int)(key%max);
			
			car ptr=carStore[addr];
			
			while(ptr!=null)
			{
	
				if(ptr.licPNo.equals(str))
				{
					flag=1;
					break;
				}
				ptr=ptr.next;
			}
		}
			
			if(flag==1)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	void delete(String str)
	{
		int key=Integer.parseInt(str.substring(8,13));
		int addr=(int)(key%max);
		
		car ptr=carStore[addr].next;
		car prev=carStore[addr];
		
		if(prev.licPNo==str)
		{
			prev.next=null;
			carStore[addr]=ptr;		//deletion successful
		}
		else
		{
			while(ptr.licPNo!=str)
			{
				prev=ptr;
				ptr=ptr.next;
				
				if(ptr.licPNo==str)
				{
					break;
				}
			}
			
			if(ptr.licPNo==str)
			{
				prev.next=ptr.next;
				ptr.next=null;			//deletion successful
			}
		}
	}
	
	car select()		// Selects a car node sequentially every time select() is called 
	{
		int flag=0;
		car current=null;/*
		select=carStore[index];*/
		
		do 
		{
			flag=0;
			while(select==null)			//if the node in the hash table is empty(null)
		
			{
				index++;//inc head
				if(index==15)
				{
					index=0;
				}
				select=carStore[index];		//we move to next head
			}
			
			if(select!=null)
			{
				if(!select.sold)
				{	current=select;
					select=select.next;
					if(select==null)
					{
						break;
					}
				}else
				{
					while(select.sold)
					{
						if(select.next==null)
						{
							flag=1;
							select=select.next;
							break;
						}
						select=select.next;
					}
					current=select;
				}
		}
	}while(flag==1);
	return current;
		
		/*car current = null;
		int flag = 0;
		
		
		do
		{
			flag = 0;
			if(carStore[index] != null)
			{
				current = carStore[index++];
				
				while(current.next != null)	
				{
					if(!current.sold)
					{
						break;
					}
					else
					{
						current = current.next;
					}
				}
			}
		else
			{
				index++;
				if(index<15)
				{
					flag = 1;
				}
		
				else
				{
					index = 0;
				}
			}
		}while(flag==1);
		
		if(current!=null)
		{
			return current;
		}
		else
		{
			return select();
		}*/
	}
	
	boolean validator(String lpn)		// Validates the entered string as car license plate number
	{
		int len = lpn.length();
		boolean validLength = len>=10;
		
		if(!validLength)
		{
			return false;
		}
		
		boolean rightAns = Pattern.compile("^[A-Z a-z]{1,2}-[0-9]{1,3}-[A-Z a-z]{1,3}-[0-9]{1,4}$").matcher(lpn).find();
		
		if(!rightAns)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}