package com.bawei.sunshuaixi20200221.base;

import java.lang.ref.WeakReference;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public abstract class BasePresenter<V extends IbaseView>{

    //定义全局变量
    private  WeakReference<V> vWeakReference;

    //创建构造方法
    public BasePresenter(V v) {
        vWeakReference = new WeakReference<>(v);

        initModel();
    }

    //创建一个返回M层的方法
    public abstract void initModel();

    //创建一个返回V层的方法
    public V getView(){
        //判空
        if(vWeakReference !=null){
            return vWeakReference.get();
        }
        return null;
    }
    //创建一个解绑的方法
    public void detachView(){
        //判空
        if(vWeakReference!=null){
            //清空
         vWeakReference.clear();
         //置空
            vWeakReference=null;
        }
    }
}
