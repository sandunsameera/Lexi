package com.lolin.deemon_face.lexi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cateringFragment extends Fragment {
    private static final String TAG = "cateringFragment";
    private View catersView;
    private RecyclerView caters,usersref;
    private DatabaseReference catersref;


    public cateringFragment(){
        //empty
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catersView = inflater.inflate (R.layout.cateringfragment,container,false);

        caters = catersView.findViewById (R.id.catering_recyclerView);
        caters.setLayoutManager (new LinearLayoutManager(getContext ()));

        catersref = FirebaseDatabase.getInstance ().getReference ().child ("Caters");
        return catersView;

    }

    @Override
    public void onStart() {
        super.onStart ();
        FirebaseRecyclerOptions options
                =new FirebaseRecyclerOptions.Builder<caters> ()
                .setQuery (catersref,caters.class)
                .build ();

        final FirebaseRecyclerAdapter<caters , catersViewHolder> adapter = new FirebaseRecyclerAdapter<com.lolin.deemon_face.lexi.caters, catersViewHolder> (options) {
            @Override
            protected void onBindViewHolder(@NonNull final catersViewHolder holder, int position, @NonNull com.lolin.deemon_face.lexi.caters model) {

                String caterId = getRef (position).getKey ();
                catersref.child (caterId).addValueEventListener (new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String caterName = dataSnapshot.child ("Name").getValue ().toString ();
                        String caterAge = dataSnapshot.child ("Age").getValue ().toString ();
                        String caterExp = dataSnapshot.child ("Experience").getValue ().toString ();
                        String caterEmail = dataSnapshot.child ("Email").getValue ().toString ();

                        holder.Name.setText (caterName);
                        holder.Age.setText (caterAge);
                        holder.Experience.setText (caterExp);
                        holder.Email.setText (caterEmail);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

            @NonNull
            @Override
            public catersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view = LayoutInflater.from (getContext ()).inflate (R.layout.display_layout,viewGroup,false);
                catersViewHolder viewHolder = new catersViewHolder (view);
                return viewHolder;
            }
        };

        caters.setAdapter (adapter);
        adapter.startListening ();


    }

    public static class catersViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        TextView Experience;
        TextView Age;
        TextView Email;

        public catersViewHolder(@NonNull View itemView) {
            super (itemView);

            Name = itemView.findViewById (R.id.display_name);
            Age = itemView.findViewById (R.id.display_age);
            Experience = itemView.findViewById (R.id.display_exp);
            Email = itemView.findViewById (R.id.display_email);
        }
    }
}
