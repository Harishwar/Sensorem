package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Gravity extends SensorHandler {

    protected int sensor_type = Sensor.TYPE_GRAVITY;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("x = " + sensorEvent.values[0] + " m/s\u00B2");
        Y.setText("y = " + sensorEvent.values[1] + " m/s\u00B2");
        Z.setText("z = " + sensorEvent.values[2] + " m/s\u00B2");
    }

    @Override
    protected String getSensorTitle() {
        return "Gravity Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_GRAVITY;
    }

}
