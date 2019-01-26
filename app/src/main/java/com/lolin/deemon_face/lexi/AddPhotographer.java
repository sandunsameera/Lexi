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
    private Firebase mref;
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

        //Creating connection to database
        mref = new Firebase ("https://lexi-750af.firebaseio.com/Photographers");
//
        AddPhotographyer_btn_add.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                mProgressDialog.setMessage ("uploading the details..");
                mProgressDialog.show ();

                Firebase ChildRef = mref.child (AddPhotographer_ET_name.getText ().toString ());
                ChildRef.push ().setValue (AddPhotographer_ET_Age.getText ().toString ());
                ChildRef.push ().setValue (AddPhotographer_ET_Expe.getText ().toString ());
                ChildRef.push ().setValue (AddPhotographer_ET_Email.getText ().toString ());
                ChildRef.push ().setValue (AddPhotographer_ET_phone.getText ().toString ());
                mProgressDialog.dismiss ();


                Toast.makeText (AddPhotographer.this,"Successfully added",Toast.LENGTH_SHORT).show ();

            }
        });

    }
}
