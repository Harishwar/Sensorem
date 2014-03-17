package com.harishwar.sensorem;

import com.harishwar.sensorem.SensorHandler;
import com.harishwar.sensorem.Proximity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.widget.TextView;

public class Proximity extends SensorHandler {

	private float lastVal = -1;

	ComponentName compName;
	DevicePolicyManager deviceManager;
	TextView textView;
	Window window = this.getWindow();
	boolean isScreenOn;
	boolean active;
	
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float thisVal = sensorEvent.values[0];
        if (this.lastVal == -1) {
            this.lastVal = thisVal;
        } else {
            this.lastVal = thisVal;
        }
        X.setText("Current Proximity Value: " + this.lastVal + " cm"); 

    }
    
    @Override
    protected String getSensorTitle() {
        return "Proximity Sensor";
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_PROXIMITY;
    }
    
}