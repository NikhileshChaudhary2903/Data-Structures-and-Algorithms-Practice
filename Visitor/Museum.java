
public class Museum implements Element {

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		System.out.println("museum is accepting visitors");
		v.visit(this);
	}

}
