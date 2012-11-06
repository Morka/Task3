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

	//Nachbedingung: setzt bzw erzeugt alle noetigen Variablen des Objektes 
	//Vorbedingung: location, date und member immer != null
	public Event(int duration, Location location, Calendar date, ArrayList<Member> member){
		this.duration = duration;
		this.location = location;
		this.date = date;
		this.member = new ArrayList<Member>(member);
		this.prevEvents = new ArrayList<Event>();
		this.eventMessages = new ArrayList<Message>();
	}
	
	//Nachbedingung: liefert location zurueck
	public Location getLocation(){
		return location;
	}
	
	//Nachbedingung: liefert duration zurueck
	public int getDuration(){
		return duration;
	}
	
	//Nachbedingung: this.date ist auf date gesetzt
	//Vorbedingung: date != null
	public void setDate(Calendar date){
		this.date = date;
	}	
	
	//Nachbedingung: liefert den aktuellen Wert von date zurueck
	public Calendar getDate(){
		return date;
	}
	
	//Nachbedingung: liste von Member wird zurueckgegeben
	public ArrayList<Member> getMemberList(){
		
		return this.member;
		
	}
	
	//Vorbedingung: member != null
	//Vorbedingung wird nicht ueberprueft!
	//Nachbedingung: liefert String mit allen spielbaren Songs, oder "No Songs Playable"
	
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
	//Vorbedingung: member != null
	//Vorbedingung wird nicht ueberprueft!
	//Nachbedingung: liefert liste mit spielbaren songs oder null zurueck
	
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
	
	//Nachbedingung: eventList zu prevEvents hinzugefuegt
	//Vorbedingung: eventList != null
	public void setPreviousEvents(ArrayList<Event> eventList){
		
		this.prevEvents = eventList;
		
	}

	//Nachbedingung: prevEvents wird zurueckgegeben
	public ArrayList<Event> getPreviousEvents(){
		
		return this.prevEvents;
		
	}
	
	//Nachbedingung: liefert einen lesbaren String des Objektes zurueck
	public String toString(){
		return "Location: " + location.toString() + ", Duration: " + duration + ", Date: " + dateFormat.format(date.getTime());
	}
	//Vorbedingung: message != null, member != null
	//Nachbedingung: eine Neue EventMessage in eventMessages aufgenommen. Abgelehnt.
	public void declineEvent(String message, Member member)
	{
		eventMessages.add(new EventMessage(message, member, State.DECLINE));
	}
	
	//Vorbedingung: message != null, member != null
	//Nachbedingung: eine Neue EventMessage in eventMessages aufgenommen. Angenommen.
	public void acceptEvent(String message, Member member)
	{
		eventMessages.add(new EventMessage(message, member,  State.ACCEPT));
	}	
	
	//Nachbedingung: gibt einen lesbaren String der eventMessages Liste zurueck
	public String getMessages()
	{
		String messages = "";
		
		for(Message s : eventMessages){
			messages += s.toString() + "\n";
		}
		
		return messages;
	}
	
}
