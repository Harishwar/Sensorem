package com.harishwar.sensorem;

import com.harishwar.sensorem.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SensorHandler extends Activity implements SensorEventListener {

    protected SensorManager m;
    protected Sensor s;
    protected TextView title, details, X, Y, Z;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensors);

        title = (TextView) findViewById(R.id.sensor_name);
        title.setText(getSensorTitle());        
        
        X = (TextView) findViewById(R.id.textView1);
        Y = (TextView) findViewById(R.id.textView2);
        Z = (TextView) findViewById(R.id.textView3);

        m = (SensorManager) getSystemService(SENSOR_SERVICE);
        s = m.getDefaultSensor(getSensorType());
        if (s == null) {
            Toast.makeText(getApplicationContext(),
                    "Sensor is not available", Toast.LENGTH_SHORT).show();
            return;
        }
        
        String sd = "Sensor Details:\n\n";

        sd += "Name: " + s.getName() + "\n";
        sd += "Vendor: " + s.getVendor() + "\n";
        sd += "Power: " + s.getPower() + "mA\n";
        sd += "Max Range: " + s.getMaximumRange() + "\n";
        sd += "Resolution: " + s.getResolution() + "\n";
        
        details = (TextView) findViewById(R.id.sensor_details);
        details.setTextSize(20);
        details.setText(sd);        
        
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
    	
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    	
    }

    @Override
    protected void onResume() {
        super.onResume();
        m.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        m.unregisterListener(this);
    }

    protected String getUnit() {
        return "";
    }

    protected String getSensorTitle() {
        return "Title not set";
    }

    protected int getSensorType() {
        return -1;
    }
    

}
