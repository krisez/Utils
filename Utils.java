package com.krisez.m.nofiphone;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Krisez on 2016/9/13.
 */
public class Utils {
    public static void setHttpConnection(final String address, final MyCallBack myCallback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection =null;
                try {
                    URL url = new URL(address);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(1000);
                    httpURLConnection.setReadTimeout(1000);
                    InputStream in = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    if(myCallback != null){
                        myCallback.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if(myCallback != null){
                        myCallback.onError(e);
                    }
                }
                finally {
                    if(httpURLConnection != null){
                        httpURLConnection.disconnect();
                    }
                }
            }
        }).start();
    }

    protected interface MyCallBack{
        void onFinish(String response);
        void onError(Exception e);
    }

    public static String RandomColor(int pos){
        String color = null;
        int a = 3;
        switch (pos%3){
            case 0:color = "#F03045";break;
            case 1:color = "#FFECB2";break;
            case 2:color = "#2877CE";break;
        }

        return color;
    }

    public static int px2dip(Context context, Float pxVaule){
        Float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxVaule/scale + 0.5f);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 对String类型的数据进行修改的新的数据
     */
    public static String newString(String Change){
        char a[] = Change.toCharArray();
        String result = " ";
        int j = 0;
        while (a[j] != '-'){
            j++;
        }
        for(int i = ++j;i < Change.length();i++){
            if(a[i]==' ')
                result += '\n';
            result += a[i];
        }
        return result;
    }

    /**
     * 得到课程的代码  类似于A0000000000
     */
    public static String lessonCode(String all_content){
        char a[] = all_content.toCharArray();
        String result = "";
        int j = 0;
        while (a[j] != ' '){
            j++;
        }
        for(int i = 0;i < j;i++){
            result += a[i];
        }
        return result;
    }
}
