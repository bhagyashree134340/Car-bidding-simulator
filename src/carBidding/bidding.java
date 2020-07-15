package carBidding;

import java.util.ArrayList;

public class bidding extends bidders
{
	static int round;
	int t;		//for validating when there is only one eligible bidder
	bidder h[];
//	bidder maxBidder;
	
	public bidding() 
	{
		round = 1;
		t=0;
	}
	
	void bidPriorityQue(car c)		// heaps according to the budget of the bidders 
	{
		System.out.println("\n\tRound " +round++ +" -->\n");
		
		h = list.toArray(new bidder[list.size()]);
		
		if(list.size()==0)
		{
			System.out.println("\n\tNo eligible bidders!");
			System.out.println("\n\tCar unsold!");
		}
		else if(list.size()==1)
		{
			System.out.println("\n\tDo you want to buy this car? 1.Yes 2. NO");
			int ch=sc.nextInt();
			
			if(ch==1)
			{
				list.get(0).bid=c.minBid;
			}
			
			else
			{
				list.get(0).bid=0;
			}
		}
		else
		{
			float f;
			for(int i = 0; i<list.size(); i++)
			{
				int flag = 0;
				do
				{
					flag = 0;
					
					/*do
					{*/
						flag=0;
						System.out.print("\n\tBid by "+list.get(i).name +" : ");
						
						f= sc.nextFloat();
						//System.out.println(f+"<"+list.get(i).bid);
						/*if((f<list.get(i).bid)&&(f!=0))
						{
							flag=1;
							System.out.println("Your bid in this round is lesser than that in previous bid!");
							System.out.println("Either enter a higher bid or that of previous round or enter 0");
						}
						else
						{
							list.get(i).bid=f;
						}*/
					/*}while(flag==1);*/
					
				if(f==0)
				{
				}
				else if((f<list.get(i).bid)&&(f!=0))
				{
					flag=1;
					System.out.println("\n\tYour bid in this round is lesser than that in previous bid!");
					System.out.println("\n\tEither enter a higher bid or that of previous round or enter 0");
				}
				else
				{
					if(f > list.get(i).budget)
					{
						System.out.println("\n\tThe bid is greater than your budget\ntry again");
						flag = 1;
					}
						
					else if(f<c.minBid)
					{
						System.out.println("\n\tThe bid is lesser than minimum bid expected by car owner\ntry again");
						flag = 1;
					}
					
					else
					{
						for(int j=0; j<i; j++)
						{
							if(f==list.get(j).bid)
							{
								System.out.println("\n\tSome one has already placed a bid of this amount!");
								System.out.println("\n\tEither enter a higher bid or enter bid value as 0");	
								flag=1;
								break;
							}
						}
					}
				}
					
				}while(flag == 1);
				list.get(i).bid=f;
			}
		
		
			int startIdx = (list.size() / 2) - 1; // Index of last non-leaf node 
			
			for (int i1 = startIdx; i1 >= 0; i1--) 
			{ 
				downAdjust(h, list.size(), i1); 
			} 
		}
	}
	
	void downAdjust(bidder array[], int size, int i) 
	{ 
		int largest = i;    // Initialize current node as largest 
		int left = 2 * i + 1;   // position of left child in array = 2*i + 1 
		int right = 2 * i + 2;   // position of right child in array = 2*i + 2 

		if (left < size && array[left].bid > array[largest].bid)  // If left child is larger than root 
			largest = left; 

		if (right < size && array[right].bid > array[largest].bid) // If right child is larger than largest so far 
			largest = right; 

		if (largest != i) 
		{         // If largest is not root swap it 
			bidder swap = array[i]; 
			array[i] = array[largest]; 
			array[largest] = swap; 

			downAdjust(array, size, largest); // Recursively heapify the sub-tree 
		} 
	} 
	
	void deleteBidder()
	{
		int n = list.size();
		// Get the last element 
	    bidder k = h[n - 1]; 
	  
	    // Replace root with first element 
	    h[0] = k; 
	  
	    // Decrease size of heap by 1 
	    n = n - 1; 
	    
		downAdjust(h, n, 0);
		
	}
	
	void printHeap(bidder arr[], int n) 
	{ 
		if(list.size()>1)
		{
			System.out.println("\n\tBids for this round were: ");
			
			for (int i = 0; i < n; ++i) 
			{
				System.out.println("\n\t\t"+arr[i].name + ": "+arr[i].bid); 
			}
		}
		else
		{
			t=1;
		}
		System.out.println(); 
	} 
	
	bidder maximumBid()		// Stores maximum bid in each round
	{
		if(list.size()==0)
		{
			return null;
		}
		else
		{
		return h[0];
		}
		
	}
}