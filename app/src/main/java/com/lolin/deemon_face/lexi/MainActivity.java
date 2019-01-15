package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button MainBtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        MainBtnSignIn = findViewById (R.id.main_btn_signIn);
        MainBtnSignIn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,menuActivity.class);
                startActivity (intent);
            }
        });
    }
}
