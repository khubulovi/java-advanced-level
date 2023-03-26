package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Java Core. Advanced level. Lesson 6
 *
 * @author Malkhaz Khubulovi
 * @version dated Mart 26, 2023
 */

// Task
//    1. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
// Т.е. если на клиентской стороне написать «Привет», нажать Enter, то сообщение должно передаться на сервер и там отпечататься в консоли.
// Если сделать то же самое на серверной стороне, то сообщение передается клиенту и печатается у него в консоли. Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд.
// Такую ситуацию необходимо корректно обработать.

public class Client {
    private final int PORT = 8000;
    private final String IP_ADDRESS = "localhost";
    private final String CONNECT_TO_SERVER = "Connection to server established.";
    private final String CONNECT_CLOSED = "Connection closed.";
    private final String EXIT_COMMAND = "/exit";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            System.out.println(CONNECT_TO_SERVER);
            Thread clientThread = new Thread(() -> {
                while (true) {
                    serverMessage(scanner.nextLine());
                }
            });
            clientThread.setDaemon(true);
            clientThread.start();
            while (true) {
                String text = in.readUTF();
                if (text.equals(EXIT_COMMAND)) {
                    break;
                }
                System.out.println("Server: " + text);
            }
            System.out.println(CONNECT_CLOSED);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverMessage(EXIT_COMMAND);
            try {
                in.close();
                out.close();
                scanner.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    public void serverMessage(String text) {
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
