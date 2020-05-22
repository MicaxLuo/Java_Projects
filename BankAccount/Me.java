
import java.util.LinkedHashMap;
import java.util.Map;

public class Me implements Runnable{
	BankAccount bankAccount;
	LinkedHashMap<Currency, Double> capital = new LinkedHashMap<Currency, Double>();
	
	public Me(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		capital.put(Currency.Dollar, 1.0);
		capital.put(Currency.Euro, 2.0);
		capital.put(Currency.Pound, 3.0);
		for (Map.Entry<Currency, Double> e : capital.entrySet()) {
			while (e.getValue() != 0) {
				bankAccount.deposit(1, e.getKey());
				e.setValue(e.getValue() - 1);
			}
		}
	}	
}
