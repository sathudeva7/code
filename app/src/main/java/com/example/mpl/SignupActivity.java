package com.example.mpl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
   // public static final String ,"onsucess" = "TAG";
    EditText userName,eMail,passWord;
    Button register;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userName = findViewById(R.id.username);
        eMail =findViewById(R.id.email);
        passWord = findViewById(R.id.password);
        register = findViewById(R.id.register);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

       /* if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }*/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = eMail.getText().toString().trim();
                String password = passWord.getText().toString().trim();
                final String username = userName.getText().toString().trim();

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

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(SignupActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(SignupActivity.this, "Error ! Email is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                            Toast.makeText(SignupActivity.this, "user created",Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userId);
                            Map<String,Object> user = new HashMap<>();
                            user.put("uname",username);
                            user.put("email",email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG","onsucess:User profile created"+ userId);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }else{
                            Toast.makeText(SignupActivity.this, "Error is occured" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
