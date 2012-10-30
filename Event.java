import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Event{
	
	private int duration;
	private Location location;
	private Calendar date;
	private ArrayList<Member> member;
	private ArrayList<Event> prevEvents;
	private ArrayList<Message> eventMessages;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	//setzt bzw erzeugt alle noetigen Variablen des Objektes 
	//location, date und member immer != null
	public Event(int duration, Location location, Calendar date, ArrayList<Member> member){
		this.duration = duration;
		this.location = location;
		this.date = date;
		this.member = new ArrayList<Member>(member);
		this.prevEvents = new ArrayList<Event>();
		this.eventMessages = new ArrayList<Message>();
	}
	
	//liefert location zurueck
	public Location getLocation(){
		return location;
	}
	
	//liefert duration zurueck
	public int getDuration(){
		return duration;
	}
	
	//setzt das date des Objektes
	//date immer != null
	public void setDate(Calendar date){
		this.date = date;
	}	
	
	//liefert den aktuellen Wert von date zurueck
	public Calendar getDate(){
		return date;
	}
	
	//liefert die list der member zurueck
	public ArrayList<Member> getMemberList(){
		
		return this.member;
		
	}
	/*
	Die ArrayList "member" muss mindestens einen Member enthalten - Dies wird nirgends ueberprueft!
	
	Das ergebnis ist ein String, der entweder aussagt, dass keine Stücke gemeinsam gespielt werden können, oder die String mit
	den Namen der Stücke getrennt durch ein newline
	*/
	
	public String getStringOfSongsPlayable(){
		String playableSongs = "";
			
		Member theOne = member.get(0); //member must not be null!
		
		ArrayList<Song> pSongs = new ArrayList<Song>(theOne.getSongsList());
		
		
		for(int m = 1; m < member.size(); m++){
			if(member.get(m) == null){
				return theOne.getSongsString();
			}
			for(int s = 0; s < pSongs.size(); s++){
				if(!member.get(m).getSongsList().contains(pSongs.get(s))){
					pSongs.remove(s);	
				}
			}
		}
		for(Song s : pSongs){
			playableSongs += s.toString() + "\n";
		}
		if(playableSongs == ""){
			return "No Songs Playable\n";
		}
		
		return playableSongs;
	}
	/*
	Die ArrayList "member" muss mindestens einen Member enthalten - Dies wird nirgends Uebeprueft
	
	es wird eine arraylist mit songs zurueckgegeben.
	*/
	
	public ArrayList<Song> getListOfSongsPlayable(){
			
		Member theOne = member.get(0); //member must not be null!
		
		ArrayList<Song> pSongs = new ArrayList<Song>(theOne.getSongsList());
		
		
		for(int m = 1; m < member.size(); m++){
			if(member.get(m) == null){
				return theOne.getSongsList();
			}
			for(int s = 0; s < pSongs.size(); s++){
				if(!member.get(m).getSongsList().contains(pSongs.get(s))){
					pSongs.remove(s);	
				}
			}
		}
		
		return pSongs;
	}
	
	//setzt prevEvents auf eine Liste von Events
	//eventList immer != null
	public void setPreviousEvents(ArrayList<Event> eventList){
		
		this.prevEvents = eventList;
		
	}

	//liefert den Inhalt von prevEvents zurueck
	public ArrayList<Event> getPreviousEvents(){
		
		return this.prevEvents;
		
	}
	
	//liefert einen lesbaren String des Objektes zurueck
	public String toString(){
		return "Location: " + location.toString() + ", Duration: " + duration + ", Date: " + dateFormat.format(date.getTime());
	}

	//fuegt eine neue EventMessage zur eventMessages Liste hinzu
	public void declineEvent(String message, Member member)
	{
		eventMessages.add(new EventMessage(message, member, State.DECLINE));
	}

	//fuegt eine neue EventMessage zur eventMessages Liste hinzu
	public void acceptEvent(String message, Member member)
	{
		eventMessages.add(new EventMessage(message, member,  State.ACCEPT));
	}	
	
	//gibt einen lesbaren String der eventMessages Liste zurueck
	public String getMessages()
	{
		String messages = "";
		
		for(Message s : eventMessages){
			messages += s.toString() + "\n";
		}
		
		return messages;
	}
	
}
