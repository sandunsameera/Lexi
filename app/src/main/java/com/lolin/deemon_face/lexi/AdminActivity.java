package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    public Button admin_btn_photography;
    public Button admin_btn_caterning;
    public Button admin_btn_decorating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin);

        admin_btn_caterning = findViewById (R.id.admin_btn_addCater);
        admin_btn_decorating = findViewById (R.id.admin_btn_addDecorator);
        admin_btn_photography = findViewById (R.id.admin_btn_addPhotographer);

        admin_btn_photography.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent (AdminActivity.this,AddActivity.class);
                startActivity (intent1);
            }
        });

        admin_btn_caterning.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (AdminActivity.this,AddActivity.class);
                startActivity(intent2);
            }
        });

       admin_btn_decorating.setOnClickListener (new View.OnClickListener () {
           @Override
           public void onClick(View v) {
               Intent intent3 = new Intent (AdminActivity.this,AddActivity.class);
               startActivity (intent3);
           }
       });

    }


}
