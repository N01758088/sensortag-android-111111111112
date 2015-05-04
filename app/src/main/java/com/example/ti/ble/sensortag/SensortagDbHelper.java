package com.example.ti.ble.sensortag;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sethu_000 on 5/4/2015.
 */
public class SensortagDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "sensor.db";
    public static final String TABLE_NAME = "sensor_table";

    private static final int DATABASE_VERSION = 2;

    public static final String COLUMN_DEVICEID = "device_id";
    public static final String COLUMN_TEMPERATURE = "temperature";
    public static final String COLUMN_HUMIDITY = "humidity";
    public static final String COLUMN_BAROMETER = "barometer";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public SensortagDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table " + TABLE_NAME +" (DEVICEID TEXT, TEMPERATURE TEXT, HUMIDITY TEXT, BAROMETER TEXT, TIMESTAMP TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
