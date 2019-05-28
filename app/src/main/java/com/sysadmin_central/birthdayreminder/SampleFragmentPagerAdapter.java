/**
 * Controls order of the tables, titles and their associated contents
 */


package com.sysadmin_central.birthdayreminder;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[];
    int PAGE_COUNT; //TODO get dynamic count?
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

        tabTitles = new String[] {context.getResources().getString(R.string.home), context.getResources().getString(R.string.list), context.getResources().getString(R.string.calendar)}; //TODO load names
        PAGE_COUNT = tabTitles.length;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentHome.newInstance(position + 1);
    }

    // Generate the title based on tabTitles
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
