package com.harishwar.sensorem;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class RotationVector extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("x = " + sensorEvent.values[0]);
        Y.setText("y = " + sensorEvent.values[1]);
        Z.setText("z = " + sensorEvent.values[2]);
    }

    @Override
    protected String getSensorTitle() {
        return "Rotation Vector Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_ROTATION_VECTOR;
    }

}
