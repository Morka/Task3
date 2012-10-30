import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Budget {
	//GOOD: Objektkoppelung
	//alle Attribute in Budget k�nnen von au�en nicht ver�ndert werden
	
	private String budgetname; 
	private Calendar date; //Datum wann Objekt Budget hinzugef�gt wurde, date <= aktuelles Datum, != null
	//ERROR: value sollte den Datentyp double haben
	private int value; //kann positive und negative Werte sowie 0 annehmen
	
		

	public Budget(String budgetname,int value)
	{
		this.budgetname = budgetname;
		this.value = value;
		this.date = Calendar.getInstance(); //weist date das aktuelle Datum zu
	}
	
	//gibt Budgetkategorie als String zur�ck
	public String getCategory()
	{
		return budgetname;
	}
	
	//gibt Wert des Budgets als int-Wert zur�ck
	public int getValue()
	{
		return value;
	}
	
	//gibt Datum des Budgetpostens zur�ck
	public Calendar getDate()
	{
		return date;
	}
	
	//BAD: schlechter Klassenzusammenhalt, geh�rt in Klasse Band oder in eigene Budgetverwaltungsklasse
	//adds up all miscellaneous costs/revenues for specific category and period
	static public int getMisc(ArrayList<Budget> budgetStack, String category, Calendar fromDate, Calendar toDate)
	{
		int sum = 0; //kann positive und negative Werte annehmen sowie 0 bleiben
		Iterator<Budget> it = budgetStack.iterator();
		Calendar from = (Calendar)fromDate.clone(); //fromDate <= toDate
		from.add(Calendar.DAY_OF_MONTH, -1); 
		Calendar to = (Calendar)toDate.clone(); //toDate >= fromDate
		to.add(Calendar.DAY_OF_MONTH, 1);
		
		while(it.hasNext()) 
		{
			Budget budget = it.next();
			if((budget.getDate().after(from)) && (budget.getDate().before(to)) && (category.equals(budget.getCategory())))
				sum += budget.getValue();
		}
		
		return sum;
	}	
	
	//BAD: schlechte Objektkoppelung, geh�rt in Klasse Band oder in eigene Budgetverwaltungsklasse
	//adds up all miscellaneous costs/revenues for period (fromDate to toDate)
	static public int getAllMisc(ArrayList<Budget> budgetStack, Calendar fromDate, Calendar toDate)
	{
		int sum = 0; //kann positive und negative Werte annehmen sowie 0 bleiben
		Iterator<Budget> it = budgetStack.iterator();
		Calendar from = (Calendar)fromDate.clone(); //fromDate <= toDate
		from.add(Calendar.DAY_OF_MONTH, -1); 
		Calendar to = (Calendar)toDate.clone();//toDate >= fromDate
		to.add(Calendar.DAY_OF_MONTH, 1);
		
		while(it.hasNext())
		{
			Budget budget = it.next();
			if((budget.getDate().after(from)) && (budget.getDate().before(to)))
				sum += budget.getValue();
		}
		
		return sum;
	}
	
	//BAD: schlechte Objektkoppelung, geh�rt in Klasse Band oder in eigene Budgetverwaltungsklasse
	//adds up all rents for Events for period (fromDate to toDate)
	static public int getRents(ArrayList<Event> events, Calendar fromDate, Calendar toDate)
	{
		int sum = 0; //kann positive und negative Werte annehmen sowie 0 bleiben
		Iterator<Event> it = events.iterator();
		Calendar from = (Calendar)fromDate.clone(); //fromDate <= toDate
		from.add(Calendar.DAY_OF_MONTH, -1); 
		Calendar to = (Calendar)toDate.clone(); //toDate >= fromDate
		to.add(Calendar.DAY_OF_MONTH, 1);
		
		while(it.hasNext())
		{
			Event currentEvent = it.next();
			if((currentEvent instanceof Rehearsal) && (currentEvent.getDate().after(from)) && (currentEvent.getDate().before(to)))
				sum += ((Rehearsal)currentEvent).getRent();	
		}
		
		return sum;
	}
	
	//BAD: schlechte Objektkoppelung, geh�rt in Klasse Band oder in eigene Budgetverwaltungsklasse
	//adds up all fees for Events for period (fromDate to toDate)
	static public int getFees(ArrayList<Event> events, Calendar fromDate, Calendar toDate)
	{
		int sum = 0; //kann positive und negative Werte annehmen sowie 0 bleiben
		Iterator<Event> it = events.iterator();
		Calendar from = (Calendar)fromDate.clone(); //fromDate <= toDate
		from.add(Calendar.DAY_OF_MONTH, -1); 
		Calendar to = (Calendar)toDate.clone(); //toDate >= fromDate
		to.add(Calendar.DAY_OF_MONTH, 1);

		while(it.hasNext())
		{
			Event currentEvent = it.next();
			if((currentEvent instanceof Gig) && (currentEvent.getDate().after(from)) && (currentEvent.getDate().before(to)))
				sum += ((Gig)currentEvent).getFee();	
		}
		
		return sum;
	}
}
