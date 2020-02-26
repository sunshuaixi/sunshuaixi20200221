package com.bawei.sunshuaixi20200221.presenter;

import com.bawei.sunshuaixi20200221.base.BasePresenter;
import com.bawei.sunshuaixi20200221.base.IbaseView;
import com.bawei.sunshuaixi20200221.contract.IHomeContract;
import com.bawei.sunshuaixi20200221.model.HomeModel;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public class HomePresenter extends BasePresenter implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    public HomePresenter(IbaseView ibaseView) {
        super(ibaseView);
    }



    @Override
    public void getList(String url) {
        homeModel.getList(url, new IHomeContract.IModel.MyCallack() {
            @Override
            public void onListSuccess(String str) {
                IbaseView view = getView();
                if(view instanceof IHomeContract.IView){
                    ((IHomeContract.IView) view).onListSuccess(str);
                }
            }

            @Override
            public void onListFailure(String str) {
                IbaseView view = getView();
                if(view instanceof IHomeContract.IView){
                    ((IHomeContract.IView) view).onListFailure(str);
                }
            }
        });
    }

    @Override
    public void getXbanner(String url) {
        homeModel.getBanner(url, new IHomeContract.IModel.Callack() {
            @Override
            public void onXbannerSuccess(String str) {
                IbaseView view = getView();
                if(view instanceof IHomeContract.IView){
                    ((IHomeContract.IView) view).onXbannerSuccess(str);
                }
            }

            @Override
            public void onXbannerFailure(String str) {
                IbaseView view = getView();
                if(view instanceof IHomeContract.IView){
                    ((IHomeContract.IView) view).onXbannerFailure(str);
                }
            }
        });
    }

    @Override
    public void initModel() {
        homeModel = new HomeModel();
    }
}
