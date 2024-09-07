import java.io.*;
import java.net.*;
import java.util.Random;

public class MSGResponse extends Thread {
    private Socket socket;
    private static final String[] MESSAGES = {
            "Alegiaa.",
            "Confia que da bom.",
            "Stan TALENT stan TWICE.",
            "Hoshino Ai will not be forgeted.",
            "Dungeon Meshi <3."
    };

    public MSGResponse(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            Random rand = new Random();
            String message = MESSAGES[rand.nextInt(MESSAGES.length)];
            out.println(message);
        } catch (IOException e) {
            System.out.println("Erro ao enviar mensagem: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar socket: " + e.getMessage());
            }
        }
    }
}
