package com.example.licht.pluginapk;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static String copyAssetAndWrite(Context context, String fileName){
        File cacheDir = context.getCacheDir();
        if (!cacheDir.exists()){
            cacheDir.mkdirs();
        }
        Log.i("copyAssetAndWrite",cacheDir.getAbsolutePath());
        File outFile = new File(cacheDir, fileName);
        if (!outFile.exists()){
            try {
                boolean res = outFile.createNewFile();
                if (res){
                    InputStream open = context.getAssets().open(fileName);
                    FileOutputStream fileOutputStream = new FileOutputStream(outFile);
                    Log.i("copyAssetAndWrite",open.available()+"AA");
                    byte[] buffer = new byte[open.available()];
                    int byteCount;
                    while ((byteCount = open.read(buffer))!= -1){
                        fileOutputStream.write(buffer,0,byteCount);
                    }
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    Log.i("copyAssetAndWrite","下载成功");
                return outFile.getAbsolutePath();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Log.i("copyAssetAndWrite","文件存在");
            return outFile.getAbsolutePath();
        }
        return "";
    }
}
