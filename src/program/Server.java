package program;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

	public Server() {
	}

	public String sayHello() {
		return "Hello, world!";
	}

	public int soma(int a, int b) {
		return a + b;
	}

	public int subtracao(int a, int b) {
		return a - b;
	}

	public float divisao(float a, float b) {
		return a / b;
	}

	public String sayBye() {
		return "Bye, world!";
	}

	public static void main(String args[]) {

		try {
			Server obj = new Server();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("Hello", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
