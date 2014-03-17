package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class AmbientTemperature extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("" + sensorEvent.values[0] + " \u00B0C");
    }

    @Override
    protected String getSensorTitle() {
        return "Ambient Temperature Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_AMBIENT_TEMPERATURE;
    }

}
