
public class Main {
	public static void main(String[] args) throws InterruptedException {
		BankAccount bankAccount = new BankAccount(0, null);
		Me me = new Me(bankAccount);
		Friend friend = new Friend(bankAccount);
		Thread mThread = new Thread(me);
		Thread fThread = new Thread(friend);
		
		mThread.start();
		fThread.start();
		mThread.join();
		fThread.join();
		System.out.println("Transaction Finished.");
	}
}
