
public class Bird extends Animal {

public Bird() {
	
	super();
	this.setSound("sweet");
	this.flyType = new ItFlys();
	this.flyType.fly();
}	
	
}
