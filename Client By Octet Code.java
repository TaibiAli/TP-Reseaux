import java.io.*;
import java.net.*;

public class client_octet {
    public static void main(String[] args) {
        try {
            // se connecter au serveur
            Socket socket = new Socket("localhost", 1234);

            // obtenir des flux de sortie pour envoyer des données au serveur
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // obtenir des flux d'entrée pour recevoir des données du serveur
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // lecture des 2 chaines de caracteres a partir du clavier
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entrez la première chaine de caractères : ");
            String chaine1 = reader.readLine();
            System.out.print("Entrez la deuxième chaine de caractères : ");
            String chaine2 = reader.readLine();

            // envoi des 2 chaines au serveur
            dataOutputStream.writeUTF(chaine1);
            dataOutputStream.writeUTF(chaine2);

            // reception de la reponse du serveur et affichage
            String reponse = dataInputStream.readUTF();
            System.out.println(reponse);

            // fermeture des flux et de la socket
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
