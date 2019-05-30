package com.sysadmin_central.birthdayreminder.contacts;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sysadmin_central.birthdayreminder.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ActivityContactCreateFragment extends Fragment {

    public ActivityContactCreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_activity_contact_create, container, false);
    }
}
