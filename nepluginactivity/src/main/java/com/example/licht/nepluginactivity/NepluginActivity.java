package com.example.licht.nepluginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.licht.pluginlib.PluginAPK;
import com.example.licht.pluginlib.PluginActivity;

public class NepluginActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neplugin);
    }
}
