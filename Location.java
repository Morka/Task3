import java.util.HashMap;
import java.util.ArrayList;

public class Location{
	
	private final String name;
	
	private HashMap<String, String> placeDescriptions; 
	
	public Location(String name){
		this.name = name;
		placeDescriptions = new HashMap<String, String>();
	}
	
	public String getName(){
		return name;
	}
	
	
	/*
	nameOfDescription darf nicht null sein
	placeDescriptions enthaelt die nameOfDescription in kleinbuchstaben
				-> keine unterscheidung der klein-gro§ schreibweise
	
	*/
	//Vorbedingung: nameOfDescription != null
	//Nachbedingung: placeDescriptions enthaelt die nameOfDescription in kleinbuchstaben
	//				-> keine unterscheidung der klein-gro§ schreibweise
	public void addDescription(String nameOfDescription, String description){
		nameOfDescription = nameOfDescription.toLowerCase();
		
		placeDescriptions.put(nameOfDescription, description);			
	}

	//Vorbedingung: nameOfDescription != null
	//Nachbedingung: liefert String mit description oder "Not Found"
	
	public String searchDescription(String nameOfDescription){
		String description = "Not Found";
		nameOfDescription = nameOfDescription.toLowerCase();
		
		
		if(placeDescriptions.containsKey(nameOfDescription)){
			description = placeDescriptions.get(nameOfDescription);
		}
		
		return description;
	}
	
	//Vorbedingung: listOfNeededThings != null
	//Nachbedingung: wenn alle Items von listOfNeededThings enthalten sind true, sonst false
	
	public boolean neededInfrastructure(ArrayList<String> listOfNeededThings){
		boolean hasEverything = true;
		
		for(String s : listOfNeededThings){
			if(!placeDescriptions.containsKey(s.toLowerCase())){
				hasEverything = false;	
			}					
		}

		return hasEverything;
	}
	//Nachbedingung: liefert name der Location
	public String toString(){
		return name;
	}
}
