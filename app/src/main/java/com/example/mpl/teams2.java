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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class teams2 extends AppCompatActivity {
    TextView t01,t13,t31,t32,t33,t41,t43,t51,t52,t53,t03,t34,a31,a32,a33,t11;
    Button button,t61,t62,t63,t64,t71,t72,t73,t74,t81,t82,t83,t84,button1;
    Spinner spinner,spinner4,spinner2,spinner3;
    RadioButton radio1,radio2;
    RadioGroup radioGroup;
    String ov=Addtournament.ov;
    int o1=Integer.parseInt(ov);
    int br1;
    private FirebaseAuth fAuth= FirebaseAuth.getInstance();;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    String userId = fAuth.getCurrentUser().getUid();
    String id = Addtournament.id;
    String numb1 = Addtournament.numb1;
    String tournament=Addtournament.tournament;
    String batplayer,batplayer1,bowlplayer,batplayer2;
    int r1=0,b1=0,r2=0,b2=0,b=0,m,l,r3=0,w3=0,w=0,i=0,e=0,z=0,p,c;
    String x,t="",s="",a,r,y,t2,t3,k;
    Boolean flag=true;
    Boolean flag1=false;
    private CollectionReference collectionReference = fStore.collection("users").document(userId).collection("tournament");
    private CollectionReference collectionReference4 = fStore.collection("tournament").document(tournament).collection("innings2");
    private DocumentReference documentReference2 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("innings1").document("scoreTeam1");
    private DocumentReference documentReference = fStore.collection("users").document(userId).collection("tournament").document(id).collection("innings2").document("scoreTeam2");
    private DocumentReference documentReference1 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("innings2").document("bowlerTeam1");
    private CollectionReference collectionReference2 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("team2");
    private CollectionReference collectionReference3 = fStore.collection("users").document(userId).collection("tournament").document(id).collection("team1");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams2);
        Query query = fStore.collection("users").document(userId).collection("tournament");
        t01 = findViewById(R.id.t01);
        t03 = findViewById(R.id.t03);
        t13 = findViewById(R.id.t13);
        t11 = findViewById(R.id.t11);
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


        spinner2=(Spinner) findViewById(R.id.spinner2);
        spinner3=(Spinner) findViewById(R.id.spinner3);
        spinner4=(Spinner) findViewById(R.id.spinner4);
        radioGroup = findViewById(R.id.batsman);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);

        spinner=(Spinner) findViewById(R.id.spinner);
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
        spinner2.setAdapter(aa4);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batplayer1= parent.getItemAtPosition(position).toString();
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


        spinner3 = findViewById(R.id.spinner3);

        final List<String> playerinput1 = new ArrayList<>();

        final ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,playerinput1);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner3.setAdapter(aa2);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batplayer= parent.getItemAtPosition(position).toString();
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

        final List<String> playerinput = new ArrayList<>();

        final ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,playerinput);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner4.setAdapter(aa1);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bowlplayer= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        collectionReference3.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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



        documentReference2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                t13.setText(documentSnapshot.getString("total"));
                 p=Integer.parseInt(documentSnapshot.getString("total"));
                 c=p-i+1;
                br1=(o1*6)-b;
                 k=c+" runs needed in "+br1+" balls";
                 t11.setText(k);

            }
        });



        t61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+6; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+6; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+6; //team score
                b = b+1; //total balls
                r3 = r3+6; //bowler run
                t=t+" 6"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                t03.setText(s); //show over in app
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+4; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+4; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }


                i = i+4; //team score
                b = b+1; //total balls
                r3 = r3+4; //bowler run
                t=t+" 4"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+3; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+3; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+3; //team score
                c=p-i;
                br1=(o1*3)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                b = b+1; //total balls
                r3 = r3+3; //bowler run
                t=t+" 3"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+5; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+5; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }

                i = i+5; //team score
                b = b+1; //total balls
                r3 = r3+5; //bowler run
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                t=t+" 5"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+2; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+2; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+2; //team score

                b = b+1; //total balls
                r3 = r3+2; //bowler run
                t=t+" 2"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+1; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+1; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+1; //team score
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                b = b+1; //total balls
                r3 = r3+1; //bowler run
                t=t+" 1"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+0; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+0; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+0; //team score

                b = b+1; //total balls
                r3 = r3+0; //bowler run
                t=t+" 0"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    r3=0;
                    w3=0;
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
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                z=z+1;
                String play = "run"+z;
                if(flag==true){
                    Map<String,Object> user = new HashMap<>();
                    user.put(batplayer1,t31.getText().toString());
                    Map<String,Object> bowler = new HashMap<>();
                    bowler.put(batplayer1,bowlplayer);
                    if(z==1){
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:player created");
                            }
                        });
                        collectionReference4.document("batsman").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference4.document("bowler").set(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
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
                        collectionReference4.document("batsman").update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference4.document("bowler").update(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
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
                    user.put(batplayer,t32.getText().toString());
                    Map<String,Object> bowler = new HashMap<>();
                    bowler.put(batplayer,bowlplayer);
                    if(z==1){
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:player created");
                            }
                        });
                        collectionReference4.document("batsman").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference4.document("bowler").set(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
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
                        collectionReference4.document("batsman").update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onsucess:score added to tournament");
                            }
                        });

                        collectionReference4.document("bowler").update(bowler).addOnSuccessListener(new OnSuccessListener<Void>() {
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
                i=i+0;
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                b=b+1;
                t=t+" wk";
                t43.setText(t);
                r3 = r3+0;
                y=i+"/"+w; //add team score and wic
                t01.setText(y);
                w3=w3+1;
                x = r3+"/"+w3;
                t33.setText(x);
               // t03.setText(Integer.toString(w));
                m= b/6;
                l=b%6;
                s=m+"."+l;
                t03.setText(s);
                if(l==0){
                    t="";
                    t43.setText(t);
                    r3=0;
                    w3=0;
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
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();

                }

            }
        });
        t81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+0; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+0; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+1; //team score
                b = b+1; //total balls
                r3 = r3+0; //bowler run
                e=e+1;
                t34.setText(Integer.toString(e));
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                t=t+" lb"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    t43.setText(t);
                    r3=0;
                    w3=0;
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
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+0; //player1 run
                    b1=b1+1; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+0; //player2 run
                    b2=b2+1;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+1; //team score
                b = b+1; //total balls
                r3 = r3+0; //bowler run
                e=e+1;
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                t34.setText(Integer.toString(e));
                t=t+" b"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    t43.setText(t);
                    r3=0;
                    w3=0;
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
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+0; //player1 run
                    b1=b1+0; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+0; //player2 run
                    b2=b2+0;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+1; //team score
                b = b+0; //total balls
                r3 = r3+1; //bowler run
                e=e+1;
                t34.setText(Integer.toString(e));
                t=t+" nb"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                x = r3+"/"+w3; //bolwer run and wicket
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    t43.setText(t);

                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });
        t84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==true){
                    r1=r1+0; //player1 run
                    b1=b1+0; //player1 ball
                    a = r1+ "("+b1+")"; //player 1 score with run and ball
                    t31.setText(a); //show player1 score in app
                }
                else if(flag1 == true){
                    r2=r2+0; //player2 run
                    b2=b2+0;    //player 2 ball
                    r=r2+"("+b2+")"; //player 2 score with run and ball
                    t32.setText(r);//show player2 score in app
                }
                i = i+1; //team score
                e=e+1;
                t34.setText(Integer.toString(e));
                b = b+0; //total balls
                r3 = r3+1; //bowler run
                t=t+" wd"; //add run in thisover box
                t43.setText(t);//show thisover run in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                x = r3+"/"+w3; //bolwer run and wicket
                t33.setText(x); //show bowler run and wic in app
                y=i+"/"+w; //add team score and wic
                t01.setText(y); //show team score and wic in app
                m= b/6; // to calculate over
                l=b%6; // to calculate over
                s=m+"."+l; //over
                t03.setText(s); //show over in app
                c=p-i;
                br1=(o1*6)-b;
                k=c+1+" runs needed in "+br1+" balls";
                t11.setText(k);
                if(l==0){
                    t=""; //change over
                    t43.setText(t);
                    Toast.makeText(teams2.this,"Over change",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
    @Override
    public void onBackPressed() {
        Toast.makeText(teams2.this,"Disabled",Toast.LENGTH_SHORT).show();

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
                String score1 = "total";
                Map<String,Object> score = new HashMap<>();
                score.put(score1,t01.getText().toString());
                score.put("w",Integer.toString(w));
                score.put(batplayer1,t31.getText().toString());
                score.put(batplayer,t32.getText().toString());
                documentReference.update(score).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","onsucess:score added");
                    }
                });
                collectionReference4.document("batsman").update(score).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG","onsucess:TOURNAMENT score added");

                    }
                });
                return true;
            case R.id.sec_in:
                startActivity(new Intent(this,Home.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void click1(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case  R.id.radio1:
                if(checked)
                    flag=true;
                    flag1 = false;
                break;
            case R.id.radio2:
                if(checked)
                    flag1=true;
                    flag = false;
                break;
            default:
                Toast.makeText(teams2.this,"Select Batsman by tick the button",Toast.LENGTH_SHORT).show();
        }

    }

}
