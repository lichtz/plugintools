package com.example.licht.pluginlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class PluginManager {
    private static final  PluginManager instance = new PluginManager();
    public  static PluginManager getInstance(){
        return  instance;
    }

    private Context mContext;
    private PluginAPK mPluginApk;
    private  PluginManager(){}
    public  void  init(Context context){
        mContext = context.getApplicationContext();
    }
    public void  loadApk(String apkPath){
        PackageInfo packageInfo = mContext.getPackageManager()
                .getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
        if (packageInfo == null){
            return;
        }
        DexClassLoader classLoader = createDexClassLoader(apkPath);
        AssetManager am = createAssetManager(apkPath);
        Resources resources = createResource(am);
        mPluginApk = new PluginAPK(packageInfo,resources,classLoader);
    }

    private Resources createResource(AssetManager am) {
        Resources res = mContext.getResources();
        Log.i("zyl",am.getLocales().length+"AA");
        return new Resources(am,res.getDisplayMetrics(),res.getConfiguration());
    }

    private AssetManager createAssetManager(String apkPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.invoke(assetManager,apkPath);
            return assetManager;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DexClassLoader createDexClassLoader(String apkPath) {
        File dex = mContext.getDir("dex", Context.MODE_PRIVATE);
        return new DexClassLoader(apkPath,dex.getAbsolutePath(),null,mContext.getClassLoader());
    }

    public PluginAPK getmPluginApk(){
        return mPluginApk;
    }
}
