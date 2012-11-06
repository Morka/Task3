import java.util.Calendar;

public class Message
{
	String message;
	Calendar date; // always <= curent Date
	
	//Nachbdingung: Message ist vollständig initialisiert
	public Message(String message)
	{
		this.message = message;
		date = Calendar.getInstance();
	}
	
	//Nachbedingung: gibt Inhalt der Message zurück
	public String toString()
	{
		return message;	
	}
}