package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    private Button menuBtnWedding;
    private Button menuBtnBirthday;
    private Button menuBtnBeachParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu);

        menuBtnWedding = findViewById (R.id.menu_btn_Wedding);
        menuBtnBirthday = findViewById (R.id.menu_btn_Birthday);
        menuBtnBeachParty = findViewById (R.id.menu_btn_beachParty);

        Intent intent1 = new Intent (menuActivity.this,weddingActivity.class);
        startActivity (intent1);

        Intent intent2 = new Intent (menuActivity.this,bithdayActivity.class);
        startActivity (intent2);

        Intent intent3 = new Intent (menuActivity.this,beachParty.class);
        startActivity (intent3);
    }
}
