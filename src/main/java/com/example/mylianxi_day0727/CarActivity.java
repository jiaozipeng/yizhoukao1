package com.example.mylianxi_day0727;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.example.mylianxi_day0727.HttpUtils.OkhttpBack;
import com.example.mylianxi_day0727.HttpUtils.OkhttpUtils;
import com.example.mylianxi_day0727.Model.CarBean;
import com.google.gson.Gson;

import java.util.List;

public class CarActivity extends AppCompatActivity {

    private ExpandableListView expandable;
    private List<CarBean.DataBean> data;
    ExpandableAdapter expandableAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        //获取资源ID
        expandable= findViewById(R.id.expandable);

        getData();



    }

    private void getData() {
        OkhttpUtils.getInstance().get("https://www.zhaoapi.cn/product/getCarts?uid=4243&token=94A2C256471982A75C170CAB844FE4FE", new OkhttpBack() {
            @Override
            public void success(String json) {
                Log.i("TAG",json);
                Gson gson = new Gson();
                CarBean carBean = gson.fromJson(json, CarBean.class);
                data = carBean.getData();

                expandableAdapter   = new ExpandableAdapter(CarActivity.this);
                expandable.setAdapter(expandableAdapter);
                expandableAdapter.addData(data);
                expandableAdapter.expandGrou(expandable);


            }

            @Override
            public void failed(String json) {

            }
        });
    }
}
