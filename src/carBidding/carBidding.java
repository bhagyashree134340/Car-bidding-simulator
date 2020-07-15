package carBidding;

import java.util.ArrayList;
import java.util.Scanner;


public class carBidding 
{
	public carBidding() 
	{

	}
	
	public static void main(String[] args) 
	{

		cars cs=new cars();		//object for cars class
		biddingPlatform b = new biddingPlatform();
		
		Scanner sc =new Scanner(System.in);
		
		int ch, ch2;
		char ch1;
		int nc=0;			//no. of cars registered
		car c;
		int i = 0;
		
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t!!!!WELCOME TO BID-CAPITAL!!!!");
		System.out.println();
		System.out.println();
		
		do
		{
			System.out.println("MAIN MENU");
			
			System.out.println("\nENTER -");
			System.out.print("A - REGISTER"
							+ "\nB - JOIN AUCTION"
							+ "\nC - DISPLAY LIST OF ALL THE CARS SOLD/UNSOLD"
							+ "\nD - EXIT \n");	
			ch1 = sc.next().charAt(0);
			System.out.println();
			
			switch(ch1)
			{
				case 'a':
				case 'A':
					do
					{
						System.out.println("\n\tENTER - ");
						System.out.print("\n\t1 - TO SELL A CAR"
								+ "\n\t2 - TO BID ON A CAR"
								+ "\n\t0 - BACK TO MAIN MENU \n\t");
						ch=sc.nextInt();
						System.out.println();
						
						switch(ch)
						{
							
							case 1:
								
								do
								{
									System.out.println("\n\t\tENTER - ");
									System.out.print("\n\t\t0 - BACK\n\t\t1 - MAKE AN ENTRY OF THE CAR  \n\t\t2 - DELETE AN ENTRY \n\t\t3 - DISPLAY ALL ENTRIES \n\t\t4 - SEARCH AN ENTRY \n\t\t");
									ch2 = sc.nextInt();
									System.out.println();
									
									switch(ch2)
									{
										case 1:
											
											nc++;
											System.out.println("\t\t-----------------------------");
											cs.insert();
											System.out.println("\t\t-----------------------------");
											System.out.println("\n\t\tTHANK-YOU!");
											
											break;
											
										case 2:
											
											String num;
											
											System.out.print("\n\t\tEnter license plate number of the car to delete the entry: \n\t");
											num = sc.next();
											System.out.println();
											
											cs.delete(num);
											
											break;
											
										case 3:
											
											System.out.println("\n\t\tResults of all cars: ");
											System.out.println("\t\t-----------------------------");
											cs.displayAll();
											
											break;
											
										case 4:
											
											String num1;
											
											System.out.print("\n\t\tEnter license plate number of the car to search the entry: \n\t\t");
											num1 = sc.next();
											System.out.println();
											
											cs.search(num1);
											
											break;
									}
								}while(ch2 != 0);
								
								break;
								
							case 2:
													//Accept details of bidder
								int ch3 = 0;
								
								do
								{
									System.out.println("\n\t\tENTER - ");
									System.out.print("\n\t\t0 - BACK\n\t\t1 - MAKE AN ENTRY AS A BIDDER \n\t\t");
									ch3 = sc.nextInt();
									
									switch(ch3)
									{
										case 1:
											
																//Accept details of bidder
											b.create();
											System.out.println("\n\t\tTHANK-YOU!");
											
											break;
									}
								}while(ch3 != 0);
								
								break;
						}
					}while(ch!=0);
					
					break;
					
				case 'b':
				case 'B':
					
					if(i<nc)
					{
						System.out.println("\n\tLET'S BEGIN WITH THE BID ROUNDS! GET YOUR BIDS IN!");
						
						System.out.println("\n\tCAR NUMBER -->"+((i++)+1));
						System.out.println("\t-----------------------------");
						c=cs.select();
						cs.display(c);
						
						System.out.println("\n\tEligible Bidders: ");
						System.out.println("\t-----------------------------");
						
						b.waitingList(b.root, c.minBid);
						
						b.r=0;
						b.t=0;
						
						for(int j=0 ; j<3; j++)
						{
							if((b.r==0)&&(b.t==0))
							{
								b.bidPriorityQue(c);
								b.rounds(c);
							}
						}
						
						
						if((b.r==0))
						{
							b.sellCar(b.maximumBid(), c);
							c.sold = true;

						}
						
						if(b.t==1)
						{
							System.out.println("");
							c.sold=true;
						}
						
						b.list=new ArrayList<bidder>(5);
					}
					else
					{
						System.out.println("\n\tNo cars to bid on!");
					}
					
					break;
					
				case 'c':
				case 'C':
					
					System.out.println("\n\t\tResults of all cars: ");
					System.out.println("\t\t-----------------------------");
					
					cs.displayAll();
					
					break;	
			}
		
		}while(ch1 != 'd');
		
		System.out.println("THANKYOU!");
		
	}
}