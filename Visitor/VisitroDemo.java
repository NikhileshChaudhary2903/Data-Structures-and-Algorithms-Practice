
public class VisitroDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstTimeVisitor visitor = new FirstTimeVisitor();
		City c = new City();
		c.accept(visitor);
	}

}
