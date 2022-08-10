package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity extends AppCompatActivity {
    private Toolbar actionbarRegister;
    private EditText txtusername,txtEmail,txtPassword;
    private Button btnregister;
    private FirebaseAuth Auth;
    private DatabaseReference myref;


    public void init() {
        actionbarRegister=(Toolbar) findViewById(R.id.actionbarregister);
        setSupportActionBar(actionbarRegister);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Auth=FirebaseAuth.getInstance();

        txtusername=(EditText) findViewById(R.id.txtusername);
        txtEmail=(EditText) findViewById(R.id.txtemail);
        txtPassword=(EditText) findViewById(R.id.txtpassword);
        btnregister=(Button) findViewById(R.id.btnregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });


    }




    private void createNewAccount() {
        String username= txtusername.getText().toString();
        String Email=txtEmail.getText().toString();
        String Password=txtPassword.getText().toString();
        Auth=FirebaseAuth.getInstance();

        if (TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Email area cant be null",Toast.LENGTH_LONG).show();


        }else if (TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Password area cant be null",Toast.LENGTH_LONG).show();
        }else {
            Auth.createUserWithEmailAndPassword(Email, Password).addOnSuccessListener(RegisterActivity.this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {


                    Toast.makeText(RegisterActivity.this,"Your account has been succesfully created",Toast.LENGTH_LONG).show();
                    Intent loginIntent= new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }





            });


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        Auth = FirebaseAuth.getInstance();

    }
}
