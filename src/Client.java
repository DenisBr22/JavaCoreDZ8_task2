import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        final String host = "netology.homework";

        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Host: " + host);

            String resp = in.readLine();
            System.out.println(resp);

            String resp2 = in.readLine();
            System.out.println(resp2);

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);

            String resp3 = in.readLine();
            System.out.println(resp3);

            String answer = scanner.nextLine();
            out.println(answer);

            String resp4 = in.readLine();
            System.out.println(resp4);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}