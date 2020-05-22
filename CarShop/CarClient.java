import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CarClient {
	public static void main(String[] args) {
		try {
			System.out.println("---------------------------");
			System.out.println("---Newly Registered Cars---");
			System.out.println("----------------------------");

			Car[] carArr = new Car[3];

			carArr[0] = new Car("Audi Romeo", "White", 1000);
			carArr[1] = new Car("BMW 5 Series", "Blue", 25000);
			carArr[2] = new Car("Cadillac Escalade", "Grey", 30000);

			for (int i = 0; i < carArr.length; i++) {
				System.out.println(carArr[i].toString());
				System.out.println("---Creating new plate---");

				CarInterface obj = (CarInterface) Naming.lookup("rmi://localhost:8989/NewPlate");
				carArr[i].setPlate(obj.register(carArr[i]));

				System.out.println("New plate number: " + carArr[i].getPlate());
				System.out.println("New plate registered!");
				System.out.println(carArr[i].toString());
				System.out.println();
				Thread.sleep(500);
			}
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		} catch (NotBoundException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}