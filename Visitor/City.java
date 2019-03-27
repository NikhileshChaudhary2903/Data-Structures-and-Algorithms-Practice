import java.util.ArrayList;

interface Element {
	public void accept(Visitor v);	
}
public class City implements Element {

	ArrayList<Element> elements= new ArrayList<Element>();
	 
	
	public City() {
		this.elements.add(new Park());
		this.elements.add(new Museum());
	}
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		System.out.println("city is accepting visitors");
		v.visit(this);
		// package includes museum and park
		for(Element e:this.elements) {
			e.accept(v);
		}
	}

}
