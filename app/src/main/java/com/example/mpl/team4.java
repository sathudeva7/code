package com.example.mpl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class team4 extends AppCompatActivity {
   TextView t1,t2;
    static String idx;
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private scoreAdapter adapter;

    private CollectionReference collectionReference= fStore.collection("tournament");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team4);

        setUpRecyclerView();


            }
        private void setUpRecyclerView(){
            Query query =collectionReference.orderBy("month", Query.Direction.DESCENDING);

            FirestoreRecyclerOptions<card> options = new FirestoreRecyclerOptions.Builder<card>().setQuery(query,card.class)
                    .build();

            adapter = new scoreAdapter(options);
            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(adapter);

            adapter.setOnScoreListener(new scoreAdapter.OnScoreListener() {
                @Override
                public void onScoreClick(DocumentSnapshot documentSnapshot, int position) {
                    idx = documentSnapshot.getId();
                    Intent intent = new Intent(team4.this,score.class);
                    startActivity(intent);
                    Log.d("TAG","on touch");

                }
            });
        }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(team4.this, Home.class);
        startActivity(intent);
        finish();
    }
}
