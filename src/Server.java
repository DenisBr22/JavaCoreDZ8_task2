import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int port = 8080;

        System.out.println("Server startup");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("New connection accepted");
            final String host = in.readLine();
            out.println(String.format("Hi %s, your port is %d \nWrite your name", host, clientSocket.getPort()));
            final String username = in.readLine();

            out.println("Are you child? (yes/no)");
            final String answer = in.readLine();
            if (answer.equals("yes")) {
                out.println("Welcome to the kids area, " + username + "! Let's play!");
            } else if (answer.equals("no")) {
                out.println("Welcome to the adult zone, " + username + "! Have a good rest, or a good working day!");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}