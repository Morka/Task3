import java.util.Calendar;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Song
{
	//GOOD: Klassenzusammenhalt
	//Attribute sind alle private und abrufbar, lediglich das Enddatum (end) kann verändert werden
	private String name;  	
	private int length; 	//length in seconds, always positiv and > 0
	private Calendar start;	//Date of first appearence in repertoire, start <= current Date
	private Calendar end;	//last Date of the song in repertoire, can be NULL
	
	public Song(String name, int length)
	{
		this.name = name;
		this.length = length;
		this.start = Calendar.getInstance(); 
		this.end = null;
	}
	
	/** NOTE
	 * sets "end" date
	 *
	 * @param date 
	 *
	 * @return Calendar
	 */
	public void setDate(Calendar date)
	{
		this.end = date;
	}
	
	/** NOTE
	 * gives back the "start" date
	 *
	 * @param 
	 *
	 * @return Calendar containing the start date
	 */
	public Calendar getStartDate()
	{
		return start;
	}
	
	/** NOTE
	 * gives back the "end" date
	 *
	 * @param 
	 *
	 * @return Calendar containing the end date
	 */
	public Calendar getEndDate()
	{
		return end;
	}
	
	/** NOTE
	 * gives back the "name" of the Song
	 *
	 * @param 
	 *
	 * @return String which contains the name
	 */
	public String getName()
	{
		return name;
	}
	
	/** NOTE
	 * gives back the "length" of the Song
	 *
	 * @param 
	 *
	 * @return integer containing the length
	 */
	public int getLength()
	{
		return length;
	}	
	
	public String toString()
	{
		return "name: " + name + ", length: " + length;
	}
}


