import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Gig extends Event{
	
	//fee darf nicht kleiner 0 sein
	private int fee;
	
	//Vorbedingung: fee >= 0
	public Gig(int duration, Location location, Calendar date, int fee, ArrayList<Member> member){
		super(duration, location, date, member);
		
		this.fee = fee;
	}
	
	
	//Nachbedingung: liefert integer der fee beinhaltet >= 0 ist
	public int getFee(){
		return fee;
	}
	
	
	//Vorbedingugn: other.fee >= 0
	//Nachbedingung: this.fee ist auf other.fee gesetzt
	public void setFee(int fee){
		this.fee = fee;
	}
	
	//Nachbedingung: liefert einen lesbaren String des Objektes zurueck
	public String toString(){
		return super.toString() + ", Fee: " + fee;
	}
}
