package com.example.mylianxi_day0727;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylianxi_day0727.Application.Myapplication;
import com.example.mylianxi_day0727.Model.CarBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***

 **  项目名称：MyApp_day720
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/29 13:42
 **  星期日


 **/
public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<CarBean.DataBean> list;

    public ExpandableAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }
    public void addData(List<CarBean.DataBean>dataBeans){
        list.addAll(dataBeans);
        notifyDataSetChanged();
    }

    public void expandGrou(ExpandableListView listView){
        for (int i=0;i<getGroupCount();i++){
              listView.expandGroup(i);
        }
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getList().size();
    }

    @Override
    public CarBean.DataBean getGroup(int i) {
        return list.get(i);
    }

    @Override
    public CarBean.DataBean.ListBean getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        CarBean.DataBean group = getGroup(i);
        return group.getId();
    }

    @Override
    public long getChildId(int i, int i1) {
        CarBean.DataBean.ListBean child = getChild(i, i1);
        return child.getSellerid();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        oneciewholder holder;
        if(view==null){
            view= View.inflate(context,R.layout.oneexpandable,null);
            holder= new oneciewholder();
            holder.car_text1=view.findViewById(R.id.car_text1);
            view.setTag(holder);

        }else{
            holder = (oneciewholder) view.getTag();
        }
        holder.car_text1.setText(list.get(i).getSellerName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {


        twoviewholder holder;
        if(view==null){
            view= View.inflate(context,R.layout.twoexpandable,null);
            holder= new twoviewholder();
            holder.car_text2= view.findViewById(R.id.car_text2);
            holder.car_image= view.findViewById(R.id.car_image);
            view.setTag(holder);

        }else{
            holder= (twoviewholder) view.getTag();
        }

        holder.car_text2.setText(list.get(i).getList().get(i1).getTitle());
        ImageLoader.getInstance().displayImage((list.get(i).getList().get(i1).getImages()).split("\\|")[0],holder.car_image, Myapplication.getoptions());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class oneciewholder{

        TextView car_text1;


    }
    class twoviewholder{
        TextView car_text2;
        ImageView car_image;

    }
}
