package Chapter9;

public class AdvanceTicket extends Ticket{
	private double price=0;
	private int day =0;
	private int number =0;
	public AdvanceTicket(int number, int day) {
		super(number);
		this.day=day;
		this.number = number;
	}
	public double getPrice(int day){
		if (day>=10){
			return price =30.0;
		}else{
			return price =40.0;
		}
		
	}
	public String toString(){
		return "Number: " + number+", "+ "Price: "+getPrice(day);
	}
	
}
