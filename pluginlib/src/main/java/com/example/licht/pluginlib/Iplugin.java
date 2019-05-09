package com.example.licht.pluginlib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public interface Iplugin {
    int FROM_INTERNAL = 0;
    int FROM_EXTERANL = 1;
    void attach(Activity proxyActivity);
    void onCreate(Bundle saveInstanceState);
    void onStart();
    void onRestart();
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();

}
