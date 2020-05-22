
import java.rmi.*;
import java.rmi.server.*;
public class CarImpl extends UnicastRemoteObject implements CarInterface {
	private static final long serialVersionUID = 99L;
	
	public CarImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String register(Car car) throws RemoteException {
		return "ONT" + car.hashCode();
	}
}