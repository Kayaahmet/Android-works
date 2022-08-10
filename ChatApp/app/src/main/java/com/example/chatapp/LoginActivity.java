package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
private Toolbar  actionbarlogin;
public void init(){
    actionbarlogin=(Toolbar) findViewById(R.id.actionbarlogin);
    setSupportActionBar(actionbarlogin);
    getSupportActionBar().setTitle("Login");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
}
