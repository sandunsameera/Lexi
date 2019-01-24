package com.lolin.deemon_face.lexi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class AddPhotographer extends AppCompatActivity {

    public Button AddPhotographyer_btn_add;
    private Firebase mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_photographer);
        Firebase.setAndroidContext(this);

        AddPhotographyer_btn_add = findViewById (R.id.AddPhotography_btn_add);

        mref = new Firebase ("https://lexi-750af.firebaseio.com/");

        AddPhotographyer_btn_add.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Firebase mRefChild = mref.child ("Name");

                mRefChild.setValue ("Sandun");

            }
        });

    }
}
