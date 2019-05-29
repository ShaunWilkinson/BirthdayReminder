package com.sysadmin_central.birthdayreminder;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityMain extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the viewPager and set it's PagerAdapter so it displays items
        viewPager = findViewById(R.id.viewPager);
        AdapterMainTabs pagerAdapter = new AdapterMainTabs(getSupportFragmentManager(), ActivityMain.this);
        viewPager.setAdapter(pagerAdapter);

        // Link with the viewPager
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
}


    // Inflate the menu at top right
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    // Handle option menu clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_contact:
                //TODO implement create contact form
                return true;
            case R.id.action_import_contact:
                //TODO implement import contacts form
                return true;
            case R.id.action_goto_settings:
                //TODO implement settings menu
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
