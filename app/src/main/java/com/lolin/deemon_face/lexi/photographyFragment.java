package com.lolin.deemon_face.lexi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class photographyFragment extends ListFragment{
    private static final String TAG = "photographyFragment";
    private ListView mListView;
    private Firebase mref;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance ().getReferenceFromUrl ("https://lexi-750af.firebaseio.com/Photographer");


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mref = new Firebase ("https://lexi-750af.firebaseio.com/Photographers");
        View view = inflater.inflate (R.layout.photographyfragment,container,false);
        return view;

    }

}
