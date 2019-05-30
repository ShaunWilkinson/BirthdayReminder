package com.sysadmin_central.birthdayreminder;

import androidx.room.Room;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sysadmin_central.birthdayreminder.contacts.DatabaseContacts;

public class ActivityMain extends AppCompatActivity {

    private static final String TAG = "ActivityMain";
    private static final String DATABASE_NAME = "contacts_db";
    private DatabaseContacts databaseContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateTabbedView();
        initiateDatabase();
    }


    // Inflate the menu at top right
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    /**
     * Runs when a menu item is selected
     * @param item The menu item
     * @return True if action handled, false otherwise
     */
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

    /**
     * Initiates the tab views, ensuring all the individual tabs are loaded
     */
    private void initiateTabbedView() {
        // Get the viewPager and set it's PagerAdapter so it displays items
        ViewPager viewPager = findViewById(R.id.viewPager);
        AdapterMainTabs pagerAdapter = new AdapterMainTabs(getSupportFragmentManager(), ActivityMain.this);
        viewPager.setAdapter(pagerAdapter);

        // Link with the viewPager
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Initiates a room SQLlite database for storing contacts
     */
    private void initiateDatabase() {
        databaseContacts = Room.databaseBuilder(this, DatabaseContacts.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }
}
