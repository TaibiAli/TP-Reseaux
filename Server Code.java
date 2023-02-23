import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static int count = 0;

    public static void main(String[] args) throws Exception {
        try {
            int port = 8000;
            ServerSocket server = new ServerSocket(port);
            System.out.println("debut de serveur   ");
            while (true) {
                System.out.println("attendre  ... ");
                Socket soc = server.accept();
                count++;
                System.out.println(" connect ");
                System.out.println("Clients connecte :" + count);
                MyThread myThread = new MyThread(soc);
                myThread.start();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
