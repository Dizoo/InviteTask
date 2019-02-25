package com.dizoo.http.net;


import com.dizoo.http.bean.home.BannerBean;

import retrofit2.Call;

public class HttpUtils {

    public static Call<BannerBean> banner(){
        return RetrofitUtils.api().banner();
    }


}
