package com.yanghaoyi.net.client;


import com.yanghaoyi.net.intercepter.LoggingInterceptor;
import com.yanghaoyi.net.intercepter.MyHostnameVerifier;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author YangHaoyi on 2019/3/4.
 *         Email  : yanghaoyi@qq.com.
 *         Description :请求Client
 *         Change : YangHaoYi on 2019/3/4.
 *         Version :V 1.1
 */
public class ApiClient{

    private static final ApiClient instance = new ApiClient();

    public static ApiClient getInstance(){
        return instance;
    }

    /** 请求域名 */
    private String baseUrl = "";
    /** token拦截器 */
    private Interceptor tokenInterceptor;

    public ApiClient setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public ApiClient setTokenInterceptor(Interceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
        return this;
    }

    /** 初始化 */
    public <T> T init(Class<T> tClass){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new LoggingInterceptor());
        okHttpClient.hostnameVerifier(new MyHostnameVerifier());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
