package com.example.licht.pluginlib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

public class PluginAPK {
    public PackageInfo mPackageInfo;
    public Resources mResource;
    public AssetManager mAssetManager;
    public DexClassLoader mClassLoader;

    public PluginAPK(PackageInfo mPackageInfo, Resources mResource, DexClassLoader mClassLoader) {
        this.mPackageInfo = mPackageInfo;
        this.mResource = mResource;
        this.mClassLoader = mClassLoader;
        mAssetManager = mResource.getAssets();
    }
}
