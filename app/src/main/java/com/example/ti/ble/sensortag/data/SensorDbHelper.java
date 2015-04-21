
package com.example.ti.ble.sensortag.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ti.ble.sensortag.data.SensorContract.SensorEntry;

/**
 * Created by sethu_000 on 4/14/2015.
 */

/**
 * Manages a local database for weather data.
 */
public class SensorDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "sensor.db";

    public SensorDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        final String SQL_CREATE_SENSOR_TABLE = "CREATE TABLE " + SensorEntry.TABLE_NAME + " (" +

                SensorEntry._ID + " INTEGER PRIMARY KEY," +
                SensorEntry.COLUMN_DEVICEID + " TEXT NOT NULL," +
                SensorEntry.COLUMN_TEMPERATURE + " TEXT NOT NULL," +
                SensorEntry.COLUMN_HUMIDITY + " TEXT NOT NULL, " +
                SensorEntry.COLUMN_BAROMETER + " TEXT NOT NULL, " +
                SensorEntry.COLUMN_TIMESTAMP + " TEXT NOT NULL " +

                " );";
        sqLiteDatabase.execSQL(SQL_CREATE_SENSOR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SensorEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
