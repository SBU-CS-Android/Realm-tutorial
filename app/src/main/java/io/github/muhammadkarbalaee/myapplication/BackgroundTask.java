package io.github.muhammadkarbalaee.myapplication;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;

public class BackgroundTask extends AsyncTask<Void,Void,Void> {

  @Override
  protected Void doInBackground(Void... voids) {
    try {
      Socket socket = new Socket("172.20.170.177", 5000);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
