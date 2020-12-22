import java.io.*;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException {

        String newMessage;

        Scanner read = new Scanner(System.in);

        Socket socket = new Socket("192.168.56.1", 55555);

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());

        System.out.println("Insira uma mensagem para inverter: ");
        do {
            String message = read.next();
            if (message.equalsIgnoreCase("exit")) {
                break;
            } else {
                output.writeUTF(message);

                newMessage = input.readUTF();
                System.out.println(newMessage);
            }
        } while (true);

        input.close();
        output.close();
        socket.close();
    }
}