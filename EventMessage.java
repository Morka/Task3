public class EventMessage extends Message
{
	State state; //immer != null
	Member member; //immer != null
	
	public EventMessage(String message, Member member, State state)
	{
		super(message);
		this.member = member;
		this.state = state;
	}	
	
	//gibt Inhalt der Message zurück
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


