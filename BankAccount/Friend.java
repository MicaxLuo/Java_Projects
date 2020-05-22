
public class Friend implements Runnable{
	BankAccount bankAccount;
	 
	public Friend(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 6; i++) {
			bankAccount.withdraw();
		}
	}
}
