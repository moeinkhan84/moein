
package com.example.moein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewMessage = findViewById(R.id.textViewMessage);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if (username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "ورودی ندارد", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("moein") && password.equals("1234")) {
                        textViewMessage.setText("خوش آمدید!");
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("userName" ,username);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "رمز عبور یا نام کاربری اشتباه است", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
