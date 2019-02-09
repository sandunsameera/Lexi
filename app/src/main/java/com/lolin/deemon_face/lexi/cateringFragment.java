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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cateringFragment extends Fragment {
    private static final String TAG = "cateringFragment";
    private View catersView;
    private RecyclerView caters;
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

        FirebaseRecyclerAdapter<caters , catersViewHolder> adapter = new FirebaseRecyclerAdapter<com.lolin.deemon_face.lexi.caters, catersViewHolder> () {
            @Override
            protected void onBindViewHolder(@NonNull catersViewHolder holder, int position, @NonNull com.lolin.deemon_face.lexi.caters model) {

            }

            @NonNull
            @Override
            public catersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view = LayoutInflater.from (getContext ()).inflate (R.layout.display_layout,viewGroup,false);
                catersViewHolder viewHolder = new catersViewHolder (view);
                return viewHolder;
            }
        };


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
