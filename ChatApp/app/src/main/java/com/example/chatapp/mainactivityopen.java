package com.example.chatapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;

public class mainactivityopen<DatabaseReference> extends AppCompatActivity {
    private Toolbar actionbar;
    private ViewPager vpMain;
    private TabLayout tabsMain;
    private TabsAdapter tabsAdapter;
    private Toolbar supportActionBar;
    private FirebaseUser currentUser;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init() {
        actionbar=(Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setTitle(R.string.app_name);
        vpMain=(ViewPager) findViewById(R.id.vpMain);
        tabsAdapter =new TabsAdapter(getSupportFragmentManager());
        vpMain.setAdapter(tabsAdapter);
        tabsMain=(TabLayout) findViewById(R.id.tabsMain);
        tabsMain.setupWithViewPager(vpMain);

    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivityopen);
        init();
    }
    @Override
    protected void onStart() {
        super.onStart();

            if(currentUser == null){
                Intent welcomeintent = new Intent(mainactivityopen.this , MainActivity.class);
                startActivity(welcomeintent);
                finish();
            }

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}
