
public class Park implements Element {

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		System.out.println("Park is accepting visitors");
		v.visit(this);

	}

}
