import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        
        int port = 1234;
        
        while (true) {
            Socket server = new Socket("localhost", port);
            
            DataInputStream input = new DataInputStream(server.getInputStream());
            DataOutputStream output = new DataOutputStream(server.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            output.writeUTF(sc.next());
            
            String msg = input.readUTF();
            System.out.println(msg);
            
            input.close();
            output.close();
            server.close();
        }
        
    }
}
