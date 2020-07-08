package com.example.mpl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText eMail,passWord;
    Button button;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eMail = findViewById(R.id.em);
        passWord=findViewById(R.id.pass);
        button = findViewById(R.id.buttonone);

        fAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eMail.getText().toString().trim();
                String password = passWord.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    eMail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passWord.setError("Password is required");
                    return;
                }
                if(password.length() < 6){
                    passWord.setError("Password must be higher than 6 characters");
                }

               fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(LoginActivity.this, "login sucessfully",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),Home.class));
                       }else{
                           Toast.makeText(LoginActivity.this, "Error is occured" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });


            }
        });
    }
}
