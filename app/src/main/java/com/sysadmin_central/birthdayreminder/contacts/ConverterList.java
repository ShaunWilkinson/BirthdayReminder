package com.sysadmin_central.birthdayreminder.contacts;

import android.text.TextUtils;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterList {

    /**
     * Converts a given string to an String List
     * @param list A comma seperated string of values
     * @return A List of strings
     */
    @TypeConverter
    public static List<String> toList(String list) {
        if(list == null)
            return null;

        String[] commaSeparatedArr = list.split("\\s*,\\s*");

        return new ArrayList<>(Arrays.asList(commaSeparatedArr));
    }

    /**
     * Converts a given String List into a String
     * @param string The List String to convert
     * @return A simple comma-seperated string
     */
    @TypeConverter
    public static String fromList(List<String> string) {
        if(string == null)
            return null;

        return TextUtils.join(",", string);
    }
}
