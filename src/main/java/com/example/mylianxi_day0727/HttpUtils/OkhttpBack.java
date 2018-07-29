package com.example.mylianxi_day0727.HttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/***

 **  项目名称：MyApp_day720
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/23 9:21
 **  星期一


 **/
public abstract class OkhttpBack implements Callback{


       //okhttpback
        public abstract void success(String json);

        /**
         * 失败
         * @param json
         */
        public abstract void failed(String json);

        @Override
        public void onFailure(Call call, final IOException e) {

            OkhttpUtils.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    failed(e.getMessage());

                }
            });

        }

        @Override
        public void onResponse(Call call, final Response response) throws IOException {

            final String string = response.body().string();
            OkhttpUtils.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    success(string);

                }
            });

        }
}
