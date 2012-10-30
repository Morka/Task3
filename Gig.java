import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Gig extends Event{
	
	private int fee;
	
	public Gig(int duration, Location location, Calendar date, int fee, ArrayList<Member> member){
		super(duration, location, date, member);
		
		this.fee = fee;
	}
	
	/**
	 * Gives back the "fee" of the Gig
	 *
	 * @param  
	 *
	 * @return integer which contains the fee
	 */
	
	public int getFee(){
		return fee;
	}
	
	/**
	 * sets a Fee
	 *
	 * @param fee integer which specifies the fee
	 *
	 */
	
	public void setFee(int fee){
		this.fee = fee;
	}
	
	public String toString(){
		return super.toString() + ", Fee: " + fee;
	}
}
