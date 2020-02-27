package com.bawei.sunshuaixi20200221.model;

import android.util.Log;

import com.bawei.sunshuaixi20200221.contract.IHomeContract;
import com.bawei.sunshuaixi20200221.utils.VolleyUtil;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getList(String url, final MyCallack myCallack) {
        VolleyUtil.getInstance().doGet(url, new VolleyUtil.Callack() {
            @Override
            public void success(String str) {
                Log.i("xxx",str);
                myCallack.onListSuccess(str);
            }

            @Override
            public void faliure(String str) {
                myCallack.onListFailure(str);
            }
        });
    }

    @Override
    public void getBanner(String url, final Callack callack) {
        VolleyUtil.getInstance().doGet(url, new VolleyUtil.Callack() {
            @Override
            public void success(String str) {
                Log.i("xxx",str);
                callack.onXbannerSuccess(str);
            }

            @Override
            public void faliure(String str) {
                callack.onXbannerFailure(str);
            }
        });
    }
}
