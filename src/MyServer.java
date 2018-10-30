import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Written by Martin Ombura Jr. <@martinomburajr>
 */
public class MyServer {
    public static void main(String[] args) {
        connectToServer();
    }

    public static void connectToServer() {
        //Try connect to the server on an unused port eg 9991. A successful connection will return a socket
        try(ServerSocket serverSocket = new ServerSocket(9991)) {
            Socket connectionSocket = serverSocket.accept();
            System.out.println("server start");

            //Create Input&Outputstreams for the connection
            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);

            serverPrintOut.println("$>Hardware Oracle Server! Type exit to close.\n");

            //Have the server take input from the client and echo it back
            //This should be placed in a loop that listens for a terminator text e.g. bye
            boolean done = false;

            while(!done && scanner.hasNextLine()) {

                String line = scanner.nextLine();
                System.out.println(line);
                if(line.equalsIgnoreCase("read")) {
                    serverPrintOut.println("$> Echo from <Your Name Here> Server: " + "works\n");

                }

                serverPrintOut.println("$> Echo from <Your Name Here> Server: " + line);
                System.out.println("$> Echo from <Your Name Here> Server: " + line);

                if(line.toLowerCase().trim().equals("exit")) {
                    done = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}