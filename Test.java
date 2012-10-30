import java.util.ArrayList;

//Wir haben deshalb wahrscheinlich nicht allzuviele 'Good'-Stellen weil wir aufgrund von Zeitdruck die meisten Funktionen innerhalb von Band.java realisiert haben. 
//Durch staerkere Faktorisierung und Aufgabenteilung sowie zusaetzlichen Klassen(zb EventManager, usw) wuerde man Funktionen eher aus Band.java verdraengen koennen
//und somit eine schwaechere Objektkopplung erhalten.

import java.util.Calendar;

public class Test{
	public static void main(String[] args){
		Calendar date = Calendar.getInstance();
		
		Band band = new Band();

		Location location1 = new Location("WUK");
		Location location2 = new Location("Arena");
		Location location3 = new Location("Posthof");
		Location location4 = new Location("Wiesen");
		
		band.addLocation(location1);
		band.addLocation(location2);
		band.addLocation(location3);
		band.addLocation(location4);

		location1.addDescription("Food", "There is a catering");
		location1.addDescription("Equipment", "Nice Equipment is provided");
		location2.addDescription("FoOd", "Lots of delicious food!");
		location2.addDescription("EQUIPMENT", "Pew Pew");
		location3.addDescription("FOOD", "Perfect");
		location3.addDescription("eqipment", "shitty"); //intentional Typo!
		location4.addDescription("Food", "wonderful service");
		location4.addDescription("Equipment", "nice microfones");
		location4.addDescription("Free Beer", "");
		
		ArrayList<String> toBeFound = new ArrayList<String>();
		toBeFound.add("Food");
		toBeFound.add("Equipment");
		
		/**
		 * anticipated output: "WUK"
		 					   "Arena"
		 					   "Wiesen"
		 */
		System.out.println("Which Locations suits better?");
		System.out.println(band.searchForInfrastracture(toBeFound));
		
		Song song1 = new Song("With", 132);
		Song song2 = new Song("a little", 212);
		Song song3 = new Song("Help", 21);
		
		band.addTrack(song1);
		band.addTrack(song2);
		band.addTrack(song3);
		
		Member member1 = new Member("John", "13221221", "Guitar");
		Member member2 = new Member("Paul", "13221221", "Bass Guitar");
		Member member3 = new Member("George", "13221223", "Guitar");
		Member member4 = new Member("Ringo", "13221224", "Drums");
		
		band.addMember(member1);
		band.addMember(member2);
		band.addMember(member3);
		band.addMember(member4);
		
		ArrayList<Member> memberList1 = new ArrayList<Member>();
		memberList1.add(member1);
		memberList1.add(member2);
		memberList1.add(member3);
		
		member1.addSongToList(song1);
		member1.addSongToList(song2);
		member1.addSongToList(song3);
		
		member2.addSongToList(song2);
		member2.addSongToList(song3);
		
		member3.addSongToList(song3);
		
		Gig gig1 = new Gig(2500, location1, date, 2000000, memberList1);
		Gig gig2 = new Gig(200, location2, date, 100000, memberList1);
		Rehearsal reh1 = new Rehearsal(90, location3, date, 50, memberList1);
		
		/* 
		 * THis should test if the programm "knows" which songs are playable
		 * due to band members skills at gig1. All members know song 3
		 *
		 * Anticipated Output: "name: Help, length 21"
		 */
		System.out.println("Songs that are playable gig1");
		System.out.println(gig1.getStringOfSongsPlayable());
		
		/**
		 * The Members of "memberList2" do not have a song which they can play together
		 *
		 */
		ArrayList<Member> memberList2 = new ArrayList<Member>(memberList1);
		
		member4.addSongToList(song2);
		member4.addSongToList(song1);
		memberList2.add(member4);
		
		Gig gig3 = new Gig(2331, location2, date, 2993, memberList2);
		/*
		 * Anticipated Output: "No Songs Playable"
		 */
		
		System.out.println("Songs that are playable Gig3");
		System.out.println(gig3.getStringOfSongsPlayable());
		
		
		band.addBudget("Drums",-600);
		band.addBudget("Free Beer", 50);
		
		member1.addMessage("Hallo, wie geht es dir?");
		member2.addMessage("Danke, gut. Und dir?");
		member1.addMessage("Danke, mir auch");
		
		gig1.acceptEvent("termin ist perfekt", member1);
		gig1.declineEvent("habe keine zeit", member2);

		band.addEvent(gig1);
		band.addEvent(gig2);
		band.addEvent(reh1);
		
		System.out.println("Aktuelle Events:");
		System.out.println(band.showEvents());
		
		Gig newGig = new Gig(2000, location2, date, 2000000, memberList1);
		band.updateEvent(gig1, newGig);
		System.out.println("Geaenderte Events:");
		System.out.println(band.showEvents());
		
		band.undoEventChange(newGig, 0);
		System.out.println("Rueckgaengiggemachte Eventaenderung:");
		System.out.println(band.showEvents());
		System.out.println("Events nach loeschen:");
		band.deleteEvent(gig1);
		System.out.println(band.showEvents());
		System.out.println("Events nach recovery:");
		band.undeleteEvent(gig1);

		
		System.out.println("Summe Fees:");
		System.out.println(Budget.getFees(band.getEventList(),date,date));
		System.out.println("Summe Rents:");
		System.out.println(Budget.getRents(band.getEventList(),date,date));
		System.out.println("Summe Sonstige Ein/Ausgaben:");
		System.out.println(Budget.getAllMisc(band.getBudgetList(),date,date));
		System.out.println("Summe Ein/Ausgaben fuer Kategorie Drums:");
		System.out.println(Budget.getMisc(band.getBudgetList(),"Drums",date,date));
		System.out.println("Summe Ein/Ausgaben fuer Kategorie Free Beer:");
		System.out.println(Budget.getMisc(band.getBudgetList(),"Free Beer",date,date));
	}
}
