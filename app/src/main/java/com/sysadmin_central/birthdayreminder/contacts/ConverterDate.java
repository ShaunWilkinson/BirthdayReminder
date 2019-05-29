package com.sysadmin_central.birthdayreminder.contacts;

import androidx.room.TypeConverter;

import java.util.Date;

public class ConverterDate {
    @TypeConverter
    public static Date toDate(Long dateLong) {
        return dateLong == null ? null : new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }
}
