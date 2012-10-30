import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Rehearsal extends Event{
	
	/*
	Invariante: rent darf nicht kleiner 0 sein
	*/
	
	private int rent;

	public Rehearsal(int duration, Location location, Calendar date, int rent, ArrayList<Member> member){
		super(duration, location, date, member);
		
		this.rent = rent;
	}
	
	/*
	Vorbedingung: other.rent muss groe§er 0 sein
	*/
	 
	public void setRent(int rent){
		this.rent = rent;
	}
	
	/*
	Nachbedingung: rent ist immer groe§er 0
	*/
	
	public int getRent(){
		return rent;
	}
	
	public String toString(){
		return super.toString() + ", Rent: " + rent;
	}
}
