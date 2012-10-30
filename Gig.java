import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Gig extends Event{
	/*
	Invariante: fee darf nicht kleiner 0 sein
	*/
	private int fee;
	
	public Gig(int duration, Location location, Calendar date, int fee, ArrayList<Member> member){
		super(duration, location, date, member);
		
		this.fee = fee;
	}
	
	/*
	Nachbedingung: fee darf nicht kleiner 0 sein
	*/
	public int getFee(){
		return fee;
	}
	
	/*
	Vorbedingung: other.fee darf nicht kleiner 0 sein
	*/
	public void setFee(int fee){
		this.fee = fee;
	}
	
	public String toString(){
		return super.toString() + ", Fee: " + fee;
	}
}
