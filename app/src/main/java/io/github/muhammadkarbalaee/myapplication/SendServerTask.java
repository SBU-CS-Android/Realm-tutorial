package io.github.muhammadkarbalaee.myapplication;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SendServerTask extends AsyncTask<Void,Void,Void> {

  private final ArrayList<String> messages;

  public SendServerTask(ArrayList<String> messages) {
    this.messages = messages;
  }

  @Override
  protected Void doInBackground(Void... voids) {
    try {
      Socket socket = new Socket("172.20.172.215", 5000);
      DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
      dataOutputStream.writeUTF(messages.size() + "");
      for (String message : messages) {
        dataOutputStream.writeUTF(message);
        dataOutputStream.flush();
      }
      dataOutputStream.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
