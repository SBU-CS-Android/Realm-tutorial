package io.github.muhammadkarbalaee.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

  public DatabaseHandler(@Nullable Context context) {
    super(context, "myDB", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String query = "CREATE TABLE messages (message TEXT)";
    sqLiteDatabase.execSQL(query);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    String query = "DROP TABLE IF EXISTS messages";
    sqLiteDatabase.execSQL(query);
    this.onCreate(sqLiteDatabase);
  }
}
