package Chapter9;

public class WalkupTicket extends Ticket {
	private int number=0;
	public WalkupTicket(int number) {
		super(number);
		this.number = number;
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return "Number: " + number+", "+ "Price: "+getPrice();
	}
}
