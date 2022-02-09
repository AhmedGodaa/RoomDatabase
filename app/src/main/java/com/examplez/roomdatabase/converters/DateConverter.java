package com.examplez.roomdatabase.converters;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long milliseconds) {
        return milliseconds != null ? new Date(milliseconds) : null;

    }

    @TypeConverter
    public static Long fromDate(Date date) {
        return date != null ? date.getTime() : null;


    }
}
