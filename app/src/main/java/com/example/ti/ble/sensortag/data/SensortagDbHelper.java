package com.example.ti.ble.sensortag.data;

/**
 * Created by sethu_000 on 5/4/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by sethu_000 on 5/4/2015.
 */
public class SensortagDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "sensortag.db";
    public static final String TABLE_NAME = "sensor_table";

    private static final int DATABASE_VERSION = 2;

    public static final String COLUMN_ROWID = "ID";
    public static final String COLUMN_DEVICEID = "DEVID";
    public static final String COLUMN_TEMPERATURE = "TEMP";
    public static final String COLUMN_HUMIDITY = "HUM";
    public static final String COLUMN_BAROMETER = "BAR";
    public static final String COLUMN_TIMESTAMP = "TIME";

    public SensortagDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
       // SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DEVID TEXT, TEMP TEXT, HUM TEXT, BAR TEXT, TIME TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String devid, String temp, String hum, String bar, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DEVICEID, devid);
        contentValues.put(COLUMN_TEMPERATURE, temp);
        contentValues.put(COLUMN_HUMIDITY, hum);
        contentValues.put(COLUMN_BAROMETER, bar);
        contentValues.put(COLUMN_TIMESTAMP, time);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

}
