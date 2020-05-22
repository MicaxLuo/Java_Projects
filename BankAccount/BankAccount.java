
enum Currency {
	Dollar, Euro, Pound;
}

public class BankAccount {
	double balance;
	Currency currency;
	
	public BankAccount(double balance, Currency currency) {
		super();
		this.balance = balance;
		this.currency = currency;
	}

	public synchronized void deposit(double balance, Currency currency) {
		if (this.currency == null) {
			this.currency = currency;
		}
		if (this.currency != currency && this.balance > 0) {
			try {
				System.out.println("Invalid currency.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.balance += balance;
		this.currency = currency;
		System.out.println("My Deposit:\t\t"  + balance + " " + currency + "\t| Balance: " + this.balance + " " + currency);
		notify();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void withdraw() {
		if (this.balance == 0) {
			try {
				System.out.println("Insufficient balance.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.balance -= 1;
		System.out.println("Friend's Withdrawal:    1.0" +  " " + this.currency + "\t| Balance: " + this.balance + " " + this.currency);
		notify();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
