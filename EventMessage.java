public class EventMessage extends Message
{
	State state; //immer != null
	Member member; //immer != null
	
	//Vorbedingung: member != null
	//Vorbedingung: state != null
	//Nachbedingung: EventMessage ist vollständig initialisiert
	public EventMessage(String message, Member member, State state)
	{
		super(message);
		this.member = member;
		this.state = state;
	}	
	
	//Nachbedingung: gibt Inhalt der Message zur�ck
	public String toString()
	{
		String ret = "";
		
		ret += message + " Name: " + member.getName() + " State: ";
		if(state == State.ACCEPT)  
			ret += "Accept";
		else
			ret += "Decline";
		
		return ret;
	}
		
}


