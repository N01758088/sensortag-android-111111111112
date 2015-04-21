package com.example.ti.ble.sensortag.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;

/**
 * Created by sethu_000 on 4/21/2015.
 */
public class SensorService extends IntentService {

    private ArrayAdapter<String> mForecastAdapter;
    private Context mContext;
    public static final String LOCATION_QUERY_EXTRA = "lqe";
    private final String LOG_TAG = SensorService.class.getSimpleName();
    }

    @Override
    protected void onHandleIntent(Intent intent){
        String locationQuery = intent.getStringExtra(LOCATION_QUERY_EXTRA);

    }
}
