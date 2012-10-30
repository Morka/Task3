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
				-> keine unterscheidung der klein-gro� schreibweise
	
	*/
	
	public void addDescription(String nameOfDescription, String description){
		nameOfDescription = nameOfDescription.toLowerCase();
		
		placeDescriptions.put(nameOfDescription, description);			
	}
	
	/*
	nameOfDescription darf nicht null sein
	gibt einen String zurueck 
	*/
	public String searchDescription(String nameOfDescription){
		String description = "Not Found";
		nameOfDescription = nameOfDescription.toLowerCase();
		
		
		if(placeDescriptions.containsKey(nameOfDescription)){
			description = placeDescriptions.get(nameOfDescription);
		}
		
		return description;
	}
	
	/*
	listOfNeededThings darf nicht null sein
	wenn alle ben�tigten dinge vorhanden sind, soll true zurueckgegeben werden, sonst false
	*/
	
	public boolean neededInfrastructure(ArrayList<String> listOfNeededThings){
		boolean hasEverything = true;
		
		for(String s : listOfNeededThings){
			if(!placeDescriptions.containsKey(s.toLowerCase())){
				hasEverything = false;	
			}					
		}

		return hasEverything;
	}
	
	public String toString(){
		return name;
	}
}
