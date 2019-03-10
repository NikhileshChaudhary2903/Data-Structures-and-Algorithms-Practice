import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

	public static void main(String args[]) {

		HeadHunters hh = new HeadHunters();
		
		// not yet subscribed to jobs
		JobSeeker j1 = new JobSeeker("Nikhilesh");
		JobSeeker j2 = new JobSeeker("Meenakshi");
		JobSeeker j3 = new JobSeeker("Davinder");
		
		// there you go
		hh.register(j1);
		hh.register(j2);
		hh.register(j3);
		
		hh.addJobs("Google Job");
		hh.addJobs("FB Job");
		hh.unregister(j3);

		hh.addJobs("MS Job");
		
	}
}

// publisher
interface Subject{
	
void register(Observer o);
void unregister(Observer o);
void notifyAllObservers();
	
}

interface Observer{
	
void update(Subject s);	
	
}

class HeadHunters implements Subject{

	List<String> jobs;
	List<Observer> observers;

	public HeadHunters() {
		
		this.jobs  = new ArrayList<>();
		this.observers = new ArrayList<Observer>();
	}
	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		this.observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		int index = this.observers.indexOf(o);
		this.observers.remove(index);
	}

	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		for(Observer o:this.observers)
		{
			o.update(this);
		}
	}
	
	public void addJobs(String s)
	{
		this.jobs.add(s);
		notifyAllObservers();
	}
	
	public String toString() {
		return jobs.toString();
	}
	
}

class JobSeeker implements Observer{

	String name;
	
	public JobSeeker(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " got notified");
		System.out.println(s);

	}
	
}
