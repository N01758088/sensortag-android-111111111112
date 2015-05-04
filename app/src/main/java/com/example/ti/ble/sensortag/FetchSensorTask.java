package com.example.ti.ble.sensortag;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetchSensorTask extends AsyncTask<Void, Void, Void> {
    private final String LOG_TAG = FetchSensorTask.class.getSimpleName();

    @Override
    protected Void doInBackground(Void... params) {
        String msg = " ";
        String hmsg = " ";
        String bmsg = " ";
        String tmsg = " ";

        String[] sensorArray = {msg, hmsg, bmsg, tmsg};
        List<String> sensorReadings = new ArrayList<String>(Arrays.asList(sensorArray));


        String value = "tamil";

        // Loop through elements.
        for (int i = 0; i < sensorReadings.size(); i++) {
            value = value + sensorReadings.get(i);
           // System.out.println("Element: " + value);
        }
        Log.e(LOG_TAG, value);

        return null;
    }
}