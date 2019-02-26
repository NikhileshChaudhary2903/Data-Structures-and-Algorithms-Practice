
public interface Fly {

	String fly();
}

class ItFlys implements Fly{

	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "Fly high";
	}
	
}

class CantFly implements Fly{

	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "Cannot fly";
	}
	
}
