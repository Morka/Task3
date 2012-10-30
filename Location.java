import java.util.HashMap;
import java.util.ArrayList;

public class Location{
	
	private final String name;
	
	/**
	* HashKey stores the name of the description (the value, which is searched 
	* for. 
	* HashValue stores the description of the Location
	*/
	
	private HashMap<String, String> placeDescriptions; 
	
	public Location(String name){
		this.name = name;
		placeDescriptions = new HashMap<String, String>();
	}
	
	public String getName(){
		return name;
	}
	
	/**
	* adds a name and description to "placeDescriptions"
	* 
	* @param nameOfDesccription short description and value that is searched for
	* @param description detailed description 
	*
	*/
	public void addDescription(String nameOfDescription, String description){
		nameOfDescription = nameOfDescription.toLowerCase();
		
		placeDescriptions.put(nameOfDescription, description);			
	}
	
	/**
	* gives back the detailed description
	*
 	* @param nameOfDescription short description
	* @return a String which contains the detailed description or "Not Found"
	*/
	
	public String searchDescription(String nameOfDescription){
		String description = "Not Found";
		nameOfDescription = nameOfDescription.toLowerCase();
		
		
		if(placeDescriptions.containsKey(nameOfDescription)){
			description = placeDescriptions.get(nameOfDescription);
		}
		
		return description;
	}
	
	/**
	* tests if every Infrastracture that is needed is available
	*
	* @param neededInfrastracture ArrayList containing strings of names of descriptions
	* 
	* @return "true" if everything(!) is found, "false" if not
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
