package com.example.mpl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class score extends AppCompatActivity {
    EditText t11,t12,t13,t21,t22,t23,t31,t32,t33,t41,t42,t43,t51,t52,t53,t61,t62,t63,t71,t72,t73,t81,t82,t83,t93,t101,t102,t103,t111,t112,t113,t121,t122,t123,t131,t132,t133;
    Button button;
    private FirebaseAuth fAuth= FirebaseAuth.getInstance();;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    int j;

    String idx = team4.idx;
    static String id1;

    private DocumentReference documentReference = fStore.collection("tournament").document(idx).collection("innings1").document("batsman");
    private DocumentReference documentReference1 = fStore.collection("tournament").document(idx).collection("innings1").document("bowler");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        t11 = findViewById(R.id.t11);
        t12 = findViewById(R.id.t12);
        t13 = findViewById(R.id.t13);
        t21 = findViewById(R.id.t21);
        t22 = findViewById(R.id.t22);
        t23 = findViewById(R.id.t23);
        t31 = findViewById(R.id.t31);
        t32 = findViewById(R.id.t32);
        t33 = findViewById(R.id.t33);
        t41 = findViewById(R.id.t41);
        t42 = findViewById(R.id.t42);
        t43 = findViewById(R.id.t43);
        t51 = findViewById(R.id.t51);
        t52 = findViewById(R.id.t52);
        t53 = findViewById(R.id.t53);
        t61 = findViewById(R.id.t61);
        t62 = findViewById(R.id.t62);
        t63 = findViewById(R.id.t63);
        t71 = findViewById(R.id.t71);
        t72 = findViewById(R.id.t72);
        t73 = findViewById(R.id.t73);
        t81 = findViewById(R.id.t81);
        t82 = findViewById(R.id.t82);
        t83 = findViewById(R.id.t83);

        t101 = findViewById(R.id.t101);
        t102 = findViewById(R.id.t102);
        t103 = findViewById(R.id.t103);
        t111 = findViewById(R.id.t111);
        t112 = findViewById(R.id.t112);
        t113 = findViewById(R.id.t113);
        t121 = findViewById(R.id.t121);
        t122 = findViewById(R.id.t122);
        t123 = findViewById(R.id.t123);

        t131 = findViewById(R.id.t131);
        t132 = findViewById(R.id.t132);
        t133 = findViewById(R.id.t133);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
               j= Integer.parseInt(documentSnapshot.getString("w"));

            }
        });

        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){

                    List<String> list = new ArrayList<>();
                    Map<String,Object> map = task.getResult().getData();

                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getKey());

                        Log.d("TAG", entry.getKey());
                    }



                        int size=list.size()-1;

                    if(j==0){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(0));

                    }
                    if(j==1){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(1));

                    }
                    if(j==2){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(1));
                    }
                    if(j==3){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(1));
                    }
                    if(j==4){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(1));
                    }
                    if(j==5){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(size-6));
                        t81.setText(list.get(1));

                    }else if(j==6){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(size-6));
                        t81.setText(list.get(size-7));
                        t101.setText(list.get(1));
                    }else if(j==7){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(size-6));
                        t81.setText(list.get(size-7));
                        t101.setText(list.get(size-8));
                        t111.setText(list.get(1));
                    }else if(j==8){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(size-6));
                        t81.setText(list.get(size-7));
                        t101.setText(list.get(size-8));
                        t111.setText(list.get(size-9));
                        t121.setText(list.get(1));
                    }
                    else if(j==9){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(size-6));
                        t81.setText(list.get(size-7));
                        t101.setText(list.get(size-8));
                        t111.setText(list.get(size-9));
                        t121.setText(list.get(size-10));
                        t121.setText(list.get(1));
                    } else if(j==10){
                        t11.setText(list.get(size));
                        t21.setText(list.get(size-1));
                        t31.setText(list.get(size-2));
                        t41.setText(list.get(size-3));
                        t51.setText(list.get(size-4));
                        t61.setText(list.get(size-5));
                        t71.setText(list.get(size-6));
                        t81.setText(list.get(size-7));
                        t101.setText(list.get(size-8));
                        t111.setText(list.get(size-9));
                        t121.setText(list.get(size-10));
                        t121.setText(list.get(1));
                    }




                }
            }
        });

     documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
         @Override
         public void onComplete(@NonNull Task<DocumentSnapshot> task) {
             if(task.isSuccessful()){
                 DocumentSnapshot document = task.getResult();
                 if(document.exists()){
                     Log.d("tag",document.getId() + " => " + document.getData());

                     String f = String.valueOf(document.getData());
                     f = f.replaceAll("[{=}]"," ");
                    f= f.replaceAll("[a-zA-Z]"," ");

                    List<String > list = new ArrayList<>(Arrays.asList(f.split(",")));
                    int size = list.size()-1;
                    list.add(f);
                    Log.d("tag",f);



                     if(j==0){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(1));

                     }
                     if(j==1){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(1));


                     }
                     if(j==2){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(1));
                     }
                     if(j==3){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(1));
                     }
                     if(j==4){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(1));
                     }
                     if(j==5){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(size-6));
                         t83.setText(list.get(1));
                     }else if(j==6){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(size-6));
                         t83.setText(list.get(size-7));
                         t103.setText(list.get(1));
                     }else if(j==7){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(size-6));
                         t83.setText(list.get(size-7));
                         t103.setText(list.get(size-8));
                         t113.setText(list.get(1));
                     }else if(j==8){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(size-6));
                         t83.setText(list.get(size-7));
                         t103.setText(list.get(size-8));
                         t113.setText(list.get(size-9));
                         t123.setText(list.get(1));
                     }
                     else if(j==9){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(size-6));
                         t83.setText(list.get(size-7));
                         t103.setText(list.get(size-8));
                         t113.setText(list.get(size-9));
                         t123.setText(list.get(size-10));
                         t133.setText(list.get(1));
                     } else if(j==10){
                         t13.setText(list.get(size));
                         t23.setText(list.get(size-1));
                         t33.setText(list.get(size-2));
                         t43.setText(list.get(size-3));
                         t53.setText(list.get(size-4));
                         t63.setText(list.get(size-5));
                         t73.setText(list.get(size-6));
                         t83.setText(list.get(size-7));
                         t103.setText(list.get(size-8));
                         t113.setText(list.get(size-9));
                         t123.setText(list.get(size-10));
                         t133.setText(list.get(1));
                     }



                 }else{
                     Log.d("tag","No doc");
                 }

             }
         }
     });

        documentReference1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        Log.d("tag",document.getId() + " => " + document.getData());

                        String f = String.valueOf(document.getData());
                        f = f.replaceAll("[{}]","");

                        Log.d("f",f);
                        String[] parts = f.split(",");

//                        Log.d("parts",parts[1]);
                        //char ch2 = parts[j-3].charAt(2);
                        //char ch3 = parts[j-4].charAt(2);

//                        Log.d("parts1",parts[1].substring(parts[1].lastIndexOf("=")+1));

                        if(j==0){

                            t12.setText("not out");
                            t22.setText("not out");


                        }
                        if(j==1){
                            String m = parts[j-1].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText("not out");
                            t32.setText("not out");


                        }
                        if(j==2){

                            String m = parts[j-1].substring(parts[1].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText("not out");
                            t42.setText("not out");
                        }
                        if(j==3){

                            String m = parts[j-1].substring(parts[2].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[1].lastIndexOf("=")+1);

                            String m2 = parts[j-3].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText("not out");
                            t52.setText("not out");
                        }
                        if(j==4){

                            String m = parts[j-1].substring(parts[3].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[2].lastIndexOf("=")+1);

                            String m2 = parts[j-3].substring(parts[1].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t62.setText("not out");
                            t52.setText("not out");
                        }
                        if(j==5){

                            String m = parts[j-1].substring(parts[4].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[3].lastIndexOf("=")+1);

                            String m2 = parts[j-3].substring(parts[2].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[1].lastIndexOf("=")+1);
                            String m4 = parts[j-5].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t52.setText(m4);
                            t62.setText("not out");
                            t72.setText("not out");

                        }else if(j==6){

                            String m = parts[j-1].substring(parts[5].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[4].lastIndexOf("=")+1);

                            String m2 =parts[j-3].substring(parts[3].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[2].lastIndexOf("=")+1);

                            String m4 = parts[j-5].substring(parts[1].lastIndexOf("=")+1);

                            String m5 = parts[j-6].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t52.setText(m4);
                            t62.setText(m5);
                            t82.setText("not out");
                            t72.setText("not out");
                        }else if(j==7){
                            String m = parts[j-1].substring(parts[6].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[5].lastIndexOf("=")+1);

                            String m2 =parts[j-3].substring(parts[4].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[3].lastIndexOf("=")+1);

                            String m4 = parts[j-5].substring(parts[2].lastIndexOf("=")+1);

                            String m5 = parts[j-6].substring(parts[1].lastIndexOf("=")+1);
                            String m6 = parts[j-7].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t52.setText(m4);
                            t62.setText(m5);
                            t72.setText(m6);
                            t82.setText("not out");
                            t102.setText("not out");
                        }else if(j==8){
                            String m = parts[j-1].substring(parts[7].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[6].lastIndexOf("=")+1);

                            String m2 =parts[j-3].substring(parts[5].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[4].lastIndexOf("=")+1);

                            String m4 = parts[j-5].substring(parts[3].lastIndexOf("=")+1);

                            String m5 = parts[j-6].substring(parts[2].lastIndexOf("=")+1);
                            String m6 = parts[j-7].substring(parts[1].lastIndexOf("=")+1);
                            String m7 = parts[j-8].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t52.setText(m4);
                            t62.setText(m5);
                            t72.setText(m6);
                            t82.setText(m7);
                            t112.setText("not out");
                            t102.setText("not out");
                        }
                        else if(j==9){
                            String m = parts[j-1].substring(parts[8].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[7].lastIndexOf("=")+1);

                            String m2 =parts[j-3].substring(parts[6].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[5].lastIndexOf("=")+1);

                            String m4 = parts[j-5].substring(parts[4].lastIndexOf("=")+1);

                            String m5 = parts[j-6].substring(parts[3].lastIndexOf("=")+1);
                            String m6 = parts[j-7].substring(parts[2].lastIndexOf("=")+1);
                            String m7 = parts[j-8].substring(parts[1].lastIndexOf("=")+1);
                            String m8 = parts[j-9].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t52.setText(m4);
                            t62.setText(m5);
                            t72.setText(m6);
                            t82.setText(m7);
                            t102.setText(m8);
                            t112.setText("not out");
                            t122.setText("not out");
                        } else if(j==10){
                            String m = parts[j-1].substring(parts[9].lastIndexOf("=")+1);

                            String m1 = parts[j-2].substring(parts[8].lastIndexOf("=")+1);

                            String m2 =parts[j-3].substring(parts[7].lastIndexOf("=")+1);

                            String m3 = parts[j-4].substring(parts[6].lastIndexOf("=")+1);

                            String m4 = parts[j-5].substring(parts[5].lastIndexOf("=")+1);

                            String m5 = parts[j-6].substring(parts[4].lastIndexOf("=")+1);
                            String m6 = parts[j-7].substring(parts[3].lastIndexOf("=")+1);
                            String m7 = parts[j-8].substring(parts[2].lastIndexOf("=")+1);
                            String m8 = parts[j-9].substring(parts[1].lastIndexOf("=")+1);
                            String m9 = parts[j-10].substring(parts[0].lastIndexOf("=")+1);
                            t12.setText(m);
                            t22.setText(m1);
                            t32.setText(m2);
                            t42.setText(m3);
                            t52.setText(m4);
                            t62.setText(m5);
                            t72.setText(m6);
                            t82.setText(m7);
                            t102.setText(m8);
                            t112.setText(m9);
                            t122.setText("not out");
                        }


                    }else{
                        Log.d("tag","No doc");
                    }

                }
            }
        });


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
                startActivity(new Intent(this,score2.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
