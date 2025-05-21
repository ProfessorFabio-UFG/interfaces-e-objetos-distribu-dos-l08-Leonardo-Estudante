package program;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	String sayHello() throws RemoteException;

	int soma(int a, int b) throws RemoteException;

	int subtracao(int a, int b) throws RemoteException;

	float divisao(float a, float b) throws RemoteException;

	String sayBye() throws RemoteException;
}
