package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;

public class Accelerometer extends SensorHandler {

    float Xvalue = 0.0F, Yvalue = 0.0F, Zvalue = 0.0F;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x,y,z;

        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];

        X.setText("x : " + x + " m/s\u00B2");
        Y.setText("y : " + y + " m/s\u00B2");
        Z.setText("z : " + z + " m/s\u00B2");

        Xvalue = x;
        Yvalue = y;
        Zvalue = z;
    }

    @Override
    protected String getSensorTitle() {
        return "Accelerometer";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_ACCELEROMETER;
    }

}