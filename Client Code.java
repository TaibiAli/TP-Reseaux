import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        try {
            Socket soc = new Socket("localhost", 8000);

            // Create a BufferedReader and a PrintWriter for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            Scanner s = new Scanner(System.in);
            System.out.println("donnez le premier message : ");
            String message = s.nextLine();
            out.println(message);
            System.out.println("donnez 2 message : ");

            String message2 = s.nextLine();
            out.println(message2);

            String response = in.readLine();
            System.out.println("Serveur : " + response);
            soc.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
