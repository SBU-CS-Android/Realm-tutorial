package io.github.muhammadkarbalaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  EditText textInput;
  Button dbButton;
  Button sendButton;
  SQLiteDatabase readDatabase;
  SQLiteDatabase writeDatabase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textInput = findViewById(R.id.editTextTextPersonName);
    dbButton = findViewById(R.id.button);
    sendButton = findViewById(R.id.button2);

    DatabaseHandler databaseHandler = new DatabaseHandler(this);

    this.readDatabase = databaseHandler.getReadableDatabase();
    this.writeDatabase = databaseHandler.getWritableDatabase();

    dbButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message",textInput.getText().toString());
        writeDatabase.insert("messages",null,contentValues);
        Toast.makeText(getApplicationContext(),"Saved to DB", Toast.LENGTH_LONG).show();
      }
    });

    sendButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        String[] projection = {"message"};
        Cursor cursor = readDatabase
            .query("messages",projection,
                           null,null,
                   null,null,null);

        ArrayList<String> messages = new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
          messages.add(cursor.getString(0));
        }

        SendServerTask sendServerTask = new SendServerTask(messages);
        sendServerTask.execute();

        Toast.makeText(getApplicationContext(),"Sent to server", Toast.LENGTH_LONG).show();

        cursor.close();
      }
    });
  }
}
