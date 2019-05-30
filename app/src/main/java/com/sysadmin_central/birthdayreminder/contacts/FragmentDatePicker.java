package com.sysadmin_central.birthdayreminder.contacts;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class FragmentDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private OnDateSetListener callbackListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar calendar = Calendar.getInstance(getResources().getConfiguration().locale);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    // Ensures that the OnDateSetListener is implemented in calling class
    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        try {
            callbackListener = (OnDateSetListener) getTargetFragment();

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnDateSetListener.");
        }
    }

    // Overriden by calling function
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        if(callbackListener != null) {
            callbackListener.onDateSet(view, year, month, dayOfMonth);
        }
    }

    public interface OnDateSetListener {
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
    }
}
