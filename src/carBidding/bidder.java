package carBidding;

public class bidder 
{
	String name;		// stores name of the bidder
	float budget;		// stores budget of the bidder
    bidder left, right;
    float bid;
    
	public bidder(String name, float budget) 
	{
		this.name = name;
		this.budget = budget;
	}
	
	bidder()
	{
		
	}
	
	public void display()
	{
		System.out.println("\n\tName:"+name);
		System.out.println("\tBudget remanining:"+budget);
		System.out.println("\t-----------------------------");
	}
}