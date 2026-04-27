import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIp = "100.126.205.5"; // <-- Tailscale IP of server
        int port = 5000;

        Socket socket = new Socket(serverIp, port);

        BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

        String input;
        while ((input = console.readLine()) != null) {
            out.write(input + "\n");
            out.flush();

            String response = in.readLine();
            System.out.println("Server: " + response);
        }

        socket.close();
    }
}