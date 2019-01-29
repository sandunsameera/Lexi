package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.firebase.client.Firebase;

public class beachParty extends AppCompatActivity{

    private SectionPageAdapter mSectionPageAdapter;
    private static final String TAG = "beachParty";
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_beach_party);

        Toolbar toolbar =findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        Log.d (TAG,"onCreate:Starting");

        mSectionPageAdapter = new SectionPageAdapter (getSupportFragmentManager ());

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu_beach_party,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId ()){
            case(R.id.SeeAsUser):
                Intent intent1 = new Intent (beachParty.this ,MainActivity.class );
                startActivity (intent1);

            case(R.id.SeeAsAdmin):
                Intent intent2 = new Intent (beachParty.this,MainActivity.class);
                startActivity (intent2);
        }

        return super.onOptionsItemSelected (item);
    }

    private void setupViewPager(ViewPager mViewPager) {

        SectionPageAdapter adapter = new SectionPageAdapter (getSupportFragmentManager ());
//        adapter.addFragment (new photographyFragment (),"photography");
        adapter.addFragment (new decorationFragment (),"decorating");
        adapter.addFragment (new cateringFragment (),"catering");

    }
}
