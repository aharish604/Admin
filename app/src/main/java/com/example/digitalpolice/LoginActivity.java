package com.example.digitalpolice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    static String username="appolice@gmail.com";
    static String password="123456";

    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.login_user);
        pass=findViewById(R.id.login_pin);

        Toast.makeText(this, ""+username, Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {

        if(username.equals(user.getText().toString()) && password.equals(pass.getText().toString())){
            Toast.makeText(this, "LoginSucess", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this,Home.class);

            startActivity(intent);


        }

        else
        {

            Toast.makeText(this, "Loging Faild", Toast.LENGTH_SHORT).show();

        }

    }
    }

