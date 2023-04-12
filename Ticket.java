package Chapter9;

public class Ticket {
	private int number =0;
	public Ticket(int number){
		this.number = number;
	}
	public double getPrice(){
		return 50.0;
	}
	public String toString(){
		return "Number: " + number+", "+ "Price: "+getPrice();
	}
	
}
