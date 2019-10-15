import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 1234;
        ServerSocket server = new ServerSocket(port);
        
        while(true){
            Socket client = server.accept();
            
            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            
            String msg = input.readUTF();
            System.out.println(msg);
            output.writeUTF("Server\'s response: " + msg);
            
            input.close();
            output.close();
            client.close();

        }
    }

}
