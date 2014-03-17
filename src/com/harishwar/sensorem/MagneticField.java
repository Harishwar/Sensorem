package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class MagneticField extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("x = " + sensorEvent.values[0] + " \u03BCT");
        Y.setText("y = " + sensorEvent.values[1] + " \u03BCT");
        Z.setText("z = " + sensorEvent.values[2] + " \u03BCT");
    }

    @Override
    protected String getSensorTitle() {
        return "Magnetic Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_MAGNETIC_FIELD;
    }

}
