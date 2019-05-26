import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private int port;
    private Socket clientSocket = null;
    private BufferedReader in, stdIn = null;
    private ObjectOutputStream out = null;
    private String userInput = null;

    public Client(String address, int port) {

        try {
            clientSocket = new Socket(address, port);
            System.err.println("You have been connected to server.");
            System.err.println("Type <help> for the reference.");
            System.err.println("--------------------------------------------");
            System.out.println();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            stdIn = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException mex) {
            System.out.println(mex);
        }
        try {
            while ((userInput = stdIn.readLine()) != null) {
                SocketDto socketDto = new SocketDto();
                socketDto.setCommand(userInput);
                out.writeObject(socketDto);
                new Thread(() -> in.lines().forEachOrdered(System.out::println)).start();
                if (userInput.equals("exit")) {
                    stdIn.read();
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            clientSocket.close();
            System.exit(420);
        } catch (IOException mex) {
            System.out.println(mex);
        }

    }

    public static void main(String[] args) {
        try {
            new Client("127.0.0.1", 8200);
        } catch (Exception mex) {
            System.out.println(mex);
        }
    }
}
