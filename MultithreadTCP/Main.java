import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        ServerSocket s = new ServerSocket(4444);
        while (true){
            Socket ns = s.accept();
            new Thread(new ProtocolServer(ns)).start();
        }
        //s.close();
    }
}
