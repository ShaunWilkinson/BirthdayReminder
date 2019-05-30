package com.sysadmin_central.birthdayreminder.contacts;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.sysadmin_central.birthdayreminder.R;

import java.io.Console;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Called by ActivityContactCreate, manages the fragment
 */
public class FragmentContactCreate extends Fragment implements FragmentDatePicker.OnDateSetListener {
    // Used to pass as the target fragment to the date picker
    private FragmentContactCreate thisFragment;

    private EditText inputName;
    private EditText inputBirthday;
    private EditText inputPhone;
    private EditText inputEmail;

    private Date dateBirthday;

    public FragmentContactCreate() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        thisFragment = this;

        // Inflate the contact_create view
        View v = inflater.inflate(R.layout.fragment_activity_contact_create, container, false);

        // Initiate the form items
        inputName = v.findViewById(R.id.inputName);
        inputBirthday = v.findViewById(R.id.inputBirthday);
        inputPhone = v.findViewById(R.id.inputPhone);
        inputEmail = v.findViewById(R.id.inputEmail);

        // Set an on-click listener
        inputBirthday.setOnClickListener(buttonClicked);

        return v;
    }

    // Handle onCLick events
    private View.OnClickListener buttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Swith as I'm likely to do more in here
            switch(v.getId()) {
                case R.id.inputBirthday:
                    DialogFragment fragmentDatePicker = new FragmentDatePicker();
                    fragmentDatePicker.setTargetFragment(thisFragment, 0);
                    fragmentDatePicker.show(getFragmentManager(), "datePicker");
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * Called when the DatePicker returns a value, populates the local field and populates edittext
     * @param view The datepicker
     * @param year The year
     * @param month The month
     * @param dayOfMonth The day
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateBirthday = new GregorianCalendar(year, month, dayOfMonth).getTime();

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        inputBirthday.setText(dateFormat.format(dateBirthday));
    }
}
