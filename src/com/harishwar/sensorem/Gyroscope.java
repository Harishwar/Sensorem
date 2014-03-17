package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Gyroscope extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("x = " + sensorEvent.values[0] + " rad/s");
        Y.setText("y = " + sensorEvent.values[1] + " rad/s");
        Z.setText("z = " + sensorEvent.values[2] + " rad/s");
    }

    @Override
    protected String getSensorTitle() {
        return "Gyroscope Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_GYROSCOPE;
    }

}
