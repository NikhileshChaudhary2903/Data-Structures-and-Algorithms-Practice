
import java.util.Scanner;

class Account {
	
	private int bal;

	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public Account(int bal) {
		super();
		this.bal = bal;
	}
	public boolean withdraw(int amt)
	{
		if(this.bal > amt) {
			this.bal -=amt;
			return true;
		}
		
		return false;
	}
	
}

class Customer implements Runnable {
	
	private Account account;
	private String name;
	public Customer(Account account,String name) {
		super();
		this.account = account;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		synchronized (account) 
		{	
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter amt to withdraw for customer" + this.name);
			int amt = sc.nextInt();
			boolean flag = this.account.withdraw(amt);
		
		if(flag)
		{
			System.out.println(this.name + " successfully withdrew " + amt);
			System.out.println(this.name + " balance is now " + this.account.getBal());
		}
		else {
			System.out.println("insufficient balance");
			System.out.println(this.name + " balance is still " + this.account.getBal());
		}
		}
	}
	
}
public class MultiThreadingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account(1000);
		Thread t1 = new Thread(new Customer(a1,"Nikhil"));
		Thread t2 = new Thread(new Customer(a1,"Meenakshi"));
		
		t1.start();
		t2.start();
		
	}

}
