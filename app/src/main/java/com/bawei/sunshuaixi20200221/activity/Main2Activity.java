package com.bawei.sunshuaixi20200221.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.sunshuaixi20200221.R;
import com.bawei.sunshuaixi20200221.base.BaseActivity;
import com.bawei.sunshuaixi20200221.base.BasePresenter;

public class Main2Activity extends BaseActivity {


    private TextView tv;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv.setText(name);
    }
}
