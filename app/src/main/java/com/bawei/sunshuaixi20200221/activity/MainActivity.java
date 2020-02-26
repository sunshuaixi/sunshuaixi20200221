package com.bawei.sunshuaixi20200221.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawei.sunshuaixi20200221.R;
import com.bawei.sunshuaixi20200221.base.BaseActivity;
import com.bawei.sunshuaixi20200221.base.IbaseView;
import com.bawei.sunshuaixi20200221.contract.IHomeContract;
import com.bawei.sunshuaixi20200221.presenter.HomePresenter;
import com.stx.xhb.xbanner.XBanner;

public class MainActivity extends BaseActivity implements IHomeContract.IView {


    private ListView lv;
    private XBanner xb;

    @Override
    public IbaseView initPresenter() {
        return (IbaseView) new HomePresenter(this);
    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        String xbanner="http://172.17.8.100/small/commodity/v1/bannerShow";
        String list="http://172.17.8.100/small/commodity/v1/commodityList";
    }

    @Override
    public void onListSuccess(String str) {

    }

    @Override
    public void onListFailure(String str) {

    }

    @Override
    public void onXbannerSuccess(String str) {

    }

    @Override
    public void onXbannerFailure(String str) {

    }
}
