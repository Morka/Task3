import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Rehearsal extends Event{

	//rent darf nicht kleiner 0 sein
	private int rent;

	//Vorbedingung: rent >= 0

	public Rehearsal(int duration, Location location, Calendar date, int rent, ArrayList<Member> member){
		super(duration, location, date, member);
		
		this.rent = rent;
	}
	
	
	//Vorbedingugn: other.rent >= 0
	//Nachbedingung: this.rent ist auf other.rent gesetzt	
	public void setRent(int rent){
		this.rent = rent;
	}
	
	
	//Nachbedingung: liefert integer der rent beinhaltet >= 0 ist
	public int getRent(){
		return rent;
	}

	//Nachbedingung: liefert einen lesbaren String des Objektes zurueck
	public String toString(){
		return super.toString() + ", Rent: " + rent;
	}
}
