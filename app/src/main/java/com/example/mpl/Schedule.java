package com.example.mpl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule extends AppCompatActivity  {
    TextView t01,t13,t31,t32,t33,t41,t43,t51,t52,t53,t03,t44,t34,a31,a32,a33;
    Button button,t61,t62,t63,t64,t71,t72,t73,t74,t81,t82,t83,t84,button1;
    Spinner spinner,spinner1,spinner2,spinner3;
    RadioButton radio1,radio2;
    private FirebaseAuth fAuth= FirebaseAuth.getInstance();;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    String userId = fAuth.getCurrentUser().getUid();
    String id = Addtournament.id;
    StorageReference storageReference;
    String id1 = score.id1;
    String tournament=Addtournament.tournament;
    Boolean flag=true;
    Boolean flag1=false;
    String bowlplayer,batplayer1,batplayer2;
    String t2,run;
    String t3;
    int y=0;
    private CollectionReference collectionReference = fStore.collection("users").document(userId).collection("tournament");
    private CollectionReference collectionReference3 = fStore.collection("tournament").document(tournament).collection("innings1");
    private CollectionReference collectionReference1 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("team1");
    private DocumentReference documentReference = fStore.collection("users").document(userId).collection("tournament").document(id).collection("innings1").document("scoreTeam1");
    private DocumentReference documentReference1 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("innings1").document("bowlerTeam2");
    private CollectionReference collectionReference2 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("team2");
   // RadioButton batsman;
    RadioGroup radioGroup;
    String a;
    String r;
    String t="";
    String s="";
    int i=0;
    int w = 0;
    int b = 0;
    int r1 = 0;
    int r2 = 0;
    int b1 = 0;
    int b2 = 0;
    int r3 = 0;
    int e = 0;
    int w3 = 0;
    String x;
    static int size;
    int m,l,o;
    String u;
    String d;
    String z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        button = findViewById(R.id.button);
        storageReference = FirebaseStorage.getInstance().getReference();

        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner4);

        final List<String> teaminput = new ArrayList<>();

        final ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,teaminput);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for(QueryDocumentSnapshot documentSnapshot: task.getResult()){
                        String[] team1 = {"Team1","Team2"};
                        String team = documentSnapshot.getString("Team1");
                        String team2 = documentSnapshot.getString("Team2");
                        teaminput.add(0,team);
                        teaminput.add(1,team2);
                    }
                    aa.notifyDataSetChanged();

                }
            }
        });


        final List<String> bowlinput = new ArrayList<>();

        final ArrayAdapter aa4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bowlinput);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner1.setAdapter(aa4);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               bowlplayer= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        collectionReference2.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for(QueryDocumentSnapshot documentSnapshot: task.getResult()){
                        String player1 = documentSnapshot.getString("player1");
                        String player2 = documentSnapshot.getString("player2");
                        String player3 = documentSnapshot.getString("player3");
                        String player4 = documentSnapshot.getString("player4");
                        String player5 = documentSnapshot.getString("player5");
                        String player6 = documentSnapshot.getString("player6");
                        String player7 = documentSnapshot.getString("player7");
                        String player8 = documentSnapshot.getString("player8");
                        String player9 = documentSnapshot.getString("player9");
                        String player10 = documentSnapshot.getString("player10");
                        String player11 = documentSnapshot.getString("player11");
                        bowlinput.add(0,player1);
                        bowlinput.add(1,player2);
                        bowlinput.add(2,player3);
                        bowlinput.add(3,player4);
                        bowlinput.add(4,player5);
                        bowlinput.add(5,player6);
                        bowlinput.add(6,player7);
                        bowlinput.add(7,player8);
                        bowlinput.add(8,player9);
                        bowlinput.add(9,player10);
                        bowlinput.add(10,player11);

                    }
                    aa4.notifyDataSetChanged();

                }
            }
        });


        spinner2 = findViewById(R.id.spinner2);

        final List<String> playerinput = new ArrayList<>();

        final ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,playerinput);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner2.setAdapter(aa1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batplayer1= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        collectionReference1.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for(QueryDocumentSnapshot documentSnapshot: task.getResult()){
                        String player1 = documentSnapshot.getString("player1");
                        String player2 = documentSnapshot.getString("player2");
                        String player3 = documentSnapshot.getString("player3");
                        String player4 = documentSnapshot.getString("player4");
                        String player5 = documentSnapshot.getString("player5");
                        String player6 = documentSnapshot.getString("player6");
                        String player7 = documentSnapshot.getString("player7");
                        String player8 = documentSnapshot.getString("player8");
                        String player9 = documentSnapshot.getString("player9");
                        String player10 = documentSnapshot.getString("player10");
                        String player11 = documentSnapshot.getString("player11");
                        playerinput.add(0,player1);
                        playerinput.add(1,player2);
                        playerinput.add(2,player3);
                        playerinput.add(3,player4);
                        playerinput.add(4,player5);
                        playerinput.add(5,player6);
                        playerinput.add(6,player7);
                        playerinput.add(7,player8);
                        playerinput.add(8,player9);
                        playerinput.add(9,player10);
                        playerinput.add(10,player11);

                    }
                    aa1.notifyDataSetChanged();

                 //   radio1.setText(text);
                }
            }
        });

        spinner3 = findViewById(R.id.spinner3);

        final List<String> playerinput1 = new ArrayList<>();

        final ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,playerinput1);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner3.setAdapter(aa2);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batplayer2= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        collectionReference1.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for(QueryDocumentSnapshot documentSnapshot: task.getResult()){
                        String player1 = documentSnapshot.getString("player1");
                        String player2 = documentSnapshot.getString("player2");
                        String player3 = documentSnapshot.getString("player3");
                        String player4 = documentSnapshot.getString("player4");
                        String player5 = documentSnapshot.getString("player5");
                        String player6 = documentSnapshot.getString("player6");
                        String player7 = documentSnapshot.getString("player7");
                        String player8 = documentSnapshot.getString("player8");
                        String player9 = documentSnapshot.getString("player9");
                        String player10 = documentSnapshot.getString("player10");
                        String player11 = documentSnapshot.getString("player11");
                        playerinput1.add(0,player1);
                        playerinput1.add(1,player2);
                        playerinput1.add(2,player3);
                        playerinput1.add(3,player4);
                        playerinput1.add(4,player5);
                        playerinput1.add(5,player6);
                        playerinput1.add(6,player7);
                        playerinput1.add(7,player8);
                        playerinput1.add(8,player9);
                        playerinput1.add(9,player10);
                        playerinput1.add(10,player11);
                    }
                    aa2.notifyDataSetChanged();

                  //  radio2.setText(text1);
                }
            }
        });

        t01 = findViewById(R.id.t01);
        t03 = findViewById(R.id.t03);
        t13 = findViewById(R.id.t13);
        t31 = findViewById(R.id.t31);
        t32 = findViewById(R.id.t32);
        t33 = findViewById(R.id.t33);
        t41 = findViewById(R.id.t41);
        t34 = findViewById(R.id.t34);
        t43 = findViewById(R.id.t43);
        t51 = findViewById(R.id.t51);

        t53 = findViewById(R.id.t53);
        t61 = findViewById(R.id.t61);
        t62 = findViewById(R.id.t62);
        t63 = findViewById(R.id.t63);
        t64 = findViewById(R.id.t64);
        t71 = findViewById(R.id.t71);
        t72 = findViewById(R.id.t72);
        t73 = findViewById(R.id.t73);
        t74 = findViewById(R.id.t74);
        t81 = findViewById(R.id.t81);
        t82 = findViewById(R.id.t82);
        t83 = findViewById(R.id.t83);
        t84 = findViewById(R.id.t84);
        radioGroup = findViewById(R.id.batsman);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);

        button1=findViewById(R.id.button1);


    t61.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(flag==true){
                r1=r1+6;
                b1=b1+1;
                 a = r1+ "("+b1+")";
                t31.setText(a);
            }
            else if(flag1 == true){
                r2=r2+6;
                b2=b2+1;
                 r=r2+"("+b2+")";
                t32.setText(r);
            }
            i = i+6;
            b = b+1;
            r3 = r3+6;
            t=t+" 6";
            t43.setText(t);
            x = r3+"/"+w3;
            t33.setText(x);
            t01.setText(Integer.toString(i));
            m= b/6;
            l=b%6;
            s=m+"."+l;
            t13.setText(s);
            if(l==0){
                t="";
                r3=0;w3=0;
                t43.setText(t);
                Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                Map<String,Object> run = new HashMap<>();
                run.put(bowlplayer,t33.getText().toString());
                if(m==1){
                    documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("TAG","onsucess:score added");
                        }
                    });
                }else{
                    documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("TAG","onsucess:score added");
                        }
                    });
                }
                t33.setText(t);
            }

        }
    });

        t62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+5;
                    b1=b1+1;
                     a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+5;
                    b2=b2+1;
                    r=r2+"("+b2+")";
                    t32.setText(r);
                }
                i = i+5;
                b = b+1;
                r3 = r3+5;
                x = r3+"/"+w3;
                t=t+" 5";
                t43.setText(t);
                t33.setText(x);
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });

        t63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+4;
                    b1=b1+1;
                     a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+4;
                    b2=b2+1;
                    r=r2+"("+b2+")";
                    t32.setText(r);
                }
                i = i+4;
                b= b+1;
                r3 = r3+4;
                x = r3+"/"+w3;
                t=t+" 4";
                t43.setText(t);
                t33.setText(x);
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    r3=0;
                    w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });

        t64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+3;
                    b1=b1+1;
                     a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+3;
                    b2=b2+1;
                     r=r2+"("+b2+")";
                    t32.setText(r);
                }
                i = i+3;
                b=b+1;
                r3 = r3+3;
                x = r3+"/"+w3;
                t=t+" 3";
                t43.setText(t);
                t33.setText(x);
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });
        t74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+2;
                    b1=b1+1;
                     a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+2;
                    b2=b2+1;
                     r=r2+"("+b2+")";
                    t32.setText(r);
                }
                i = i+2;
                b=b+1;
                t=t+" 2";
                t43.setText(t);
                r3 = r3+2;
                x = r3+"/"+w3;
                t33.setText(x);
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });

        t73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+1;
                    b1=b1+1;
                     a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+1;
                    b2=b2+1;
                     r=r2+"("+b2+")";
                    t32.setText(r);
                }
                i = i+1;
                b=b+1;
                r3 = r3+1;
                t=t+" 1";
                t43.setText(t);
                x = r3+"/"+w3;
                t33.setText(x);
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });
        t72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+0;
                    b1=b1+1;
                    a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+0;
                    b2=b2+1;
                    r=r2+"("+b2+")";
                    t32.setText(r);
                }
                i = i+0;
                t=t+" 0";
                t43.setText(t);
                b=b+1;
                r3 = r3+0;
                x = r3+"/"+w3;
                t33.setText(x);
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });

        t71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              y=y+1;
                if(flag==true){
                    Map<String,Object> user = new HashMap<>();
                    user.put(batplayer1,t31.getText().toString());
                    Map<String,Object> bowler = new HashMap<>();
                    bowler.put(batplayer1,bowlplayer);
                    if(y==1){
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:player created");
                            }
                        });
                        collectionReference3.document("batsman").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference3.document("bowler").set(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });
                    }else{
                        documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:player created");
                            }
                        });
                        collectionReference3.document("batsman").update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference3.document("bowler").update(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });
                    }

                    r1=0;
                    b1=0;
                     a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    Map<String,Object> user = new HashMap<>();
                    user.put(batplayer2,t32.getText().toString());
                    Map<String,Object> bowler = new HashMap<>();
                    bowler.put(batplayer2,bowlplayer);
                    if(y==1){
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:player created");
                            }
                        });
                        collectionReference3.document("batsman").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference3.document("bowler").set(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });
                    }else{
                        documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:player created");
                            }
                        });
                        collectionReference3.document("batsman").update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference3.document("bowler").update(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });
                    }
                    r2=0;
                    b2=0;
                     r=r2+"("+b2+")";
                    t32.setText(r);
                }
                w = w+1;
                b=b+1;
                t=t+" wk";
                t43.setText(t);
                r3 = r3+0;
                w3=w3+1;
                x = r3+"/"+w3;
                Toast.makeText(Schedule.this,"Change Batsman",Toast.LENGTH_SHORT).show();
                t33.setText(x);
                t03.setText(Integer.toString(w));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });

                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });

                    }
                    t33.setText(t);

                }

            }
        });

        t84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i+1;
                r3 = r3+1;
                x = r3+"/"+w3;
                t33.setText(x);
                t=t+" wd";
                e=e+1;
                t34.setText(Integer.toString(e));
                t43.setText(t);
                t01.setText(Integer.toString(i));
            }
        });

        t83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i+1;
                r3 = r3+1;
                x = r3+"/"+w3;
                t=t+" nb";
                t43.setText(t);
                t33.setText(x);
                e=e+1;
                t34.setText(Integer.toString(e));
                t01.setText(Integer.toString(i));

            }
        });
        t82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+0;
                    b1=b1+1;
                    a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+0;
                    b2=b2+1;
                    r=r2+"("+b2+")";
                    t32.setText(r);
                }
                t=t+" b";
                t43.setText(t);
                i = i+1;
                b=b+1;
                e=e+1;
                t34.setText(Integer.toString(e));
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);
                }
            }
        });

        t81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==true){
                    r1=r1+0;
                    b1=b1+1;
                    a = r1+ "("+b1+")";
                    t31.setText(a);
                }
                else if(flag1 == true){
                    r2=r2+0;
                    b2=b2+1;
                    r=r2+"("+b2+")";
                    t32.setText(r);
                }
                t=t+" lb";
                t43.setText(t);
                i = i+1;
                b=b+1;
                e=e+1;
                t34.setText(Integer.toString(e));
                t01.setText(Integer.toString(i));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t13.setText(s);
                if(l==0){
                    t="";r3=0;w3=0;
                    t43.setText(t);
                    Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
                    Map<String,Object> run = new HashMap<>();
                    run.put(bowlplayer,t33.getText().toString());
                    if(m==1){
                        documentReference1.set(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }else{
                        documentReference1.update(run).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added");
                            }
                        });
                    }
                    t33.setText(t);

                }
            }
        });
        if( b%6 == 0){
            Toast.makeText(Schedule.this,"Over change",Toast.LENGTH_SHORT).show();
            Log.d("overfin","ovrfinish");
        }

        if(t43.length()> 7){
            t="";
            t43.setText(t);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o=o+1;
                String score1 = "total";
                Map<String,Object> score = new HashMap<>();
                score.put(score1,t01.getText().toString());
                score.put("w",t03.getText().toString());
                score.put(batplayer1,t31.getText().toString());
                score.put(batplayer2,t32.getText().toString());
                documentReference.update(score).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","onsucess:score added");
                    }
                });
                collectionReference3.document("batsman").update(score).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","onsucess:TOURNAMENT score added");

                    }
                });
                Toast.makeText(Schedule.this,"Updated",Toast.LENGTH_SHORT).show();




            }
        });




    }
    @Override
    public void onBackPressed() {
        Toast.makeText(Schedule.this,"Disabled",Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_card_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_score:
                return true;
            case R.id.sec_in:
                startActivity(new Intent(this,teams2.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void click(View view) {
        boolean checked = ((RadioButton) view).isChecked();
                switch (view.getId()) {
                    case R.id.radio1:
                        if (checked)
                            flag = true;
                        flag1 = false;
                        break;
                    case R.id.radio2:
                        if (checked)
                            flag1 = true;
                        flag = false;
                        break;
                }

        }




    public void updatebowl(){
        if(l==0){
            String run = t2+"run";
            Map<String,Object> user = new HashMap<>();

            user.put("player",t2);
            user.put(run,t31.getText().toString());
            if(y==1){
                documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","onsucess:player created");
                    }
                });
            }else{
                documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","onsucess:player created");
                    }
                });
            }
        }
    }
}
