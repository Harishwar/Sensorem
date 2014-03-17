package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class LinearAcceleration extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("x = " + sensorEvent.values[0] + " m/s\u00B2");
        Y.setText("y = " + sensorEvent.values[1] + " m/s\u00B2");
        Z.setText("z = " + sensorEvent.values[2] + " m/s\u00B2");
    }

    @Override
    protected String getSensorTitle() {
        return "Linear Acceleration Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_LINEAR_ACCELERATION;
    }

}
