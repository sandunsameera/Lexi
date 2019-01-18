package com.lolin.deemon_face.lexi;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.zip.Inflater;

public class wedding extends AppCompatActivity {

    private static final String TAG = "wedding";
    private SectionPageAdapter mSectionageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_wedding);
        Log.d (TAG,"onCreate:starting.");

        mSectionageAdapter = new SectionPageAdapter (getSupportFragmentManager ());

        mViewPager = findViewById (R.id.view);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager (mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu_wedding,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId ()){
            case (R.id.SeeAsUser):
                Intent intent1 = new Intent (wedding.this,MainActivity.class);
                startActivity (intent1);

            case (R.id.SeeAsAdmin):
                Intent intent2 = new Intent (wedding.this,MainActivity.class);
                startActivity (intent2);
        }
        return super.onOptionsItemSelected (item);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter = new SectionPageAdapter (getSupportFragmentManager ());
        adapter.addFragment (new photographyFragment (),"photography");
        adapter.addFragment (new decorationFragment (),"decoration");
        adapter.addFragment (new cateringFragment (),"catering");
        viewPager.setAdapter (adapter);
    }
}
