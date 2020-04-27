
interface Duck {
	void fly();
	void quack();
}

class CityDuck implements Duck {
	
	Fly iFly;
	Quack iQuack;
	public CityDuck(Fly iFly, Quack iQuack) {
		super();
		this.iFly = iFly;
		this.iQuack = iQuack;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		this.iFly.fly();
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		this.iQuack.quack();
	}
}

class RubberDuck implements Duck {
	
	Fly iFly;
	Quack iQuack;
	public RubberDuck(Fly iFly, Quack iQuack) {
		super();
		this.iFly = iFly;
		this.iQuack = iQuack;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		this.iFly.fly();
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		this.iQuack.quack();
	}
}

interface Fly {
	void fly();
}

class FlyWithWings implements Fly {
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("fly with wings");
	}
}

class NoFly implements Fly {
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("no flying");
	}
}

interface Quack{
	void quack();
}

class SimpleQuackBehaviour implements Quack{

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("simple quack");
	}
	
}

class NoQuackBehaviour implements Quack{

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("no quack");
	}
	
}

public class StrategyPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we want to create multiple ducks with different types of behaviour
		// we create a generic interface to create a quack strategy/behavior
		// let concrete implementations define those strategies implementations
		// inject them into our concrete duck class via constructor or setter injection
		
		Duck cityDuck = new CityDuck(new FlyWithWings(), new SimpleQuackBehaviour());
		cityDuck.fly();
		cityDuck.quack();
		
		Duck rubberDuck = new RubberDuck(new NoFly(), new NoQuackBehaviour());
		rubberDuck.fly();
		rubberDuck.quack();
	}

}
