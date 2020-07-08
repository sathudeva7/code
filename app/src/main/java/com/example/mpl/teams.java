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

public class teams extends AppCompatActivity {
    EditText t11,t12,t13,t21,t22,t23,t31,t32,t33,t41,t42,t43,t51,t52,t53,t61,t62,t63,t71,t72,t73,t81,t82,t83,t101,t103,t111,t113,t121,t123;
    Button button;
    private FirebaseAuth fAuth= FirebaseAuth.getInstance();
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    String userId = fAuth.getCurrentUser().getUid();

    String id = Addtournament.id;

    private CollectionReference collectionReference = fStore.collection("users").document(userId).collection("tournament").document(id).collection("team1");
    private CollectionReference collectionReference1 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("team2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        button = findViewById(R.id.button);
        t11 = findViewById(R.id.t11);
        t12 = findViewById(R.id.t12);
        t13 = findViewById(R.id.t13);
        t21 = findViewById(R.id.t21);

        t23 = findViewById(R.id.t23);
        t31 = findViewById(R.id.t31);

        t33 = findViewById(R.id.t33);
        t41 = findViewById(R.id.t41);

        t43 = findViewById(R.id.t43);
        t51 = findViewById(R.id.t51);

        t53 = findViewById(R.id.t53);
        t61 = findViewById(R.id.t61);

        t63 = findViewById(R.id.t63);
        t71 = findViewById(R.id.t71);

        t73 = findViewById(R.id.t73);
        t81 = findViewById(R.id.t81);

        t83 = findViewById(R.id.t83);

        t101 = findViewById(R.id.t101);
        t103 = findViewById(R.id.t103);
        t113 = findViewById(R.id.t113);
        t111 = findViewById(R.id.t111);
        t123 = findViewById(R.id.t123);
        t121 = findViewById(R.id.t121);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = t11.getText().toString().trim();
                String name2 = t21.getText().toString().trim();
                String name3 = t31.getText().toString().trim();
                String name4 = t41.getText().toString().trim();
                String name5 = t51.getText().toString().trim();
                String name6 = t61.getText().toString().trim();
                String name7 = t71.getText().toString().trim();
                String name8 = t81.getText().toString().trim();
                String name9 = t101.getText().toString().trim();
                String name10 = t111.getText().toString().trim();
                String name11 = t121.getText().toString().trim();



                String s1 = t13.getText().toString().trim();
                String s2 = t23.getText().toString().trim();
                String s3 = t33.getText().toString().trim();
                String s4 = t43.getText().toString().trim();
                String s5 = t53.getText().toString().trim();
                String s6 = t63.getText().toString().trim();
                String s7 = t73.getText().toString().trim();
                String s8 = t83.getText().toString().trim();
                String s9 = t103.getText().toString().trim();
                String s10 = t113.getText().toString().trim();
                String s11 = t123.getText().toString().trim();

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
                players.put("player10",name10);
                players.put("player11",name11);


                final Map<String,Object> score = new HashMap<>();
                score.put("player1",s1);
                score.put("player2",s2);
                score.put("player3",s3);
                score.put("player4",s4);
                score.put("player5",s5);
                score.put("player6",s6);
                score.put("player7",s7);
                score.put("player8",s8);
                score.put("player9",s9);
                score.put("player10",s10);
                score.put("player11",s11);

                collectionReference.add(players);

                collectionReference1.add(score);
                Toast.makeText(teams.this,"added",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(teams.this, Schedule.class);
                startActivity(intent);
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(teams.this, Addtournament.class);
        startActivity(intent);
        finish();
    }
}
