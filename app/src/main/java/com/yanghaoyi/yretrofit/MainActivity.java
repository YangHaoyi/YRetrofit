package com.yanghaoyi.yretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanghaoyi.net.client.ApiClient;
import com.yanghaoyi.net.client.OnGetDataListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new NearbySearchModel().requestChargeStationList(new OnGetDataListener<NetData>() {
            @Override
            public void success(NetData response) {

            }

            @Override
            public void fail(NetData response, String msg) {

            }
        });
    }
}
