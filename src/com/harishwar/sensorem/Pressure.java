package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Pressure extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("" + sensorEvent.values[0] + " hPa");
    }

    @Override
    protected String getSensorTitle() {
        return "Pressure Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_PRESSURE;
    }

    @Override
    protected String getUnit() {
        return "hPa";
    }
}
