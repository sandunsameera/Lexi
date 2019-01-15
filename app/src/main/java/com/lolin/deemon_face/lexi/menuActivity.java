package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    public Button menuBtnWedding;
    public Button menuBtnBirthday;
    public Button menuBtnBeachParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu);

        menuBtnWedding = findViewById (R.id.menu_btn_Wedding);
        menuBtnBirthday = findViewById (R.id.menu_btn_Birthday);
        menuBtnBeachParty = findViewById (R.id.menu_btn_beachParty);

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

                Intent intent2 = new Intent (menuActivity.this,Birthday.class);
                startActivity (intent2);
            }
        });

//
        menuBtnBeachParty.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

//                Intent intent3 = new Intent (menuActivity.this,beachParty.class);
//                startActivity (intent3);
            }
        });

    }
}
