package com.weiyu.yui.setting;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class HttpURLConnectionUtils {
    Context context;
    public HttpURLConnectionUtils(Context context){this.context = context;}
    /**
     * get请求 返回字符串 同步请求 应放在子线程中
     * URLString请求的url connectTimeout连接超时 readTimeout响应超时
     * */
    public String getRequest(String urlString,int connectTimeout,int readTimeout) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return outputStream.toString("utf-8");
        } connection.disconnect();
        return null;
    }
    /**
     * get请求 返回字节数组 同步请求 应放在子线程中
     * URLString请求的url connectTimeout连接超时 readTimeout响应超时
     * */
    public byte[] getRequestBytes(String urlString,int connectTimeout,int readTimeout) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return outputStream.toByteArray();
        } connection.disconnect();
        return null;
    }
    /**
     * getRequest方法的异步请求
     * */
    public String getRequestAsync(final String urlString, final int connectTimeout, final int readTimeout){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getRequest(urlString,connectTimeout,readTimeout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }
    /**
     * getRequestBytes方法的异步请求
     * */
    public byte[] getRequestBytesAsync(final String urlString, final int connectTimeout, final int readTimeout){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getRequestBytes(urlString,connectTimeout,readTimeout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }
    /**
     * post请求 同步请求 返回字符串
     * urlString请求的url connectTimeout连接超时 readTimeout响应超时 post发送的数据
     * */
    public String postRequest(String urlString, int connectTimeout, int readTimeout, Map<String,Object> map) throws IOException {
        StringBuffer buffer = new StringBuffer();
        // 组织请求参数
        for (String key : map.keySet()) {
            if(buffer.length()!=0){
                buffer.append("&");
            }
            buffer.append(key).append("=").append(map.get(key));
        }
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("Content-Length", String.valueOf(buffer.length()));
        // 设置运行输入 输出 禁止缓存
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
        // 发送请求参数
        printWriter.write(buffer.toString());
        printWriter.flush();
        printWriter.close();
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return outputStream.toString("utf-8");
        } connection.disconnect();
        return null;
    }
    /**
     * post请求 同步请求 字节数组
     * urlString请求的url connectTimeout连接超时 readTimeout响应超时 post发送的数据
     * */
    public byte[] postRequestBytes(String urlString, int connectTimeout, int readTimeout, Map<String,Object> map) throws IOException {
        StringBuffer buffer = new StringBuffer();
        // 组织请求参数
        for (String key : map.keySet()) {
            if(buffer.length()!=0){
                buffer.append("&");
            }
            buffer.append(key).append("=").append(map.get(key));
        }
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("Content-Length", String.valueOf(buffer.length()));
        // 设置运行输入 输出 禁止缓存
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
        // 发送请求参数
        printWriter.write(buffer.toString());
        printWriter.flush();
        printWriter.close();
        if (connection.getResponseCode() == 200){
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,length);
            }
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return outputStream.toByteArray();
        } connection.disconnect();
        return null;
    }
    /**
     * postRequest方法的异步请求
     * */
    public String postRequestAsync(final String urlString, final int connectTimeout, final int readTimeout, final Map<String,Object> map){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    postRequest(urlString,connectTimeout,readTimeout,map);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }
    /**
     * postRequestBytes方法的异步请求
     * */
    public byte[] postRequestBytesAsync(final String urlString, final int connectTimeout, final int readTimeout, final Map<String,Object> map){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    postRequestBytes(urlString,connectTimeout,readTimeout,map);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }
}
