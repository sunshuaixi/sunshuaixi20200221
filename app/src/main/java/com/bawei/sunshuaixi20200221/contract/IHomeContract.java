package com.bawei.sunshuaixi20200221.contract;

import com.bawei.sunshuaixi20200221.base.IbaseView;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public interface IHomeContract {
    //创建V层需要实现的接口
    interface IView extends IbaseView {
        void onListSuccess(String str);
        void onListFailure(String str);

        void onXbannerSuccess(String str);
        void onXbannerFailure(String str);
    }

    //创建M层需要实现的接口
    interface IModel{
        void getList(String url,MyCallack myCallack);
        void getBanner(String url,Callack callack);
        interface MyCallack{
            void onListSuccess(String str);
            void onListFailure(String str);
        }
        interface Callack{
            void onXbannerSuccess(String str);
            void onXbannerFailure(String str);
        }
    }
    //创建P层需要实现的接口
    interface IPresenter{
        void getList(String url);
        void getXbanner(String url);
    }
}
