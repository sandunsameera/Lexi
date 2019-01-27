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

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.common.base.Strings;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class photographyFragment extends ListFragment{
    private static final String TAG = "photographyFragment";
    private ListView mListView;
    private Firebase mref;
    private ArrayList<String> mUsernames = new ArrayList<> ();

    DatabaseReference databaseReference = FirebaseDatabase.getInstance ().getReferenceFromUrl ("https://lexi-750af.firebaseio.com/Photographer");

    public photographyFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mref = Firebase.setAndroidContext (this);
        mref = new Firebase ("https://lexi-750af.firebaseio.com/Photographers");
        View view =  inflater.inflate (R.layout.photographyfragment,container,false);
        ListView mListView = view.findViewById (R.id.photography_LV_listView);

        final ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String> (getActivity (), android.R.layout.simple_list_item_1,mUsernames);
        mListView.setAdapter (arrayAdapter);
        mref.addChildEventListener (new ChildEventListener () {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue (String.class);
                mUsernames.add (value);
                arrayAdapter.notifyDataSetInvalidated ();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return view;

    }

}
