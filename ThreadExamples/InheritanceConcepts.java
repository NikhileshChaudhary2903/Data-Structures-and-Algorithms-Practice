
public class A {

//	static int x;
//	static {
//		
//		x= 5;
//		System.out.println("Static block");
//	}
//	
//  public A() {
//	  System.out.println("constr block");
//  }
//	public void f1() {
//		System.out.println("parent");
//	}
  public static void main(String args[])
  {
	  B.func();
  }
	
	public static void func() {
		System.out.println("parent");
	}
	
	public static void func1() {
		System.out.println("parent 1");
	}
}


class B extends A {
	

	public static void func() {
		func1();
	}
//	  public B() {
//		  super();
//		  System.out.println("constr block in subclass");
//	  }
//	public void f1() {
//		System.out.println("f in subclass");
//	}

}


