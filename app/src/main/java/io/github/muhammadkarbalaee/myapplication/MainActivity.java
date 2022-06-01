package io.github.muhammadkarbalaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BackgroundTask backroundTask = new BackgroundTask();
    backroundTask.execute();
  }
}
