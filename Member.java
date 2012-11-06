import java.util.Calendar;
import java.util.ArrayList;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Member {
	
	private String name, telNr, instrument;
	private Calendar enteringDate, exitDate;
	private ArrayList<Song> songList;
	private ArrayList<Message> messageList;
	
	//Nachbedingung: speichert membername, telNumber und instrument in entsprechenden variablen und erzeugt instanzen von songList und messageList
	public Member(String memberName, String telNumber, String instrument){
		
		this.name = memberName;
		this.telNr = telNumber;
		this.instrument = instrument;
		this.enteringDate = Calendar.getInstance();
		this.songList = new ArrayList<Song>();
		this.messageList =  new ArrayList<Message>();
	}

	//Nachbedingung: setzt ein exitDate
	public void memberExit(){
		
		this.exitDate = Calendar.getInstance();
		
	}
	
	//Nachbedingung: gibt ein enteringDate zurueck
	public Calendar getEntryDate(){
		
		return this.enteringDate;
		
	}

	//Nachbedingung: gibt ein exitDate zurueck
	public Calendar getExitDate(){
		
		return this.exitDate;
		
	}

	//Vorbedingung: song != null
	//Nachbedingung: speichert einen neuen Song in der songList
	public void addSongToList(Song song){
		songList.add(song);
	}

	//Nachbedingung: liefert die songListe des Objektes zurueck
	public ArrayList<Song> getSongsList(){
		return songList;
	}

	//Vorbedingung: message != null
	//Nachbedingung: fuegt eine message zur messageList hinzu
	public void addMessage(String message){
		messageList.add(new Message(message));
	}
	
	//Nachbedingung: liefert eine lesbare String Repraesentation der messageList zurueck
	public String getMessages()
	{
		String messages = "";
		
		for(Message s : messageList){
			messages += s.toString() + "\n";
		}
		
		return messages;
	}
		
	//Nachbedingung: liefert eine lesbare String Repraesentation der songList zurueck
	public String getSongsString(){
		String songs = "";
		
		for(Song s : songList){
			songs += s.toString() + "\n";
		}
		
		return songs;
	}
	
	//Nachbedingung: liefert einen lesbare String des Objektes zurueck
	public String toString(){
		return "Name: " + name + ", Instrument: " + instrument;
	}
	
	//Nachbedingung: gibt den name des Objektes zurueck
	public String getName()
	{
		return name;
	}

}
