import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/*
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Band {

	private ArrayList<Member> memberList = new ArrayList<Member>(); // memberlist != null
	private ArrayList<Event> eventList = new ArrayList<Event>(); // eventList != null
	private ArrayList<Event> deletedEventsList = new ArrayList<Event>(); // deletedEventsList != null
	private ArrayList<Song> songList = new ArrayList<Song>(); // songList != null
	private ArrayList<Location> locationList = new ArrayList<Location>(); // locationList != null
	private ArrayList<Budget> budgetList = new ArrayList<Budget>(); // budgetList  != null

	public Band(){

	}

	//fuegt einen Member zur memberList Liste hinzu
	public void addMember(Member newMember){

		this.memberList.add(newMember);

	}

	//fuegt eine Location zur locationList Liste hinzu
	public void addLocation(Location location){

		this.locationList.add(location);

	}

	//fuegt ein Event zur eventList hinzu und schickt eine Nachricht an die Member des Events
	public void addEvent(Event newEvent){
		
		ArrayList<Member> eventMemberList;
		eventMemberList = newEvent.getMemberList();
		
		for(Member m : eventMemberList){
			
			m.addMessage("New Event - " + newEvent.toString());
			
		}

		this.eventList.add(newEvent);

	}

	//fuegt einen Song zur songList Liste hinzu
	public void addTrack(Song newSong){

		this.songList.add(newSong);

	}

	//gibt einen lesbaren String der Events in der eventList zurueck
	public String showEvents(){
		
		String retString = "";
		
		for(Event e : this.eventList){
			
			retString = retString + e.toString() + "\n";
			
		}
		
		return retString;
		
	}

	//gibt einen lesbaren String der Rehearsals and einem speziellen Tag zurueck
	//BAD: Man koennte eine Methode machen die einfach einen dritten Parameter enthaelt der kennzeichnet,
	//		was fuer ein Event- oder Eventsubtyp betrachtet werden soll. So wuerde man sich alle seperaten
	//		Gig bzw Rehearsal methoden sparen
	public String showRehearsals(Calendar specificDate){

		String retString = "";

		Calendar newCal = Calendar.getInstance();
		newCal.setTime(specificDate.getTime());

		retString = showRehearsals(specificDate, newCal);

		return retString;

	}

	//gibt einen lesbaren String der Rehearsals in einem Zeitraum zurueck
	//BAD: Man koennte eine Methode machen die einfach einen dritten Parameter enthaelt der kennzeichnet,
	//		was fuer ein Event- oder Eventsubtyp betrachtet werden soll. So wuerde man sich alle seperaten
	//		Gig bzw Rehearsal methoden sparen
	public String showRehearsals(Calendar fromDate, Calendar toDate){		
		String retString = "";

		fromDate.add(Calendar.DAY_OF_MONTH, -1); 
		toDate.add(Calendar.DAY_OF_MONTH, 1);

		for(Event r : this.eventList){

			if(r instanceof Rehearsal && (r.getDate().after(fromDate) && r.getDate().before(toDate))) {

				retString = retString + r.toString() + "\n";

			}

		}

		return retString;

	}

	//gibt einen lesbaren String der Gigs zu einem Zeitpunkt zurueck
	//BAD: Man koennte eine Methode machen die einfach einen dritten Parameter enthaelt der kennzeichnet,
	//		was fuer ein Event- oder Eventsubtyp betrachtet werden soll. So wuerde man sich alle seperaten
	//		Gig bzw Rehearsal methoden sparen
	public String showGigs(Calendar specificDate){

		String retString = "";

		retString = showGigs(specificDate, specificDate);

		return retString;

	}

	//gibt einen lesbaren String der Gigs in einem Zeitraum zurueck
	//BAD: Man koennte eine Methode machen die einfach einen dritten Parameter enthaelt der kennzeichnet,
	//		was fuer ein Event- oder Eventsubtyp betrachtet werden soll. So wuerde man sich alle seperaten
	//		Gig bzw Rehearsal methoden sparen
	public String showGigs(Calendar fromDate, Calendar toDate){

		String retString = "";
		fromDate.add(Calendar.DAY_OF_MONTH, -1);
		toDate.add(Calendar.DAY_OF_MONTH, 1);

		for(Event r : this.eventList){

			if(r instanceof Gig && (r.getDate().after(fromDate) && r.getDate().before(toDate))) {

				retString = retString + r.toString() + "\n";

			}

		}

		return retString;

	}

	//gibt einen lesbaren String der Events in einem Zeitraum zurueck
	//BAD: Man koennte eine Methode machen die einfach einen dritten Parameter enthaelt der kennzeichnet,
	//		was fuer ein Event- oder Eventsubtyp betrachtet werden soll. So wuerde man sich alle seperaten
	//		Gig bzw Rehearsal methoden sparen
	public String showEvents(Calendar from, Calendar to){

		String retString = "";
		from.add(Calendar.DAY_OF_MONTH, -1);
		to.add(Calendar.DAY_OF_MONTH, 1);

		for(Event e : this.eventList){

			if(e.getDate().after(from) && e.getDate().before(to)) {

				retString = retString + e.toString() + "\n";

			}

		}

		return retString;

	}

	//gibt einen lesbaren String der Events zu einem Zeitpunkt zurueck
	//BAD: Man koennte eine Methode machen die einfach einen dritten Parameter enthaelt der kennzeichnet,
	//		was fuer ein Event- oder Eventsubtyp betrachtet werden soll. So wuerde man sich alle seperaten
	//		Gig bzw Rehearsal methoden sparen
	public String showMember(Calendar specificDate){

		String retString = "";

		for(Member m : this.memberList){

			if(m.getEntryDate().before(specificDate) && (m.getExitDate().after(specificDate) || m.getExitDate() == null)) {

				retString = retString + m.toString() + "\n";

			}

		}

		return retString;

	}

	//gibt einen lesbaren String der Songs in einem Zeitraum zurueck
	public String showSongs(Calendar fromDate, Calendar toDate){
		String retString = "";
		fromDate.add(Calendar.DAY_OF_MONTH, -1);
		toDate.add(Calendar.DAY_OF_MONTH, 1);
		//BAD: wenn fromDate und toDate das gleiche Objekt sind, wird bei fromDate.add(...) und toDate.add(...) auf das gleiche Objekt zugegriffen
		//entweder zwei verschiedene Objekte übergeben und als Vorbedingung festlegen oder fromDate bzw. toDate clonen
		
		for(Song r : this.songList){

			if(r.getEndDate() == null && (r.getStartDate().after(fromDate) && r.getStartDate().before(toDate))) {

				retString = retString + r.toString() + "\n";

			}
			else if(r.getEndDate() != null && (r.getStartDate().after(fromDate) && r.getEndDate().before(toDate))){
				retString = retString + r.toString() + "\n";
			}

		}

		return retString;

	}


	//gibt eine List von Events zurueck
	 //BAD: überflüssig, wenn getRents(...) und getFees(...) von Budget in Band verschoben wird
	public ArrayList<Event> getEventList()
	{
		return eventList;
	}

	//gibt eine liste der Budges zurueck
	 //BAD: überflüssig, wenn getMisc(...) und getAllMisc(...) von Budget in Band verschoben wird
	public ArrayList<Budget> getBudgetList()
	{
		return budgetList;
	}

	//speichert eine neue version eines Events in die eventList und verschiebt das alte in die 
	//vorversions EventList des neuen Events.
	//newEvent immer != null
	public void updateEvent(Event originalEvent, Event newEvent){
		ArrayList<Event> tmpList = new ArrayList<Event>();
		ArrayList<Member> eventMemberList = new ArrayList<Member>();
		Event oldEvent = null;

		for(Event e : this.eventList){

			if(e == originalEvent){
				eventMemberList = e.getMemberList();
				
				for(Member m : eventMemberList){
					
					m.addMessage("Event Update - Old Event:" + originalEvent.toString() + " || New Event:" + newEvent.toString());
					
				}

				tmpList = e.getPreviousEvents();
				tmpList.add(originalEvent);
				newEvent.setPreviousEvents(tmpList);
				oldEvent = e;
				break;
			}

		}
		
		this.eventList.remove(oldEvent);
		this.eventList.add(newEvent);

	}

	//holt sich eine Vorversion aus der EventList eines UndoEvents und fuegt die Vorversion in die Eventlist des der Band
	//fuegt ausserdem die version des UndoEvents in die Vorversionsliste des neuen Events ein
	//undoEvent immer != null
	//undoLevel < laenge der Vorversionsliste im undoEvent
	public void undoEventChange(Event undoEvent, int undoLevel){

		ArrayList<Event> tmpList;
		ArrayList<Member> eventMemberList;
		Event tmpEvent;

		for(Event e: this.eventList){

			if(e == undoEvent){

				eventMemberList = e.getMemberList();

				tmpList = e.getPreviousEvents();
				tmpEvent = tmpList.get(undoLevel);
				tmpList.remove(undoLevel);
				tmpEvent.setPreviousEvents(tmpList);
				this.eventList.remove(e);
				this.eventList.add(tmpEvent);

				for(Member m : eventMemberList){

					m.addMessage("Event Change Reverted - : " + e.toString());

				}

			}

		}

	}

	//loescht ein Event aus der EventList und fuegt es in die deletedEventList hinzu
	public void deleteEvent(Event eventToDelete){
		ArrayList<Member> eventMemberList;
		if(this.eventList.contains(eventToDelete)){
			
			this.eventList.remove(eventToDelete);
			this.deletedEventsList.add(eventToDelete);
			
			eventMemberList = eventToDelete.getMemberList();
			
			for(Member m : eventMemberList){
				
				m.addMessage("Deleted Event - " + eventToDelete.toString());
				
			}
			
		}

	}

	//holt sich ein spezifiziertes Event aus der deletedEventList und fuegt es zur aktuellen EventList hinzu und loescht es aus der deltedEventList
	//eventToRecover immer != null
	public void undeleteEvent(Event eventToRecover){
		
		ArrayList<Member> eventMemberList;

		if(this.deletedEventsList.contains(eventToRecover)){
			
			this.deletedEventsList.remove(eventToRecover);
			this.eventList.add(eventToRecover);
			
			eventMemberList = eventToRecover.getMemberList();
			
			for(Member m : eventMemberList){
				
				m.addMessage("Deleted Event - " + eventToRecover.toString());
				
			}
			
		}

	}

	//Sucht anhand einer einer Liste von benoetigten Infrastrukturen nach einer passenden Location und gibt diese 
	//	als lesbare String Repraesentation zurueck
	public String searchForInfrastracture(ArrayList<String> listOfNeededThings){
		String stringOfGoodLocations = "";

		if(listOfNeededThings == null){
			stringOfGoodLocations = "Every Location is acceptable";
		}

		for(Location l: this.locationList){
			if(l.neededInfrastructure(listOfNeededThings) == true){
				stringOfGoodLocations += l.toString() + "\n";
			}
		}

		return stringOfGoodLocations;
	}
	
	
	//fuegt ein neues Budget Objekt zur budgetList hinzu
	public void addBudget(String name, int value)
	{
		budgetList.add(new Budget(name,value));	
	}
}
