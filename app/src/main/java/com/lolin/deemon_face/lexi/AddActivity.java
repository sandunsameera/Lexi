package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {
    public Button Add_btn_photo;
    public Button Add_btn_Deco;
    public Button Add_btn_cate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add);

        Add_btn_photo = findViewById (R.id.Add_btn_photography);
        Add_btn_Deco = findViewById (R.id.Add_btn_Decorator);
        Add_btn_cate = findViewById (R.id.Add_btn_Catering);

        Add_btn_photo.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent (AddActivity.this,AddPhotographer.class);
                startActivity (intent1);
            }
        });

        Add_btn_Deco.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (AddActivity.this,AddDecorator.class);
                startActivity (intent2);
            }
        });

        Add_btn_cate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent (AddActivity.this,AddCater.class);
                startActivity (intent3);
            }
        });
    }

}
