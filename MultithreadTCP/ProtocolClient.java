import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ProtocolClient {
    public static void main(String[] args)  throws java.io.IOException {
        Socket s = new Socket("localhost", 4444);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        while(true){
            Scanner stdIn = new Scanner(System.in);
            String fromUser = stdIn.next();
            out.writeUTF(fromUser);
            System.out.println(in.readUTF());
            if (fromUser.equals("Bye")) break;
        }
        in.close();
        out.close();
        s.close();
    }
}
