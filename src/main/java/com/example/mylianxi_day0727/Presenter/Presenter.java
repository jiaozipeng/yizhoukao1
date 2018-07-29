package com.example.mylianxi_day0727.Presenter;

import com.example.mylianxi_day0727.MainActivity;
import com.example.mylianxi_day0727.Model.IShowBack;
import com.example.mylianxi_day0727.Model.IShowTask;
import com.example.mylianxi_day0727.Model.ShowBean;
import com.example.mylianxi_day0727.Model.ShowTask;
import com.example.mylianxi_day0727.View.IShowView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/***

 **  项目名称：MyApp_day720
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/27 17:45
 **  星期五


 **/
public class Presenter implements IPresenter,IShowBack{

    //M层
    IShowTask iShowTask;
    //V层
    IShowView iShowView;
    private String encode;

    public Presenter(MainActivity activity) {
        //实例化ishowtask
        iShowTask = new ShowTask();
        iShowView =activity;

    }

    @Override
    public void success(ShowBean showBean) {
iShowView.getDataList(showBean);
    }

    @Override
    public void failed(String msg) {

    }


    @Override
    public void getData(String name, int page) {
        try {
            encode = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        iShowTask.getList("http://www.zhaoapi.cn/product/searchProducts?keywords="+encode+"&"+page+"&sort=0",this);
    }
}
