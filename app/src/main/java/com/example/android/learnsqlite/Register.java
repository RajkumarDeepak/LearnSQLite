package com.example.android.learnsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

  SQLiteHelper myDB;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    myDB = new SQLiteHelper(this.getApplicationContext());
  }

  public void onbtnCreateUserClicked(View view){

    EditText userId = (EditText) findViewById(R.id.txtUserId);
    EditText pwd = (EditText) findViewById(R.id.txtPassword);
    EditText fName = (EditText) findViewById(R.id.txtFirstName);
    EditText lName = (EditText) findViewById(R.id.txtLastName);
    inesrtUser(userId.getText().toString(),pwd.getText().toString(),fName.getText().toString(),lName.getText().toString());
  }

  public  void inesrtUser(String userId, String password, String fName, String lName) {
    try {
      // Gets the data repository in write mode
      SQLiteDatabase db = myDB.getWritableDatabase();
//db.execSQL(("insert into "));
// Create a new map of values, where column names are the keys
      ContentValues values = new ContentValues();
      values.put("userId", userId);
      values.put("password", password);
      values.put("FirstName", fName);
      values.put("LastName", lName);
      // Insert the new row, returning the primary key value of the new row
      long newRowId = db.insert("Users", null, values);

      Log.d("CreateUser", "User" + userId + " Created.");
    } catch (Exception ex) {
      Log.d("CreateUser", ex.getMessage());
    }
  }
  }
