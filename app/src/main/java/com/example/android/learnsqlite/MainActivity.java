package com.example.android.learnsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SQLiteHelper myDB = new SQLiteHelper(this.getApplicationContext());
  }

  public void GoToLogin(View view)
  {
    try {
      Intent i = new Intent(this.getApplicationContext(), Login.class);
      startActivity(i);
    }
    catch (Exception ex) {
      Log.d("GoToLogin",ex.getMessage());
    }
  }

  public void GoToRegister(View view)
  {
    try {
      Intent i = new Intent(this.getApplicationContext(), Register.class);
      startActivity(i);
    }
    catch (Exception ex){
      Log.d("GoToRegister",ex.getMessage());
    }
  }
}
