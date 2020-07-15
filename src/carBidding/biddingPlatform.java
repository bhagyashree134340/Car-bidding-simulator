package carBidding;

//import java.util.ArrayList;

public class biddingPlatform extends bidding
{
	int r;			//for validating when all bidders enter their bid as 0
	public biddingPlatform() 
	{
		r=0;
	}
	
	void rounds(car c)
	{
	//	char ch;
		
		bidder maxBidder = maximumBid();
		
		printHeap(h, list.size());
		
		if((maxBidder!=null)&&(maxBidder.bid==0))
		{
			if(list.size()==0)
			{
				
			}
			else
			{
			r=1;
			round=1;
			System.out.println("\n\tCar sold to no one since all entered their bids as 0");
			}
		}
		
		/*System.out.println("continue rounds? (y/n)");
		
		if(sc.next().charAt(0) == 'y')
		{
			bidPriorityQue(c);
		}
		else
		{
			sellCar(maxBidder,c);
			deleteBidder();
			printHeap(h, list.size()-1);
		}*/
		
		
	}
	
	void sellCar(bidder maxBidder, car c)
	{
		/*System.out.println(maxBidder.bid);
		System.out.println(maximumBid().bid);*/
		System.out.println("\t-----------------------------");
		if(t==0)
		{
			if(maxBidder.bid >= maximumBid().bid)
			{
				System.out.println("\n\tCar is sold to: " +maxBidder.name);
				maxBidder.budget=maxBidder.budget-maxBidder.bid;
				System.out.println("\n\tRemaining budget: "+maxBidder.budget);
				c.buyer=maxBidder.name;
				c.soldprice=maxBidder.bid;
			}
			else
			{
				System.out.println("\n\tCar is sold to: " +maximumBid().name);
				maximumBid().budget=maximumBid().budget-maximumBid().bid;
				System.out.println("\n\tRemaining budget: "+maximumBid().budget);
	
				c.buyer=maximumBid().name;
				c.soldprice=maximumBid().bid;
			}
		}
		else if(maximumBid()==null)
		{
			
		}
		else
		{
			System.out.println("\t-----------------------------");
			System.out.println("\n\tCar is sold to: " +maximumBid().name);
			maximumBid().budget=maximumBid().budget-maximumBid().bid;
			System.out.println("\n\tRemaining budget: "+maximumBid().budget);

			c.buyer=maximumBid().name;
			c.soldprice=maximumBid().bid;
		}
		round=1;
		h=null;
		
		System.out.println("\t-----------------------------");
		
	}

}