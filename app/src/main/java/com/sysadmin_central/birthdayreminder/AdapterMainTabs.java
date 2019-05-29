/**
 * Controls order of the tables, titles and their associated contents
 */

package com.sysadmin_central.birthdayreminder;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdapterMainTabs extends FragmentPagerAdapter {
    private String tabTitles[];
    int pageCount;

    public AdapterMainTabs(FragmentManager fm, Context context) {
        super(fm);

        tabTitles = new String[] {context.getResources().getString(R.string.home), context.getResources().getString(R.string.list), context.getResources().getString(R.string.calendar)}; //TODO load names
        pageCount = tabTitles.length;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentInitiatorMain.newInstance(position);
    }

    // Generate the title based on tabTitles
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
