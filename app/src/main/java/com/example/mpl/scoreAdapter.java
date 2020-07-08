package com.example.mpl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class scoreAdapter extends FirestoreRecyclerAdapter<card,scoreAdapter.scoreHolder> {
    private OnScoreListener listener;

    public scoreAdapter(@NonNull FirestoreRecyclerOptions<card> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull scoreHolder holder, int position, @NonNull card model) {
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        holder.date.setText(String.valueOf(model.getN()));

    }

    @NonNull
    @Override
    public scoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_item,parent,false);
        return new scoreHolder(v);
    }

    class scoreHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView desc;
        TextView date;
        Button button;

        public scoreHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc= itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            button = itemView.findViewById(R.id.bt);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && listener != null){
                        listener.onScoreClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });


        }
    }
    public interface OnScoreListener{
        void onScoreClick(DocumentSnapshot documentSnapshot,int position);
    }

    public void setOnScoreListener(OnScoreListener listener){
        this.listener = listener;
    }
}
