
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface CarInterface extends Remote {
	public String register(Car car) throws RemoteException;
}