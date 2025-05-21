package program;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private Client() {
	}

	public static void main(String[] args) {

		System.out.println("Initiating client");

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			System.out.println("Registry has been located");
			Hello stub = (Hello) registry.lookup("Hello");
			System.out.println("Found server");

			String response = stub.sayHello();
			System.out.println("Response: " + response);

			int resp = stub.soma(100, 1000);
			System.out.println("Response from soma: " + resp);

			int resposta = stub.subtracao(200, 100);
			System.out.println("Response from subtração: " + resposta);

			float valor = stub.divisao(10, 5);
			System.out.println("Response from divisão: " + valor);

			String responseBye = stub.sayBye();
			System.out.println("Response: " + responseBye);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
