package com.lolin.deemon_face.lexi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddPhotographer extends AppCompatActivity {

    public Button AddPhotographyer_btn_add;
    private Firebase mRootRef;
    public EditText AddPhotographer_ET_name;
    public EditText AddPhotographer_ET_Age;
    public EditText AddPhotographer_ET_Expe;
    public EditText AddPhotographer_ET_Email;
    public EditText AddPhotographer_ET_phone;
    private ProgressDialog mProgressDialog;
    private DatabaseReference mDatabase;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_photographer);
        Firebase.setAndroidContext(this);

        //Toolbar set
        mToolbar = findViewById (R.id.toolbar);
//        setSupportActionBar (mToolbar);
        getSupportActionBar ().setTitle ("Create Account ");
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        mProgressDialog = new ProgressDialog (this);

        AddPhotographyer_btn_add = findViewById (R.id.AddPhotography_btn_add);
        AddPhotographer_ET_name = findViewById (R.id.AddPhotographer_ET_Nmae);
        AddPhotographer_ET_Age = findViewById (R.id.AddPhotographer_ET_Age);
        AddPhotographer_ET_Expe= findViewById (R.id.AddPhotographer_ET_Experience);
        AddPhotographer_ET_Email= findViewById (R.id.AddPhotographer_ET_Email);
        AddPhotographer_ET_phone= findViewById (R.id.AddPhotographer_ET_Phone);


        final String Name = AddPhotographer_ET_name.getText ().toString ();
        final String Age = AddPhotographer_ET_Age.getText ().toString ();
        final String Exp = AddPhotographer_ET_Expe.getText ().toString ();
        final String Email = AddPhotographer_ET_Email.getText ().toString ();
        final String Phone = AddPhotographer_ET_phone.getText ().toString ();

        String url = ("https://lexi-750af.firebaseio.com/Photographers ");

        //Creating connection to database
        mRootRef= new Firebase (url);
//
        AddPhotographyer_btn_add.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {



                mDatabase = FirebaseDatabase.getInstance ().getReference ().child ("Photographers").push ();

                HashMap<String, String> photographerMap = new HashMap<> ();
                photographerMap.put ("Name",Name);
                photographerMap.put ("Age",Age);
                photographerMap.put ("Experience",Exp);
                photographerMap.put ("Phone",Phone);
                photographerMap.put ("Email",Email);

                mDatabase.setValue (photographerMap);
                Toast.makeText (AddPhotographer.this,"Successfully added",Toast.LENGTH_SHORT).show ();

            }
        });

    }
}
