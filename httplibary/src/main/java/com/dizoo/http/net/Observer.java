package com.dizoo.http.net;

import retrofit2.Call;
import retrofit2.Response;

public abstract class Observer<T> extends BaseObserver<T> {
    @Override
    void onNext(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response);
        }else {
            onError(response);
        }
    }

    @Override
    void onFail(Call<T> call, Throwable t) {
        onFailure(t);
    }

    public abstract void onSuccess(Response<T> response);
    private void onFailure(Throwable t){}
    private void onError(Response<T> response) {}
}
