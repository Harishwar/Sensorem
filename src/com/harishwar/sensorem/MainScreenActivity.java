package com.harishwar.sensorem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.harishwar.sensorem.R;

import android.graphics.drawable.GradientDrawable.Orientation;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainScreenActivity extends Activity implements AdapterView.OnItemClickListener {
	
	SensorManager m;
    ListView lv;
    List<Sensor> sensorslist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		
		m = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lv = (ListView) findViewById(R.id.sensors_list);
        sensorslist = m.getSensorList(Sensor.TYPE_ALL);

        SimpleAdapter adapter = new SimpleAdapter(this,
                getFormattedSensorData(),
                android.R.layout.simple_list_item_2,
                new String[]{"sensor", "details"},
                new int[]{android.R.id.text1,
                        android.R.id.text2});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        
	}

	//Sensor List Array
    public ArrayList<Map<String, String>> getFormattedSensorData() {
        ArrayList<Map<String, String>> sensors = new ArrayList<Map<String, String>>();

        for (Sensor s : sensorslist) {
            Map<String, String> sensor = new HashMap<String, String>();

            String description = s.getVendor();

            sensor.put("sensor", s.getName());
            sensor.put("details", description);

            sensors.add(sensor);
        }

        return sensors;
    }

    //Retuns true for Implemented sensors
    public boolean Sensors(Sensor s) {
        switch (s.getType()) {            
        	case Sensor.TYPE_ACCELEROMETER:
        	case Sensor.TYPE_AMBIENT_TEMPERATURE:
            case Sensor.TYPE_GRAVITY:
            case Sensor.TYPE_GYROSCOPE:
            case Sensor.TYPE_LIGHT:
            case Sensor.TYPE_LINEAR_ACCELERATION:
            case Sensor.TYPE_MAGNETIC_FIELD:
            case Sensor.TYPE_PROXIMITY:
            case Sensor.TYPE_PRESSURE:
            case Sensor.TYPE_RELATIVE_HUMIDITY:
            case Sensor.TYPE_ROTATION_VECTOR:
            case Sensor.TYPE_ORIENTATION:
                return true;

            default:
                return false;
        }
    }
    
    //Sensor List Item Click
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Sensor s = sensorslist.get(i);

        if (Sensors(s)) {

            Class c = null;

            switch (s.getType()) {
            	case Sensor.TYPE_ACCELEROMETER:
            		c = Accelerometer.class;
                break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    c = AmbientTemperature.class;
                    break;
                case Sensor.TYPE_GRAVITY:
                    c = Gravity.class;
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    c = Gyroscope.class;
                    break;
                case Sensor.TYPE_LIGHT:
                    c = Light.class;
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    c = LinearAcceleration.class;
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    c = MagneticField.class;
                    break;
                case Sensor.TYPE_PRESSURE:
                    c = Pressure.class;
                    break;
                case Sensor.TYPE_PROXIMITY:
                    c = Proximity.class;
                    break;
                case Sensor.TYPE_RELATIVE_HUMIDITY:
                    c = RelativeHumidity.class;
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                	c = RotationVector.class;
                	break;
                case Sensor.TYPE_ORIENTATION:
                	//Orientation deprecated in API level 8
                	if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
                		Toast.makeText(getApplicationContext(), "Sensor Activity Not Available",
                                Toast.LENGTH_SHORT).show();
                	} else {
                		c = Orientation.class;
                	}
                	break;

            }
            if (c != null) {
                Intent intent = new Intent(this, c);
                startActivity(intent);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Sensor Activity Not Available",
                    Toast.LENGTH_SHORT).show();
        }
    }
	
	
}
