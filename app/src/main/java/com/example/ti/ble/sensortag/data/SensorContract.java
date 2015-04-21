package com.example.ti.ble.sensortag.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

/**
 * Created by sethu_000 on 4/21/2015.
 */

/**
 * Defines table and column names for the Sensor database.
 */

public class SensorContract {

    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "com.example.ti.ble.sensortag";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://com.example.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.sunshine.app/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.
    public static final String PATH_SENSOR = "sensor";

    // To make it easy to query for the exact date, we normalize all dates that go into
    // the database to the start of the the Julian day at UTC.
    public static long normalizeDate(long startDate) {
        // normalize the start date to the beginning of the (UTC) day
        Time time = new Time();
        time.setToNow();
        int julianDay = Time.getJulianDay(startDate, time.gmtoff);
        return time.setJulianDay(julianDay);
    }


    /*
           Inner class that defines the contents of the location table
           Students: This is where you will add the strings.  (Similar to what has been
           done for WeatherEntry)
        */
    public static final class SensorEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SENSOR).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SENSOR;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SENSOR;

        // Table name
        public static final String TABLE_NAME = "sensor";

        // The location setting string is what will be sent to openweathermap
        // as the location query.
        public static final String COLUMN_DEVICEID = "device_id";

        // Human readable location string provided by the API. Because for styling,
        // "Mountain View" is more recognizable than 94043.
        public static final String COLUMN_TEMPERATURE = "temperature";

        // In order to uniquely pinpoint the location on the map when we launch the
        // map intent, we store the latitude and longitude as returned by openweathermap.
        public static final String COLUMN_HUMIDITY = "humidity";
        public static final String COLUMN_BAROMETER = "barometer";
        public static final String COLUMN_TIMESTAMP = "timestamp";

        public static Uri buildSensorUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

   /* public static Uri buildWeatherLocationWithStartDate(
            String locationSetting, long startDate) {
        long normalizedDate = normalizeDate(startDate);
        return CONTENT_URI.buildUpon().appendPath(locationSetting)
                .appendQueryParameter(COLUMN_DATE, Long.toString(normalizedDate)).build();
    }

    public static Uri buildWeatherLocationWithDate(String locationSetting, long date) {
        return CONTENT_URI.buildUpon().appendPath(locationSetting)
                .appendPath(Long.toString(normalizeDate(date))).build();
    }

     public static long getDateFromUri(Uri uri) {
        return Long.parseLong(uri.getPathSegments().get(2));
    }

    public static long getStartDateFromUri(Uri uri) {
        String dateString = uri.getQueryParameter(COLUMN_DATE);
        if (null != dateString && dateString.length() > 0)
            return Long.parseLong(dateString);
        else
            return 0;
    }
}*/
    }
}