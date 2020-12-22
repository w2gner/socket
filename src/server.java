import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {

        String newMessage;
        String message;

        ServerSocket serverSocket = new ServerSocket(55555);
        System.out.println("Porta 55555 foi aberta!\nServidor esperando contato...");

        Socket socket = serverSocket.accept();
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        do {
            message = input.readUTF();

            newMessage = new StringBuilder(message).reverse().toString();
            newMessage = newMessage.toUpperCase();

            output.writeUTF(newMessage);

        } while (!message.equalsIgnoreCase("exit"));

        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}