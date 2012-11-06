import java.util.Calendar;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Song
{
	//GOOD: Klassenzusammenhalt
	//Attribute sind alle private und abrufbar, lediglich das Enddatum (end) kann ver�ndert werden
	private String name;  	
	private int length; 	//length in seconds, always positiv and > 0
	private Calendar start;	//Date of first appearence in repertoire, start <= current Date
	private Calendar end;	//last Date of the song in repertoire, can be NULL
	
	
	//Nachbedingung: Song ist vollständig initialisiert
	public Song(String name, int length)
	{
		this.name = name;
		this.length = length;
		this.start = Calendar.getInstance(); 
		this.end = null;
	}
	
	/** 
	 * Nachbedingung: sets "end" date
	 *
	 * @param date
	 *
	 * @return Calendar
	 */
	public void setDate(Calendar date)
	{
		this.end = date;
	}
	
	/** 
	 * Nachbedingung: gives back the "start" date
	 *
	 * @return Calendar containing the start date
	 */
	public Calendar getStartDate()
	{
		return start;
	}
	
	/** 
	 * Nachbedingung: gives back the "end" date
	 *
	 * @return Calendar containing the end date
	 */
	public Calendar getEndDate()
	{
		return end;
	}
	
	/** 
	 * Nachbedingung: gives back the "name" of the Song
	 *
	 * @return String which contains the name
	 */
	public String getName()
	{
		return name;
	}
	
	/** 
	 * Nachbedingung: gives back the "length" of the Song
	 *
	 * @return integer containing the length
	 */
	public int getLength()
	{
		return length;
	}	
	
	/** 
	 * Nachbedingung: gives back String of name and length
	 *
	 * @return String containing name and length
	 */
	public String toString()
	{
		return "name: " + name + ", length: " + length;
	}
}


