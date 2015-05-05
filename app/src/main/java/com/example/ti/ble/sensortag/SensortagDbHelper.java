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
db.execSQL("create table " + TABLE_NAME +" (ROWID TEXT, DEVICEID TEXT, TEMPERATURE TEXT, HUMIDITY TEXT, BAROMETER TEXT, TIMESTAMP TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Inserts User into SQLite DB
     * @param queryValues
     */
  /*  public void insertValues(HashMap<String, String> queryValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ROWID", queryValues.get("ROWID"));
        values.put("DEVICEID", queryValues.get("DEVICEID"));
        values.put("TEMPERATURE", queryValues.get("TEMPERATURE"));
        values.put("HUMIDITY", queryValues.get("HUMIDITY"));
        values.put("BAROMETER", queryValues.get("BAROMETER"));
        values.put("TIMESTAMP", queryValues.get("TIMESTAMP"));
        db.insert("sensorvalues", null, values);
        db.close();
    }

    /**
     * Get list of Users from SQLite DB as Array List
     * @return
     */
  /*  public ArrayList<HashMap<String, String>> getAllValues() {
        ArrayList<HashMap<String, String>> valuesList;
        valuesList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM sensorvalues";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ROWID", cursor.getString(0));
                map.put("DEVICEID", cursor.getString(1));
                map.put("TEMPERATURE", cursor.getString(2));
                map.put("HUMIDITY", cursor.getString(3));
                map.put("BAROMETER", cursor.getString(4));
                map.put("TIMESTAMP", cursor.getString(5));
                valuesList.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return valuesList;
    }
    */
}
