package org.nik.javabrains;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// lambda expression
		Greeting myGreetLambda = () -> System.out.println("hello world");
		
		// anonymous class
		Greeting innerClass = new Greeting() {
			
			@Override
			public void perform() {
				// TODO Auto-generated method stub
				System.out.println("hello world from inner");
			}
		};
		myGreetLambda.perform();
		innerClass.perform();
	}

}

// Functional Interface can only have 1 method declaration
interface Greeting {
	void perform();
}
