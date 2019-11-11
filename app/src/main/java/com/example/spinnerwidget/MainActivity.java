package com.example.spinnerwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import Adapter.ViewPageAdapter;
import Details.PersonalDetails;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);





       tabLayout =findViewById (R.id.tabId);
       viewPager = findViewById (R.id.ViewPager);

      ViewPageAdapter adapter = new ViewPageAdapter (getSupportFragmentManager ());


        adapter.addFragment (new PersonalDetails (),"Personal Details");
//        adapter.addFragment (new HouseDetails (),"House Details");
//        adapter.addFragment (new FamilyMember (),"Family Member");

        viewPager.setAdapter (adapter);
        tabLayout.setupWithViewPager (viewPager);



    }
}
