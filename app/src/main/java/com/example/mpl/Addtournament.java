package com.example.mpl;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

//import com.google.firebase.firestore.auth.User;

public class Addtournament extends AppCompatActivity {
    private static final String TAG = "Addtournament";    
        static String n;
        static String ov;
        static String numb1;
        DatePickerDialog picker;
        ImageView img;
        int day,month,year;
        static String tournament;
        Button button,button5;
        EditText text,text1,text2,text3,text4,text5,text0,t1,t11;
        TextView tex,tex1,tex2,tex3;
    private FirebaseAuth fAuth= FirebaseAuth.getInstance();;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    static String id;
   String userId = fAuth.getCurrentUser().getUid();
    private CollectionReference collectionReference = fStore.collection("users").document(userId).collection("tournament");
   // private DocumentReference documentReference;
   private DocumentReference documentReference1 = fStore.collection("users").document(userId).collection("tournament").document();
    private DocumentReference documentReference2;
    StorageReference storageReference;
    public static final String KEY_PREPS = "key_preps";
    public   static final  String KEY_TITLE="name_key";
    public   static final  String KEY_OVER="name_over";
    public   static final  String KEY_PLAYER="name_player";
    public   static final  String KEY_TEAM1="name_team1";
    public   static final  String KEY_TEAM2="name_team2";
    private String t01;
    private String t02;
    private String t03;
    private String t04;
    private String t05;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtournament);
        t11 = findViewById(R.id.pass11);
        t1=findViewById(R.id.t1);
            button5 =findViewById(R.id.button5);
        t1.setInputType(InputType.TYPE_NULL);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                 day = cldr.get(Calendar.DAY_OF_MONTH);
                 month = cldr.get(Calendar.MONTH);
                 year = cldr.get(Calendar.YEAR);

                picker= new DatePickerDialog(Addtournament.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        t1.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                picker.show();
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Addtournament.this,"date added",Toast.LENGTH_SHORT).show();
            }
        });

        img = findViewById(R.id.imageView2);
        text = findViewById(R.id.pass);

        text2 = findViewById(R.id.pass2);
        text3 = findViewById(R.id.pass3);
        tex = findViewById(R.id.text4);
        tex1 = findViewById(R.id.text3);
        button = findViewById(R.id.button2);
        text4 = findViewById(R.id.pass4);
        text5 = findViewById(R.id.pass5);
        tex2 = findViewById(R.id.text5);
        tex3 = findViewById(R.id.text6);

        text0 = findViewById(R.id.pass0);

        if(savedInstanceState != null){
            String savedTitle = savedInstanceState.getString(KEY_TITLE);
            text.setText(savedTitle);
            String savedOvers = savedInstanceState.getString(KEY_OVER);
            text0.setText(savedOvers);
            String savedPlayer = savedInstanceState.getString(KEY_PLAYER);
            t11.setText(savedPlayer);
            String savedTeam1 = savedInstanceState.getString(KEY_TEAM1);
            text4.setText(savedTeam1);
            String savedTeam2 = savedInstanceState.getString(KEY_TEAM2);
            text5.setText(savedTeam2);
        }else{
            Toast.makeText(this,"New Entry",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
       outState.putString(KEY_TITLE,text.getText().toString());
        outState.putString(KEY_OVER,text0.getText().toString());
        outState.putString(KEY_PLAYER,t11.getText().toString());
        outState.putString(KEY_TEAM1,text2.getText().toString());
        outState.putString(KEY_TEAM2,text3.getText().toString());
        super.onSaveInstanceState(outState);
    }




    public void next(View v){
        String name = text.getText().toString().trim();
        tournament = name;

        String name1=text2.getText().toString().trim();
        String name2=text3.getText().toString().trim();

        String numb = t11.getText().toString().trim();
        String over = text0.getText().toString().trim();

       // collectionReference.add(user);

        final Map<String,Object> teams = new HashMap<>();
        teams.put("title",name);


        teams.put("NoOfplayers",numb);
        teams.put("Over",over);
        teams.put("Team1",name1);
        teams.put("Team2",name2);

        teams.put("day",day);
        teams.put("month",month);
        teams.put("year",year);
        teams.put("desc",name1+" Vs "+name2);
        documentReference1.set(teams);
        id = documentReference1.getId();
        documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    numb1 = documentSnapshot.getString("NoOfplayers");
                    ov = documentSnapshot.getString("Over");
            }
        });
        documentReference2 = fStore.collection("tournament").document(tournament);
        documentReference2.set(teams);
        saveData();
        Toast.makeText(Addtournament.this,"added",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Addtournament.this, teams.class);
        startActivity(intent);
        finish();
        loadData();
        updateViews();

    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREPS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TITLE,text.getText().toString());
        editor.putString(KEY_OVER,text0.getText().toString());

        editor.putString(KEY_TEAM1,text2.getText().toString());
        editor.putString(KEY_TEAM2,text3.getText().toString());
        editor.apply();
    }

    public void loadData(){
            SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREPS,MODE_PRIVATE);
            t01 = sharedPreferences.getString(KEY_TITLE,"");
             t02 = sharedPreferences.getString(KEY_OVER,"");

        t04 = sharedPreferences.getString(KEY_TEAM1,"");
        t05 = sharedPreferences.getString(KEY_TEAM2,"");
        }

        public void updateViews(){
            text.setText(t01);
            text0.setText(t02);
            t11.setText(t03);
            text2.setText(t04);
            text3.setText(t05);
        }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Addtournament.this, Home.class);
        startActivity(intent);
        finish();
    }
}
