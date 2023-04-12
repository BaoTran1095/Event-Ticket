package Chapter9;

public class StudentAdvanceTicket extends AdvanceTicket{
	private int number =0;
	private int day=0;
	private double price = 0;
	public StudentAdvanceTicket(int number, int day) {
		super(number, day);
		this.day = day;
		this.number = number;
		// TODO Auto-generated constructor stub
	}
	public double getPrice(int day){
		if (day>=10){
			return price =15.0;
		}else
			return price = 20.0;
	}
	
	public String toString(){
		return "Number: " + number+", "+ "Price: "+getPrice(day) +" (ID required)";
	}
}
