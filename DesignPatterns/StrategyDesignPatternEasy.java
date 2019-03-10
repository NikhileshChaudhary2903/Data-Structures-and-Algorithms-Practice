
public class StrategyPattern {

	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void handleStrategy(double speed) {
		this.strategy.processSpeed(speed);
	}
	
	public static void main(String args[]) {

		StrategyPattern s1 = new StrategyPattern();
		StrategyPattern s2 = new StrategyPattern();
		
		s1.setStrategy(new NiceStrategy());
		s2.setStrategy(new HardStrategy());
		
		s1.handleStrategy(75);
		s2.handleStrategy(35);
		
		
	}	
}


interface Strategy{
	
void processSpeed(double speed); 
	
}

class NiceStrategy implements Strategy{

	@Override
	public void processSpeed(double speed) {
		// TODO Auto-generated method stub
		if(speed > 65)
			System.out.println("warning for overspeeding");
		else
			System.out.println("no for overspeeding");
	}
}

class HardStrategy implements Strategy{

	@Override
	public void processSpeed(double speed) {
		// TODO Auto-generated method stub
		if(speed > 45)
			System.out.println("ticket for overspeeding");
		else
			System.out.println("no for overspeeding");
	}
}

