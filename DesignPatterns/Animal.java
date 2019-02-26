
public class Animal {

	private int weight;
	private String name,sound;
	
	public void setFlyType(Fly flyType) {
		this.flyType = flyType;
	}
	public Fly flyType;
	public int getWeight() {
		return weight;
	}

	public String tryToFly() {
		
		return flyType.fly();
		
	}
	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
}

class Dog extends Animal{
	
public void digHole() {
	System.out.println("dug a hole");
}	

public Dog() {
super();

this.setSound("bark");

this.flyType = new CantFly();
this.flyType.fly();	
}


}


class Cat extends Animal{
	

public Cat() {
super();

this.setSound("meow");
	
}

}
