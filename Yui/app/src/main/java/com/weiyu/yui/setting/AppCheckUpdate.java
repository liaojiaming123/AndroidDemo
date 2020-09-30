package com.weiyu.yui.setting;

import android.content.Context;
import android.os.Environment;

import java.io.FileOutputStream;
import java.io.IOException;

public class AppCheckUpdate {
    private Context context;
    private HttpURLConnectionUtils connectionUtils;
    public AppCheckUpdate(Context context){
        this.context = context;
    }

    public void checkUpdate() {
        connectionUtils = new HttpURLConnectionUtils(context);
        final String url = "http://www.liaojiaming.com/static/my.mp3";
        final int connectionTomeOut = 10000;
        final int readTimeOut = 10000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] bytes = connectionUtils.getRequestBytes(url, connectionTomeOut, readTimeOut);
                    saveCache("my.mp3",bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    /**
     * 判断SD卡是否可用
     * */
    private static Boolean isSDCardReady(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
    /**
     * 获取SD卡缓存路径
     * */
    private String getCacheDir(){
        if (isSDCardReady()) {
            return Environment.getExternalStorageState(context.getExternalCacheDir());
        } return null;
    }
    /**
     * 缓存文件 filename文件名 bytes字节数组
     * */
    public void saveCache(String filename,byte[] bytes) throws IOException {
        if (isSDCardReady()&&getCacheDir()!=null){
            FileOutputStream outputStream = new FileOutputStream(getCacheDir()+filename);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }
    }
}
