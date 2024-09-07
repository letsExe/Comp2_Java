import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int port = 12345; // escolha uma porta para ser usada por este servidor

        try (ServerSocket serverSocket = new ServerSocket(port)) { //  crie um socket de servidor
            System.out.println("Servidor de Mensagens de Boa Sorte iniciado na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // aceite uma conexão de um cliente
                new MSGResponse(clientSocket).start(); // envie a mensagem de boa sorte usando a classe MSGResponse em modo Thread
            }
        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }
}
