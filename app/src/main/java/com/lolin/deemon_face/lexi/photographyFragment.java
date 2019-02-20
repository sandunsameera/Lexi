//package com.lolin.deemon_face.lexi;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class photographyFragment extends Fragment {
//    private static final String TAG = "cateringFragment";
//    private View photographerView;
//    private RecyclerView caters,usersref;
//    private DatabaseReference catersref;
//
//
//    public photographyFragment(){
//        //empty
//    }
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        photographerView = inflater.inflate (R.layout.photographyfragment,container,false);
//
//        caters = photographerView.findViewById (R.id.photography_recyclerView);
//        caters.setLayoutManager (new LinearLayoutManager(getContext ()));
//
//        catersref = FirebaseDatabase.getInstance ().getReference ().child ("Photographers");
//        return photographerView;
//
//    }

    @Override
//    public void onStart() {
//        super.onStart ();
//        FirebaseRecyclerOptions options
//                =new FirebaseRecyclerOptions.Builder<caters> ()
//                .setQuery (catersref,caters.class)
//                .build ();
//
//        final FirebaseRecyclerAdapter<Photographers , photographersViewHolder> adapter = new FirebaseRecyclerAdapter<Photographers, photographersViewHolder> () {
//            @Override
//            protected void onBindViewHolder(@NonNull photographersViewHolder holder, int position, @NonNull Photographers model) {
//                String photographerId = getRef (position).getKey ();
//                catersref.child (photographerId).addValueEventListener (new ValueEventListener () {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String caterName = dataSnapshot.child ("Name").getValue ().toString ();
//                        String caterAge = dataSnapshot.child ("Age").getValue ().toString ();
//                        String caterExp = dataSnapshot.child ("Experience").getValue ().toString ();
//                        String caterEmail = dataSnapshot.child ("Email").getValue ().toString ();
//
////                        holder.Name.setText (caterName);
////                        holder.Age.setText (caterAge);
////                        holder.Experience.setText (caterExp);
////                        holder.Email.setText (caterEmail);
//                    }
//
//                });
//
//            }
//
//            @NonNull
//            @Override
//            public photographersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//                return null;
//            }
//        };
//
//        caters.setAdapter (adapter);
//        adapter.startListening ();
//
//
//    }
//
//    public static class photographersViewHolder extends RecyclerView.ViewHolder{
//
//        TextView Name;
//        TextView Experience;
//        TextView Age;
//        TextView Email;
//
//        public photographersViewHolder(@NonNull View itemView) {
//            super (itemView);
//
//            Name = itemView.findViewById (R.id.display_name);
//            Age = itemView.findViewById (R.id.display_age);
//            Experience = itemView.findViewById (R.id.display_exp);
//            Email = itemView.findViewById (R.id.display_email);
//        }
//    }
//}
