package com.lolin.deemon_face.lexi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class AddPhotographer extends AppCompatActivity {

    public Button AddPhotographyer_btn_add;
    private Firebase mRootRef;
    public EditText AddPhotographer_ET_name;
    public EditText AddPhotographer_ET_Age;
    public EditText AddPhotographer_ET_Expe;
    public EditText AddPhotographer_ET_Email;
    public EditText AddPhotographer_ET_phone;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_photographer);
        Firebase.setAndroidContext(this);

        mProgressDialog = new ProgressDialog (this);

        AddPhotographyer_btn_add = findViewById (R.id.AddPhotography_btn_add);
        AddPhotographer_ET_name = findViewById (R.id.AddPhotographer_ET_Nmae);
        AddPhotographer_ET_Age = findViewById (R.id.AddPhotographer_ET_Age);
        AddPhotographer_ET_Expe= findViewById (R.id.AddPhotographer_ET_Experience);
        AddPhotographer_ET_Email= findViewById (R.id.AddPhotographer_ET_Email);
        AddPhotographer_ET_phone= findViewById (R.id.AddPhotographer_ET_Phone);
        String urlName = AddPhotographer_ET_name.getText ().toString ();

        String url = ("https://lexi-750af.firebaseio.com/Photographers " + urlName);

        //Creating connection to database
        mRootRef= new Firebase (url);
//
        AddPhotographyer_btn_add.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {



//                //name
//                String name = AddPhotographer_ET_name.getText ().toString ();
//                Firebase childref = mRootRef.child ("Name");
//                childref.setValue (name);

                //Age
                String age = AddPhotographer_ET_Age.getText ().toString ();
                Firebase childref1 = mRootRef.child ("Age");
                childref1.setValue (age);

                //Exp
                String exp = AddPhotographer_ET_Expe.getText ().toString ();
                Firebase childref2 = mRootRef.child ("Experience");
                childref2.setValue (exp);

                //Tp
                String tp = AddPhotographer_ET_phone.getText ().toString ();
                Firebase childref3 = mRootRef.child ("Telephone");
                childref3.setValue (tp);

                //Email
                String email = AddPhotographer_ET_Email.getText ().toString ();
                Firebase childref4 = mRootRef.child ("Email");
                childref4.setValue (email);
            }
        });

    }
}
