import java.util.Calendar;

public class Message
{
	String message;
	Calendar date; // always <= curent Date
	
	public Message(String message)
	{
		this.message = message;
		date = Calendar.getInstance();
	}
	
	public String toString()
	{
		return message;	
	}
}