package com.example.mpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class team3 extends AppCompatActivity {
    Button button;
    EditText text1,text2,text3,text4,text5,text6,text7,text8,text9;
    private FirebaseAuth fAuth= FirebaseAuth.getInstance();;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    String userId = fAuth.getCurrentUser().getUid();
    String id = Addtournament.id;
    private CollectionReference collectionReference = fStore.collection("users").document(userId).collection("tournament").document(id).collection("teams3");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team3);
        text1=findViewById(R.id.pass1);
        text2=findViewById(R.id.pass3);
        text3=findViewById(R.id.pass4);
        text4=findViewById(R.id.pass5);
        text5=findViewById(R.id.pass6);
        text6=findViewById(R.id.pass7);
        text7=findViewById(R.id.pass8);
        text8=findViewById(R.id.pass9);
        text9=findViewById(R.id.pass10);
        button=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = text1.getText().toString().trim();
                String name2 = text2.getText().toString().trim();
                String name3 = text3.getText().toString().trim();
                String name4 = text4.getText().toString().trim();
                String name5 = text5.getText().toString().trim();
                String name6 = text6.getText().toString().trim();
                String name7 = text7.getText().toString().trim();
                String name8 = text8.getText().toString().trim();
                String name9 = text9.getText().toString().trim();


                final Map<String,Object> players = new HashMap<>();
                players.put("player1",name1);
                players.put("player2",name2);
                players.put("player3",name3);
                players.put("player4",name4);
                players.put("player5",name5);
                players.put("player6",name6);
                players.put("player7",name7);
                players.put("player8",name8);
                players.put("player9",name9);

                collectionReference.add(players);
                Toast.makeText(team3.this,"added",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(team3.this, team4.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
