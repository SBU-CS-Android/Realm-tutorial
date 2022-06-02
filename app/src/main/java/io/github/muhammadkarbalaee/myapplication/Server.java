package io.github.muhammadkarbalaee.myapplication;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);
    while(true) {
      Socket socket = serverSocket.accept();
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      int messagesNumber = Integer.parseInt(dataInputStream.readUTF());
      for (int i = 0; i < messagesNumber; i++) {
        System.out.println(dataInputStream.readUTF());
      }
      dataInputStream.close();
      socket.close();
    }
  }
}
