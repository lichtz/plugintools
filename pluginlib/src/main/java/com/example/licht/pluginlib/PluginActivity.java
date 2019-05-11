package com.example.licht.pluginlib;

import android.app.Activity;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PluginActivity extends Activity implements Iplugin {
   public Activity mProxyActivity;
   private int mFrom = FROM_INTERNAL;

    @Override
    public void attach(Activity proxyActivity) {
        mProxyActivity = proxyActivity;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        if (saveInstanceState != null){
            mFrom = saveInstanceState.getInt("FROM" );
        }

        if (mFrom == FROM_INTERNAL){
            super.onCreate(saveInstanceState);
            mProxyActivity = this;
        }
        Log.i("zyl","PluginActivity "+"onCreate ");
    }


    @Override
    public void setContentView(int layoutResID) {
        if (mFrom == FROM_INTERNAL){
            super.setContentView(layoutResID);
        }else {
            mProxyActivity.setContentView(layoutResID);
        }
    }

    @Override
    public void onStart() {
        if (mFrom == FROM_INTERNAL){
            super.onStart();
        }

    }

    @Override
    public void onRestart() {
        if (mFrom == FROM_INTERNAL){
            super.onRestart();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mFrom == FROM_INTERNAL){
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onResume() {
        if (mFrom == FROM_INTERNAL){
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if (mFrom == FROM_INTERNAL){
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mFrom == FROM_INTERNAL){
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if (mFrom == FROM_INTERNAL){
            super.onDestroy();
        }
    }
}
