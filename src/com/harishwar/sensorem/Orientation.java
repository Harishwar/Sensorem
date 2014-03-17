package com.harishwar.sensorem;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Orientation extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("Angle : " + sensorEvent.values[0]);
        Y.setText("Pitch : " + sensorEvent.values[1]);
        Z.setText("Roll : " + sensorEvent.values[2]);
    }

    @Override
    protected String getSensorTitle() {
        return "Orientation Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_ORIENTATION;
    }

}