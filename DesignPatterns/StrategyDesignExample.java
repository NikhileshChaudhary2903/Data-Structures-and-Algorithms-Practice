
public class StrategyDesignExample {

	public static void main(String[] args) {
		
	Animal dog = new Dog();
	Animal tweety= new Bird();
	
	System.out.println(dog.tryToFly());
	System.out.println(tweety.tryToFly());
	 
	dog.setFlyType(new ItFlys());
	System.out.println(dog.tryToFly());

	}
	
}
