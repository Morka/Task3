import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Rehearsal extends Event{
	
	private int rent;

	public Rehearsal(int duration, Location location, Calendar date, int rent, ArrayList<Member> member){
		super(duration, location, date, member);
		
		this.rent = rent;
	}
	
	 
	public void setRent(int rent){
		this.rent = rent;
	}
	
	/**
	 * gives back rent
	 *
	 * @return integer that contains the rent
	 */
	
	public int getRent(){
		return rent;
	}
	
	public String toString(){
		return super.toString() + ", Rent: " + rent;
	}
}
