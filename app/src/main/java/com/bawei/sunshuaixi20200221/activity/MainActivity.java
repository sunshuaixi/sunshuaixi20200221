package com.bawei.sunshuaixi20200221.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.sunshuaixi20200221.R;
import com.bawei.sunshuaixi20200221.adapter.List1Adapter;
import com.bawei.sunshuaixi20200221.adapter.List2Adapter;
import com.bawei.sunshuaixi20200221.adapter.ListAdapter;
import com.bawei.sunshuaixi20200221.base.BaseActivity;
import com.bawei.sunshuaixi20200221.base.BasePresenter;
import com.bawei.sunshuaixi20200221.bean.ListBean;
import com.bawei.sunshuaixi20200221.bean.XbannerBean;
import com.bawei.sunshuaixi20200221.contract.IHomeContract;
import com.bawei.sunshuaixi20200221.presenter.HomePresenter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaseActivity implements IHomeContract.IView {


    private GridView gv;
    private XBanner xb;
    private GridView gv1;
    private ListView lv;


    @Override
    public BasePresenter initPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        xb = findViewById(R.id.xb);
        gv = findViewById(R.id.gv);
        lv = findViewById(R.id.lv);
        gv1 = findViewById(R.id.gv1);

    }

    @Override
    protected void initData() {
        String xbanner="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
        String list="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
        BasePresenter presenter = getPresenter();
        if(presenter!=null&&presenter instanceof HomePresenter){
            ((HomePresenter) presenter).getXbanner(xbanner);
            ((HomePresenter) presenter).getList(list);
        }
        
    }

    @Override
    public void onListSuccess(String str) {
        Log.i("xxx",str);
        Gson gson = new Gson();
        ListBean listBean = gson.fromJson(str, ListBean.class);
        ListBean.ResultBean result = listBean.getResult();
        ListBean.ResultBean.RxxpBean rxxp = result.getRxxp();
        final List<ListBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp.getCommodityList();
        ListAdapter listAdapter = new ListAdapter(this, commodityList);
        gv.setAdapter(listAdapter);
       gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               ListBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = commodityList.get(position);
               String commodityName = commodityListBean.getCommodityName();
               Intent intent = new Intent(MainActivity.this, Main2Activity.class);
               intent.putExtra("name",commodityName);
               startActivity(intent);
           }
       });
        ListBean.ResultBean.MlssBean mlss = result.getMlss();
        final List<ListBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList1 = mlss.getCommodityList();
        List1Adapter list1Adapter = new List1Adapter(this, commodityList1);
        lv.setAdapter(list1Adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBean = commodityList1.get(position);
                String commodityName = commodityListBean.getCommodityName();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("name",commodityName);
                startActivity(intent);
            }
        });
        ListBean.ResultBean.PzshBean pzsh = result.getPzsh();
        final List<ListBean.ResultBean.PzshBean.CommodityListBeanX> commodityList2 = pzsh.getCommodityList();
        List2Adapter list2Adapter = new List2Adapter(this, commodityList2);
        gv1.setAdapter(list2Adapter);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBean.ResultBean.PzshBean.CommodityListBeanX commodityListBean = commodityList2.get(position);
                String commodityName = commodityListBean.getCommodityName();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("name",commodityName);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onListFailure(String str) {

    }

    @Override
    public void onXbannerSuccess(String str) {
        Log.i("xxx",str);
        Gson gson = new Gson();
        XbannerBean xbannerBean = gson.fromJson(str, XbannerBean.class);
        final List<XbannerBean.ResultBean> result = xbannerBean.getResult();
        xb.setBannerData(result);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                XbannerBean.ResultBean resultBean = result.get(position);
                String imageUrl = resultBean.getImageUrl();
                Glide.with(MainActivity.this).load(imageUrl).error(R.mipmap.ic_launcher).into((ImageView) view);
            }
        });
    }

    @Override
    public void onXbannerFailure(String str) {
        Log.i("xxx",str);
    }
}
