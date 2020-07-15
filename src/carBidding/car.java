package carBidding;

public class car 
{
	String name;	//stores owner's name
	String licPNo;	//stores license plate number of the car
	float originalCost;	//stores original cost of the car
	float minBid;	//minimum bid expected by the owner
	String brand;
	String modelName;	//stores model name of the car
	float soldprice;
	String buyer;
	car next;
	boolean sold;		//sold flag to check if a car is sold or not
	
	public car(String n, String ln, String br, String mn, float cp, float minb) 
	{
		name = n;
		licPNo = ln;
		brand=br;
		modelName=mn;
		originalCost = cp;
		minBid = minb;
		soldprice=0;
		buyer="";
		sold = false;
	}
	
	car()
	{
		next=null;
	}
}