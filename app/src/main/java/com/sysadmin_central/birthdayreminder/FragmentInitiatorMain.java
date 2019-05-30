package com.sysadmin_central.birthdayreminder;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sysadmin_central.birthdayreminder.contacts.ActivityContactCreate;

public class FragmentInitiatorMain extends Fragment {
    private static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    // Singleton pattern to create a new instance of the fragment
    public static FragmentInitiatorMain newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        FragmentInitiatorMain fragment = new FragmentInitiatorMain();
        fragment.setArguments(args);

        return fragment;
    }

    // Calls super and gets the current page number
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    //Implement different pages on each tab
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;

        switch(mPage) {
            // Home page
            case 0:
                v = inflater.inflate(R.layout.fragment_home, container, false);

                // Initiate the 'Add contact' button then start a new activity
                Button addContact = v.findViewById(R.id.btnCreateContact);
                addContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), ActivityContactCreate.class);
                        startActivity(intent);
                    }
                });

                return v;
                // List page
            case 1:
                v = inflater.inflate(R.layout.fragment_list, container, false);
                return v;
                // Calendar view
            case 2:
                v = inflater.inflate(R.layout.fragment_calendar, container, false);
                return v;
            default:
                return null;
        }
    }
}
