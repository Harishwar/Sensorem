package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Light extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("" + sensorEvent.values[0] +" lx");
    }

    @Override
    protected String getSensorTitle() {
        return "Light Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_LIGHT;
    }

}
