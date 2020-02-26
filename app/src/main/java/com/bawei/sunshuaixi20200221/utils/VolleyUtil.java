package com.bawei.sunshuaixi20200221.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.sunshuaixi20200221.base.App;

import java.util.HashMap;
import java.util.Map;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public class VolleyUtil {
    //创建队列
    private final RequestQueue requestQueue;

    //创建无参构造
    private VolleyUtil(){
        this.requestQueue = Volley.newRequestQueue(App.appContext());
        RequestQueue requestQueue = this.requestQueue;
    }
    //创建静态内部类
    private static class Sinleln{
      private static final VolleyUtil INTOCE=  new VolleyUtil();
    }
    //创建静态方法
    public static VolleyUtil getInstance(){
        return Sinleln.INTOCE;
    }
    //创建get请求方法
    public void doGet(String url, final Callack callack){
        //创建stringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callack.success(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callack.faliure(error.getMessage());
            }
        });
        //添加到对列中
        requestQueue.add(stringRequest);
    }
   //创建post请求方法
   public void doPost(String url, final HashMap<String,String> map, final Callack callack){
       //创建stringRequest
       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       callack.success(response);
                   }
               }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               callack.faliure(error.getMessage());
           }
       }){
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               return map;
           }
       };
       //添加到对列中
       requestQueue.add(stringRequest);
   }


        //创建接口
    public interface Callack{
        void success(String str);
        void faliure(String str);
    }
}
