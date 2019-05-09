package com.example.licht.pluginapk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.licht.pluginlib.PluginManager;
import com.example.licht.pluginlib.ProxyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginManager.getInstance().init(this);
    }

    public void load(View view) {
        String apkPath =Utils.copyAssetAndWrite(MainActivity.this,"aa.apk");
        PluginManager.getInstance().loadApk(apkPath);
    }

    public void jump(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ProxyActivity.class);
        intent.putExtra("className","com.example.licht.nepluginactivity.NepluginActivity");
        startActivity(intent);

    }
}
