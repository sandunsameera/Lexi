package com.lolin.deemon_face.lexi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddDecorator extends AppCompatActivity {

    public Button AddPhotographyer_btn_add;
    private Firebase mref;
    public EditText AddPhotographer_ET_name;
    public EditText AddPhotographer_ET_Age;
    public EditText AddPhotographer_ET_Expe;
    public EditText AddPhotographer_ET_Email;
    public EditText AddPhotographer_ET_phone;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_photographer);
        Firebase.setAndroidContext(this);

        AddPhotographyer_btn_add = findViewById (R.id.AddPhotography_btn_add);
        AddPhotographer_ET_name = findViewById (R.id.AddPhotographer_ET_Nmae);
        AddPhotographer_ET_Age = findViewById (R.id.AddPhotographer_ET_Age);
        AddPhotographer_ET_Expe= findViewById (R.id.AddPhotographer_ET_Experience);
        AddPhotographer_ET_Email= findViewById (R.id.AddPhotographer_ET_Email);
        AddPhotographer_ET_phone= findViewById (R.id.AddPhotographer_ET_Phone);

        /*DatabaseReference databaseReference = FirebaseDatabase.getInstance ().setReferenceFromUrl();*/

        //Creating connection to database
        mref = new Firebase ("https://lexi-750af.firebaseio.com/Decorators");
//
        final String name = AddPhotographer_ET_name.getText ().toString ();
        final String age = AddPhotographer_ET_Age.getText ().toString ();
        final String exp = AddPhotographer_ET_Expe.getText ().toString ();
        final String email = AddPhotographer_ET_Email.getText ().toString ();
        final String phone= AddPhotographer_ET_phone.getText ().toString ();

        if(TextUtils.isEmpty (name) || TextUtils.isEmpty (age) || TextUtils.isEmpty (exp) || TextUtils.isEmpty (email) || TextUtils.isEmpty (phone)){


            Toast.makeText (AddDecorator.this, "Please fill the fields", Toast.LENGTH_SHORT).show ();
        }

        else{
            mDatabase = FirebaseDatabase.getInstance ().getReference ().child ("Decorators").push ();

            HashMap<String, String> photographerMap = new HashMap<> ();
            photographerMap.put ("Name",name);
            photographerMap.put ("Age",age);
            photographerMap.put ("Experience",exp);
            photographerMap.put ("Phone",phone);
            photographerMap.put ("Email",email);

            mDatabase.setValue (photographerMap);
            Toast.makeText (AddDecorator.this,"Successfully added",Toast.LENGTH_SHORT).show ();

//                Toast.makeText (AddDecorator.this,"Successfully added",Toast.LENGTH_SHORT).show ();

            }
        }

}
