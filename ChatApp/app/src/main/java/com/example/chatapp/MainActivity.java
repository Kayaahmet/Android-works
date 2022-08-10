package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Toolbar actionbar;
    private ViewPager vpMain;
    private TableLayout tabsMain;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;

 private Button btnWelcomeLogin, btnWelcomeRegister;
 public  void init(){
     btnWelcomeLogin = (Button) findViewById(R.id.btnWelcomeLogin);
     btnWelcomeRegister=(Button) findViewById(R.id.btnWelcomeRegister);


 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlogin = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentlogin);
            }


        });
        btnWelcomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentregister=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentregister);
            }
        });
    }


}
