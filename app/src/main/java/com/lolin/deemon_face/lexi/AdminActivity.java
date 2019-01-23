package com.lolin.deemon_face.lexi;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        registerForContextMenu (admin_btn_caterning);
        registerForContextMenu (admin_btn_decorating);
        registerForContextMenu (admin_btn_photography);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu (menu, v, menuInfo);
        menu.setHeaderTitle ("Context Menu");
        menu.add (0,v.getId (),0,"add");
        menu.add (0,v.getId (),0,"delete");
        menu.add (0,v.getId (),0,"update");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle () == "add"){
            Intent intent1 = new Intent (AdminActivity.this,AddActivity.class);
            startActivity (intent1);
        }

        else if (item.getTitle () == "delete"){

            Intent intent2 = new Intent (AdminActivity.this,DeleteActivity.class);
            startActivity (intent2);

        }
        else {
            Intent intent3 = new Intent (AdminActivity.this,UpdateActivity.class);
            startActivity (intent3);
        }

        return super.onContextItemSelected (item);
    }
}
