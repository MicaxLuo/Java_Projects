import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
	public CarServer() {
		try {		
			CarInterface obj = new CarImpl();
			Registry registry = LocateRegistry.createRegistry(8989);
			registry.rebind("NewPlate", obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new CarServer();
		System.out.println("---Creating New Plate---");
	}
}