package com.example.api.parentchild;

import retrofit2.Retrofit;

public class ParentChildRetrofit {

    private final Retrofit retrofit;

    public ParentChildRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
