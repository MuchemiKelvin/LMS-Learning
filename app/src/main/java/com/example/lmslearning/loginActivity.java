package com.example.lmslearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
    TextView tv;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        edUsername= findViewById(R.id.editTextLoginUsername);
        edPassword= findViewById(R.id.editTextLoginPassword);
        btn= findViewById(R.id.buttonLogin);
        tv= findViewById(R.id.textLoginNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= edUsername.getText().toString();
                String password= edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"lmslearning", null, 1);

                if (username.length()==0||password.length()==0) {
                    Toast.makeText(getApplicationContext(), "Please fill all Field", Toast.LENGTH_SHORT).show();
                }else {
                    if(db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.apply();
                        startActivity(new Intent(loginActivity.this, DashboardActivity.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,RegisterActivity.class));
            }
        });

    }
}