package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class RelativeHumidity extends SensorHandler {

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        X.setText("" + sensorEvent.values[0] + " %");
    }

    @Override
    protected String getSensorTitle() {
        return "Relative Humidity Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_RELATIVE_HUMIDITY;
    }

}
