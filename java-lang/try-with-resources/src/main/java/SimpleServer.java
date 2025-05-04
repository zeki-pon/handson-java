import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        var server = new ServerSocket(1600);
        System.out.println("Waiting....");
        try (Socket socket = server.accept();
             InputStream input = socket.getInputStream())
        {
            System.out.println("connect from " + socket.getInetAddress());
            System.out.println(input.read());
        }
    }
}
