
public interface Visitor {

	public void visit(City c);
	public void visit(Museum m);
	public void visit(Park p);
	
}

class FirstTimeVisitor implements Visitor{

	@Override
	public void visit(City c) {
		// TODO Auto-generated method stub
		System.out.println("i am visiting city");
	}

	@Override
	public void visit(Museum m) {
		// TODO Auto-generated method stub
		System.out.println("i am visiting museum");

	}

	@Override
	public void visit(Park p) {
		// TODO Auto-generated method stub
		System.out.println("i am visiting Park");

	}
	
	
}