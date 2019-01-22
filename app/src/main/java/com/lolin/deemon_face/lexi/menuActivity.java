package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class menuActivity extends AppCompatActivity {

    public Button menuBtnWedding;
    public Button menuBtnBirthday;
    public Button menuBtnBeachParty;
    public Button logOutBtn;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onStart() {
        super.onStart ();
        mAuth.addAuthStateListener (mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu);

        logOutBtn = findViewById (R.id.menu_btn_logout);
        menuBtnWedding = findViewById (R.id.menu_btn_Wedding);
        menuBtnBirthday = findViewById (R.id.menu_btn_Birthday);
        menuBtnBeachParty = findViewById (R.id.menu_btn_beachParty);

        mAuth = FirebaseAuth.getInstance ();

        mAuthListner = new FirebaseAuth.AuthStateListener () {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser () == null){
                    startActivity (new Intent (menuActivity.this,MainActivity.class));
                }
            }
        }

        logOutBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                mAuth.signOut ();

            }
        });

        menuBtnWedding.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent (menuActivity.this,wedding.class);
                startActivity (intent1);

            }
        });
//
        menuBtnBirthday.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent (menuActivity.this,birthday.class);
                startActivity (intent2);
            }
        });

//
        menuBtnBeachParty.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent (menuActivity.this,beachParty.class);
                startActivity (intent3);
            }
        });

    }
}
