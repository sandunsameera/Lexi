package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class birthday extends AppCompatActivity {

    private static final String TAG = "birthday";
    private SectionPageAdapter mSectionageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_birthday);

        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        Log.d (TAG,"onCreate:starting.");
        mSectionageAdapter = new SectionPageAdapter (getSupportFragmentManager ());

        mViewPager = findViewById (R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById (R.id.tabs);
        tabLayout.setupWithViewPager (mViewPager);

//        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
//        fab.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction ("Action", null).show ();
//            }
//        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater ().inflate (R.menu.menu_birthday,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId ()){
            case (R.id.SeeAsUser):
                Intent intent1 = new Intent (birthday.this,MainActivity.class);
                startActivity (intent1);

            case (R.id.SeeAsAdmin):
                Intent intent2 = new Intent (birthday.this,MainActivity.class);
                startActivity (intent2);
        }
        return super.onOptionsItemSelected (item);
    }

    private void setupViewPager(ViewPager mViewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter (getSupportFragmentManager ());
        /*adapter.addFragment (new photographyFragment (), "Photography");*/
        adapter.addFragment (new decorationFragment (), "Decorations");
        adapter.addFragment (new cateringFragment (), "Catering");
        mViewPager.setAdapter (adapter);
    }
}