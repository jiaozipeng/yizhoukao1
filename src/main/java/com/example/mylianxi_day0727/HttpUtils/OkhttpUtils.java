package com.example.mylianxi_day0727.HttpUtils;

import android.os.Handler;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/***

 **  项目名称：MyApp_day720
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/23 9:18
 **  星期一


 **/
public class OkhttpUtils {

      public static OkhttpUtils httpUtils;
          public static OkHttpClient client;
          public static Handler handler = new Handler();



          public OkhttpUtils() {

              client= new OkHttpClient.Builder().build();

          }
          public static OkHttpClient getclient(){
              return client;
          }

          public static Handler getHandler() {
              return handler;
          }



          //赖汉师
          public static OkhttpUtils getInstance(){

              if(httpUtils==null){
                  synchronized (OkhttpUtils.class){
                      if(httpUtils==null){
                          httpUtils= new OkhttpUtils();
                      }
                  }

              }
              return httpUtils;
          }

          //get异步网络请求
          public void get(String url, Callback callback){

              Request build = new Request.Builder().url(url).build();

              Call call = getclient().newCall(build);


              call.enqueue(callback);
          }
}
