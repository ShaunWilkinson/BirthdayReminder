package com.sysadmin_central.birthdayreminder.contacts;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.sysadmin_central.birthdayreminder.R;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Called by ActivityContactCreate, manages the fragment
 */
public class FragmentContactCreate extends Fragment implements FragmentDatePicker.OnDateSetListener {
    EditText inputName;
    EditText inputBirthday;
    EditText inputPhone;
    EditText inputEmail;

    Date dateBirthday;

    public FragmentContactCreate() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
                    Log.d("SHaun", "test");
                    DialogFragment fragmentDatePicker = new FragmentDatePicker();
                    fragmentDatePicker.show(getFragmentManager(), "datePicker");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Log.d("SHauN", "onDateSEt - " + year + ", " + month + ", " + day);
        dateBirthday = new GregorianCalendar(year, month, day).getTime();

        inputBirthday.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(dateBirthday));
    }
}
