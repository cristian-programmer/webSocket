import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT = 3000;
	
	ServerSocket server;
	Socket clientSocketAcept;
	
	BufferedReader on;
	PrintWriter emit;
	
	public void runServer(){
		try {
			server = new ServerSocket(PORT);
			System.out.println("Sever on: "+ PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("El puerto de esucha esta ocupado");
			e.printStackTrace();
		}
	}
	
	public void acceptClients() {
		try {
			clientSocketAcept = server.accept();
			on = new BufferedReader(new InputStreamReader(clientSocketAcept.getInputStream()));
			emit = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocketAcept.getOutputStream())), true);
			
			while (true) {
				String data = on.readLine();
				System.out.println("Cliente: " +  data);
				emit.print("thanks");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
