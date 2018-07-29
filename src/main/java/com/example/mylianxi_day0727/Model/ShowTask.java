package com.example.mylianxi_day0727.Model;

import android.util.Log;

import com.example.mylianxi_day0727.HttpUtils.OkhttpBack;
import com.example.mylianxi_day0727.HttpUtils.OkhttpUtils;
import com.google.gson.Gson;

/***

 **  项目名称：MyApp_day720
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/27 17:46
 **  星期五


 **/
public class ShowTask implements IShowTask{
    @Override
    public void getList(String url, final IShowBack iShowBack) {
        OkhttpUtils.getInstance().get(url, new OkhttpBack() {
            @Override
            public void success(String json) {
                Gson gson = new Gson();
                ShowBean bean = gson.fromJson(json, ShowBean.class);
                Log.i("TAG",json);
                iShowBack.success(bean);
            }

            @Override
            public void failed(String json) {

                iShowBack.failed("sssss");
            }
        });
    }
}
