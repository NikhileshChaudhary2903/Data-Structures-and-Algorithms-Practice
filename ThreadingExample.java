
class MyClassA implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
			System.out.println("Thread A running "+i);
	}
	
}

class MyClassB implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
			System.out.println("Thread B running "+i);
	}
	
}
public class ThreadsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = new MyClassA();
		Thread t1 = new Thread(r1);
		
		Runnable r2 = new MyClassB();
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
