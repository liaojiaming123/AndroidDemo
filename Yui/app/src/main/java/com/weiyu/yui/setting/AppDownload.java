package com.weiyu.yui.setting;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppDownload {
    private Context context;
    private HttpURLConnection httpURLConnection;
    public AppDownload(Context context){
        this.context = context;
    }
    public InputStream getInputStream() throws IOException {
        URL url = new URL("http://www.liaojiaming.com/static/app/my.mp3");
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.connect();
        if (httpURLConnection.getResponseCode()==200){
            return httpURLConnection.getInputStream();
        }else Toast.makeText(context, "连接失败", Toast.LENGTH_SHORT).show();
        return null;
    }
    public String getFilename(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//            return Environment.getExternalStorageState(context.getExternalCacheDir());
            File file = new File("");
            return context.getExternalFilesDir(Environment.getExternalStorageState(file)).getPath()+"/my.mp3";
        }else Toast.makeText(context, "没有找到SD卡", Toast.LENGTH_SHORT).show();
        return null;
    }

    public void saveFile() throws IOException {
        InputStream inputStream = getInputStream();
        String filename = getFilename();
        if(inputStream != null&& filename != null) {
//            File file = new File(filename+"/my.mp3");
            FileOutputStream outputStream = new FileOutputStream(filename+"/my.mp3");
            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            httpURLConnection.disconnect();
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            Toast.makeText(context, "下载完成", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "下载失败", Toast.LENGTH_SHORT).show();
    }
}
