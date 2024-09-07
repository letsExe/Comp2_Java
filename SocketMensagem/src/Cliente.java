import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Endereço do servidor
        int port = 12345; // Porta do servidor

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message = in.readLine();
            System.out.println("Mensagem de Boa Sorte recebida: " + message);
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}
