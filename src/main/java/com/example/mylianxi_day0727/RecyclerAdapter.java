package com.example.mylianxi_day0727;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylianxi_day0727.Application.Myapplication;
import com.example.mylianxi_day0727.Model.ShowBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/***

 **  项目名称：MyApp_day720
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/27 20:06
 **  星期五


 **/
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.reviewholder> {

    private Context context;
    private List<ShowBean.DataBean>list;
    private onItemListen onItemListen;

    public RecyclerAdapter(Context context) {
        this.context = context;
        list= new ArrayList<>();
    }
    public void addData(List<ShowBean.DataBean> dataBeans){
        list.addAll(dataBeans);
        notifyDataSetChanged();
    }
    public void cleanData(List<ShowBean.DataBean> dataBeans){
        list.clear();
        list.addAll(dataBeans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public reviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new reviewholder(LayoutInflater.from(context).inflate(R.layout.recyclerbase,null));
    }

    @Override
    public void onBindViewHolder(@NonNull reviewholder reviewholder, int i) {
        reviewholder.text1.setText(list.get(i).getTitle());

        ImageLoader.getInstance().displayImage((list.get(i).getImages()).split("\\|")[0],reviewholder.image, Myapplication.getoptions());

        final String detailUrl = list.get(i).getDetailUrl();
        final int pid = list.get(i).getPid();
        reviewholder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemListen.getonItem(detailUrl,pid);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class reviewholder extends RecyclerView.ViewHolder{

        TextView text1;
        ImageView image;
        public reviewholder(@NonNull View itemView) {
            super(itemView);
            text1= itemView.findViewById(R.id.text1);
            image = itemView.findViewById(R.id.image);
        }
    }

    public  void setonItemList(RecyclerAdapter.onItemListen onItemListen) {
        this.onItemListen = onItemListen;
    }

    public interface onItemListen{
        void getonItem(String detailUrl,int pid);
    }
}
