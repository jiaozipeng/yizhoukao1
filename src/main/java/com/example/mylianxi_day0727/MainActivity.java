package com.example.mylianxi_day0727;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mylianxi_day0727.Model.ShowBean;
import com.example.mylianxi_day0727.Presenter.Presenter;
import com.example.mylianxi_day0727.View.IShowView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowView{

    private Presenter presenter;
    private XRecyclerView xrecycler;
    private RecyclerAdapter adapter;
    private EditText edittext;
    private TextView text;
    private int page;
    private String name="手机";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化presenter
        presenter =new Presenter(this);
       // presenter.getData(name,page);
        edittext= findViewById(R.id.edittext);

        getinto();
        text= findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name= edittext.getText().toString();
                presenter.getData(name,page);
            }
        });





    }

    private void getinto() {
        //获取资源ID
        xrecycler= findViewById(R.id.xrecycler);
        xrecycler.setLoadingMoreEnabled(true);
        xrecycler.setPullRefreshEnabled(true);
        xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
               presenter.getData(name,page);
               xrecycler.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                page++;
                presenter.getData(name,page);
                xrecycler.loadMoreComplete();

            }
        });
        adapter = new RecyclerAdapter(this);
        xrecycler.setLayoutManager(new LinearLayoutManager(this));
        xrecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        xrecycler.setAdapter(adapter);

    }

    @Override
    public void getDataList(ShowBean showBean) {
        List<ShowBean.DataBean> data = showBean.getData();
        Log.i("TAG",data+"");
        if(page==0){
            adapter.cleanData(data);
        }else {
            adapter.addData(data);
        }
        adapter.setonItemList(new RecyclerAdapter.onItemListen() {
            @Override
            public void getonItem(String detailUrl,int pid) {

                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("s",detailUrl);
                startActivity(intent);
            }
        });

    }
}
