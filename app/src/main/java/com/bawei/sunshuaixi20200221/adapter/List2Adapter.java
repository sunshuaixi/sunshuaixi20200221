package com.bawei.sunshuaixi20200221.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.sunshuaixi20200221.R;
import com.bawei.sunshuaixi20200221.activity.MainActivity;
import com.bawei.sunshuaixi20200221.bean.ListBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public class List2Adapter extends BaseAdapter {
    Context context;
    List<ListBean.ResultBean.PzshBean.CommodityListBeanX> commodityList2;

    public List2Adapter(Context context, List<ListBean.ResultBean.PzshBean.CommodityListBeanX> commodityList2) {
        this.context = context;
        this.commodityList2 = commodityList2;
    }

    @Override
    public int getCount() {
        return commodityList2.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VoiewHoder hoder = new VoiewHoder();
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item2,null);
            hoder.iv=convertView.findViewById(R.id.iv);
            hoder.tv=convertView.findViewById(R.id.tv);
            convertView.setTag(hoder);
        }else{
           hoder=(VoiewHoder) convertView.getTag();
        }
        ListBean.ResultBean.PzshBean.CommodityListBeanX commodityListBean = commodityList2.get(position);
        String commodityName = commodityListBean.getCommodityName();
        String masterPic = commodityListBean.getMasterPic();
        hoder.tv.setText(commodityName);
        Glide.with(context).load(masterPic).into(hoder.iv);
        return convertView;
    }

    private class VoiewHoder{
        private ImageView iv;
        private TextView tv;
    }
}
