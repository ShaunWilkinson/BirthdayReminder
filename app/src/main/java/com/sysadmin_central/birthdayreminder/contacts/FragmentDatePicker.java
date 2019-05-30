package com.sysadmin_central.birthdayreminder.contacts;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class FragmentDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    DatePickerDialog.OnDateSetListener mCallback;

    /**
     * An interface containing onDateSet
     * Container must implement this interface
     */
    public interface OnDateSetListener {
        public void onDateSet(DatePicker view, int year, int month, int day);
    }

    /**
     * Ensures that the container has implemented the interface
     * @param context the containing context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (DatePickerDialog.OnDateSetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnDateSetListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     * Called when a date has been picked
     * @param view The datepicker
     * @param year The selected year
     * @param month The selected month
     * @param day The selected day
     */
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        if(mCallback != null) {
            mCallback.onDateSet(view, year, month, day);
        }
    }
}
