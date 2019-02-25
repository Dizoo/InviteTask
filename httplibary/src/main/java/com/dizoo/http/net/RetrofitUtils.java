package com.dizoo.http.net;

import com.dizoo.baselibrary.util.TLog;
import com.dizoo.http.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {


   private static Retrofit getInstance(String url){
       HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
           @Override
           public void log(String message) {
               TLog.d("Retrofit","retrofitBack = "+message);
           }
       });
       logging.setLevel(HttpLoggingInterceptor.Level.BODY);
       OkHttpClient client = new OkHttpClient.Builder()
               .connectTimeout(30, TimeUnit.SECONDS)
               .readTimeout(30, TimeUnit.SECONDS)
               .writeTimeout(30, TimeUnit.SECONDS)
               .addInterceptor(logging)
               .build();
       client.retryOnConnectionFailure ();
       return new Retrofit.Builder()
               .baseUrl(url)
               .client(client)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
   }

   public static ApiService api(){
        return getInstance(BuildConfig.BASE_URL).create(ApiService.class);
   }
}
