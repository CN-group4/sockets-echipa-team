import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server listening on port " + port);

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Client: " + message);

            out.write("Echo: " + message + "\n");
            out.flush();
        }

        socket.close();
        serverSocket.close();
    }
}