import java.io.*;
import java.net.*;

public class server_octet {
    public static void main(String[] args) {
        try {
            // demarrage du serveur sur le port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Le serveur est démarré et en attente de clients...");

            while (true) {
                // attendre la connexion d'un client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connexion établie avec le client " + clientSocket.getRemoteSocketAddress());

                // obtenir des flux d'entrée pour recevoir des données du client
                InputStream inputStream = clientSocket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                // obtenir des flux de sortie pour envoyer des données au client
                OutputStream outputStream = clientSocket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                // lecture des 2 chaines de caracteres envoyees par le client
                String chaine1 = dataInputStream.readUTF();
                String chaine2 = dataInputStream.readUTF();

                // verification si chaine1 contient chaine2
                if (chaine1.contains(chaine2)) {
                    dataOutputStream.writeUTF(chaine1 + " contient " + chaine2);
                } else {
                    dataOutputStream.writeUTF(chaine1 + " ne contient pas " + chaine2);
                }

                // fermeture des flux et de la socket du client
                dataInputStream.close();
                dataOutputStream.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
