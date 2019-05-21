package com.yanghaoyi.yretrofit;


import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;

/**
 * @author YangHaoyi on 2019/3/4.
 *         Email  : yanghaoyi@qq.com.
 *         Description :请求Api
 *         Change : YangHaoYi on 2019/3/4.
 *         Version :V 1.1
 */
public interface AdvanceAPI {

    String STATION = "CS/p2/zj/station/v1";

    @GET("searchAuthors?name=李白")
    Observable<NetData> getNearbyStation();
}
