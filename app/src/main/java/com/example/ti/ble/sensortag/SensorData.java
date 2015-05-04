package com.example.ti.ble.sensortag;

/**
 * Created by sethu_000 on 5/3/2015.
 */

public class SensorData{

    // List<SensorData> sensorReadings = new ArrayList<SensorData>();

    String deviceId;
    String temp;
    String hum;
    String bar;

    public void sensorData(String I, String t, String h, String b){
        this.deviceId = I;
        this.temp = t;
        this.hum = h;
        this.bar= b;
    }
}