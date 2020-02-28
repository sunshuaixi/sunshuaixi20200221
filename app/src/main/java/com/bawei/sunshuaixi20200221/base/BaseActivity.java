package com.bawei.sunshuaixi20200221.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.sunshuaixi20200221.R;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IbaseView{

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(getlayoutID());
        //找控件
        initView();
        //获取数据
        initData();
        presenter = getPresenter();
    }

    public abstract P getPresenter();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
    }

    protected abstract int getlayoutID();

    protected abstract void initView();

    protected abstract void initData();
}
