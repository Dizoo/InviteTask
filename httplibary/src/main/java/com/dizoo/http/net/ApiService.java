package com.dizoo.http.net;

import com.dizoo.http.bean.home.BannerBean;

import retrofit2.Call;
import retrofit2.http.GET;

public  interface ApiService<T> {

    @GET(Urls.BANNER)
    Call<BannerBean> banner();
}
