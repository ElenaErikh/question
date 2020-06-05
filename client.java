package ru.geekbrains.something;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class client {
    final static String IP_ADDRESS = "localhost";
    final static int PORT = 8189;

    public static void main(String[] args){

        try (Socket socket = new Socket(IP_ADDRESS, PORT)) {
            System.out.println("Клиент подключился");

            try(Scanner inSocket = new Scanner(socket.getInputStream());
                Scanner inConsole = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                Thread t1 = new Thread(() -> {
                    try {
                        while (true) {
                            String str = inSocket.nextLine();
                            System.out.println("Сервер: " + str);
                        }
                    }catch (NoSuchElementException ex){
                    }
                });
                t1.setDaemon(true);
                t1.start();

                while (true) {
                    String str2 = inConsole.nextLine();
                    if (str2.equals("/end")) {
                        out.println(str2);
                        System.out.println("Вы отключились");
                        break;
                    }
                    out.println(str2);
                }
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Cервер отключился");
            ex.printStackTrace();
        }
    }
}
