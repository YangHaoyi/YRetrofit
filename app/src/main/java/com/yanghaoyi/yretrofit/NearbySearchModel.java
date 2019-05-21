package com.yanghaoyi.yretrofit;

import android.graphics.Point;
import android.util.Log;

import com.yanghaoyi.net.client.ApiClient;
import com.yanghaoyi.net.client.OnGetDataListener;


import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author : YangHaoYi on  2019/3/2115:19.
 * Email  :  yang.haoyi@qq.com
 * Description :周边充电桩数据Model
 * Change : YangHaoYi on  2019/3/2115:19.
 * Version : V 1.0
 */
public class NearbySearchModel {

    private AdvanceAPI api;

    public NearbySearchModel() {
        api =  ApiClient.getInstance().setBaseUrl("https://api.apiopen.top/")
                .init(AdvanceAPI.class);
    }

    public void requestChargeStationList(final OnGetDataListener<NetData> listener){
        Observable<NetData> response = api.getNearbyStation();
        response.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NetData>() {
                    @Override
                    public void onCompleted() {
                        //请求完成
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        Log.w("Model","onError_________"+throwable.getLocalizedMessage());
                        listener.fail(null,"");
                    }
                    @Override
                    public void onNext(NetData netData) {
                        Log.w("Model","onNext_________");
                        listener.success(netData);
                    }
                });
    }

}
