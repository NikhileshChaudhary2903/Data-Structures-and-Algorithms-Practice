



class A {

	static int x,y,z;
	
	public static void f1() {
		System.out.println("f1");
	}
	
}

class B extends A{
	
	int a,b;
	
	public static void f1() {
		System.out.println("f1 B"+x);
	}
	
	public void f2() {
			System.out.println("f2");
		
	}
	
}

class Demo {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog fido= new Dog();
		fido.setName("Caesar	");
//		System.out.println(fido.getSound());
		System.out.println(fido.getName());
		changeObjectName(fido);
		System.out.println(fido.getName());
		
		Animal doggy = new Dog();
		Animal catty = new Cat();
		
		System.out.println(doggy.getSound());
		System.out.println(catty.getSound());
		
		Creature giraffe = new Giraffe();
		giraffe.setName("boggy");
		
		System.out.println(giraffe.getName());
		
	}

	public static void changeObjectName(Dog dog)
	{
		dog.setName("Joey");
	}
}
