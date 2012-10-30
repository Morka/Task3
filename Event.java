import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Event{
	
	private int duration; //duration of the Event
	private Location location; //location of the Event
	private Calendar date; //date AND time of the Event
	private ArrayList<Member> member; //member who are playing at this Event
	private ArrayList<Event> prevEvents;
	private ArrayList<Message> eventMessages;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	
	public Event(int duration, Location location, Calendar date, ArrayList<Member> member){
		this.duration = duration;
		this.location = location;
		this.date = date;
		this.member = new ArrayList<Member>(member);
		this.prevEvents = new ArrayList<Event>();
		this.eventMessages = new ArrayList<Message>();
	}
	
	public Location getLocation(){
		return location;
	}
	
	
	public int getDuration(){
		return duration;
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}	
	
	public Calendar getDate(){
		return date;
	}
	
	/**
	 * Returns the list of the current member for this Event
	 * 
	 * @return	a ArrayList<Member> of members of the events
	 */
	
	public ArrayList<Member> getMemberList(){
		
		return this.member;
		
	}
	
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
	/**
	 * Sets an ArrayList<Event> that contains the previous versions of the events.
	 * @param	eventList	an arraylist with the previous states of this event.
	 */
	public void setPreviousEvents(ArrayList<Event> eventList){
		
		this.prevEvents = eventList;
		
	}
	
	/**
	 * Retrieves the ArrayList<Event> that contains the previous versions of the events.
	 * @return		ArrayList<Event> with previous events
	 */
	public ArrayList<Event> getPreviousEvents(){
		
		return this.prevEvents;
		
	}
	
	public String toString(){
		return "Location: " + location.toString() + ", Duration: " + duration + ", Date: " + dateFormat.format(date.getTime());
	}
	
	/**
	 * decline Event
	 */
	public void declineEvent(String message, Member member)
	{
		eventMessages.add(new EventMessage(message, member, State.DECLINE));
	}

	/**
	 * accept Event
	 */
	public void acceptEvent(String message, Member member)
	{
		eventMessages.add(new EventMessage(message, member,  State.ACCEPT));
	}	
	
	public String getMessages()
	{
		String messages = "";
		
		for(Message s : eventMessages){
			messages += s.toString() + "\n";
		}
		
		return messages;
	}
	
}
