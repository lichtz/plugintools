package com.example.licht.pluginlib;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * 代理Activity 管理插件Activity的生命周期
 */
public class ProxyActivity extends Activity {
    private String mClassName;
    private PluginAPK mPluginApk;
    private Iplugin mIplugin;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mClassName= getIntent().getStringExtra("className");
       Log.i("zyl",mClassName);
        mPluginApk=PluginManager.getInstance().getmPluginApk();
        launchPluginActivity();
    }

    private void launchPluginActivity() {
        if (mPluginApk == null){
            throw new RuntimeException("load your apk file first please!");
        }
        try {
            Class<?> clazz = mPluginApk.mClassLoader.loadClass(mClassName);
            Object o = clazz.newInstance();
            if (o instanceof Iplugin){
                mIplugin = (Iplugin) o;
                mIplugin.attach(this);
                Bundle bundle = new Bundle();
                bundle.putInt("FROM",Iplugin.FROM_EXTERANL);
                mIplugin.onCreate(bundle);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return mPluginApk != null?mPluginApk.mResource:super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null?mPluginApk.mAssetManager:super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk !=null?mPluginApk.mClassLoader:super.getClassLoader();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mIplugin != null){
            mIplugin.onResume();
        }
    }
}
