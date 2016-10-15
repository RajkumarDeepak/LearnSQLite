package com.example.android.learnsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Login extends AppCompatActivity {

  SQLiteHelper myDB;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    myDB = new SQLiteHelper(this.getApplicationContext());
  }

  public void onCreateUserClicked(View view) {
    CreateUser("raushan","xyz","Raushan", "Sinha");
  }

  public  void CreateUser(String userId, String password, String fName, String lName){
    try {
      // Gets the data repository in write mode
      SQLiteDatabase db = myDB.getWritableDatabase();

// Create a new map of values, where column names are the keys
      ContentValues values = new ContentValues();
      values.put("userId", userId);
      values.put("password", password);
      values.put("FirstName", fName);
      values.put("LastName", lName);
      // Insert the new row, returning the primary key value of the new row
      long newRowId = db.insert("Users", null, values);

      Log.d("CreateUser", "User" + userId + " Created.");
    }
    catch (Exception ex)
    {
      Log.d("CreateUser", ex.getMessage());
    }
  }
}
