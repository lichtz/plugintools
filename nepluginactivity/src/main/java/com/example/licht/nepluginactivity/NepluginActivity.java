package com.example.licht.nepluginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.licht.pluginlib.PluginAPK;
import com.example.licht.pluginlib.PluginActivity;

public class NepluginActivity extends PluginActivity {

    private static final String TAG = "NepluginActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("zyl","NepluginActivity "+"onCreate ");
        super.onCreate(savedInstanceState);
        Log.i("zyl","NepluginActivity "+"onCreate 2");
        setContentView(R.layout.activity_neplugin);
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(mProxyActivity,"BBB",Toast.LENGTH_SHORT).show();


    }
}
