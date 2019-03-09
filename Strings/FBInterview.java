import java.util.Comparator;

public class Dinosaur {

	
	String name,diet,stance;
	double speed,legLength,strideLength;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getStance() {
		return stance;
	}
	public void setStance(String stance) {
		this.stance = stance;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getLegLength() {
		return legLength;
	}
	public void setLegLength(double legLength) {
		this.legLength = legLength;
	}
	public double getStrideLength() {
		return strideLength;
	}
	public void setStrideLength(double strideLength) {
		this.strideLength = strideLength;
	}
	public Dinosaur(String name, String diet, String stance, double speed, double legLength, double strideLength) {
		super();
		this.name = name;
		this.diet = diet;
		this.stance = stance;
		this.speed = speed;
		this.legLength = legLength;
		this.strideLength = strideLength;
	}
	
	public double calculateSpeed(double leg_length, double stride_length) {
	    return (stride_length / leg_length - 1) * Math.sqrt(leg_length * 9.8);
	  }
}

class SpeedComparator implements Comparator<Dinosaur> {

	@Override
	public int compare(Dinosaur o1, Dinosaur o2) {
		// TODO Auto-generated method stub
		
		if(o1.speed > o2.speed)
			return -1;
		else if(o1.speed < o2.speed)
			return 1;
		
		return 0;
	}
}	

static String s1 = "NAME,LEG_LENGTH,DIET\n" + 
			"Hadrosaurus,1.2,herbivore\n" + 
			"Struthiomimus,0.92,omnivore\n" + 
			"Velociraptor,1.0,carnivore\n" + 
			"Triceratops,0.87,herbivore\n" + 
			"Euoplocephalus,1.6,herbivore\n" + 
			"Stegosaurus,1.40,herbivore\n" + 
			"Tyrannosaurus Rex,2.5,carnivore\n";
	
	static String s2 = "NAME,STRIDE_LENGTH,STANCE\n" + 
			"Euoplocephalus,1.87,quadrupedal. From 1point 3acres bbs\n" + 
			"Stegosaurus,1.90,quadrupedal\n" + 
			"Tyrannosaurus Rex,5.76,bipedal\n" + 
			"Hadrosaurus,1.4,bipedal\n" + 
			"Deinonychus,1.21,bipedal\n" + 
			"Struthiomimus,1.34,bipedal\n" + 
			"Velociraptor,2.72,bipedal\n";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String x[]  = s1.split("\n");
	    String y[]= s2.split("\n");
	    
	    HashMap<String,Dinosaur> map = new HashMap<>();
	    
	    for(String s:y)
	    {
	     	String name = s.split(",")[0];
	     	String strideLen = s.split(",")[1];
	     	String stance = s.split(",")[2];
	     	
	     	if(stance.equals("bipedal"))
	     	map.put(name, new Dinosaur(name, null, stance, 0.0, 0.0, Double.parseDouble(strideLen)));
	    }
	    
	    for(String s:x)
	    {
	    	String name = s.split(",")[0];
	    	if(map.containsKey(name))	
	    	{
	    		String legLength = s.split(",")[1];
	    		Dinosaur d = map.get(name);
	    		d.speed = d.calculateSpeed(Double.parseDouble(legLength), d.strideLength);
	    		
	    	}
	    }
	    System.out.println(map);

//	    for(String s:map.keySet()) {
//	    	System.out.println(map.get(s).name);
//	    	System.out.println(map.get(s).speed);
//	    }
	   PriorityQueue<Dinosaur> pq = new PriorityQueue<>(new SpeedComparator());
	   	
	   for(Entry<String, Dinosaur> entry:map.entrySet())
	   {
		   pq.add(entry.getValue());
	   }
	   
	   while(!pq.isEmpty()) {
		   System.out.println(pq.peek().name);
		   System.out.println(pq.peek().speed);
		   pq.poll();
	   }
	   
//		list.add("123");
//		list.add("nikhil");
//		list.add(12);
//		list.add('c');
//		
//		System.out.println(list.get(5));
//        List<List<Integer> > list = new List<ArrayList<Integer>>();
		
//		HashMap<String,Double> map =new HashMap<>();
//		
//		map.put("Nikhil",4.5);
//		map.put("Akash",3.5);
//		map.put("Sanjay",1.5);
//		map.put("Rohit",2.5);
//		map.put("John",2.8);
//		map.put("Jane",3.8);
//
//		PriorityQueue<Counter> pq = new PriorityQueue<Counter>((Collection<? extends Counter>) new Comparator<T>() {
//
//			@Override
//			public int compare(Counter o1, Counter o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
		
		
//		Collections.sort(list);
//		System.out.println(list);
//		
//		System.out.println(l1);
//		Collections.sort(l1);
//		List<Integer> l2 = new ArrayList<>();
//		l2.add(1);
//		l2.add(2);
//
//		System.out.println(l2);
//		l1.retainAll(l2);
////		l1.removeAll(l2);
//		System.out.println(l1);
		
//		new ListExamples().diplay();
	}
