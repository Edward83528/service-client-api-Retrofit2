package com.example.api.talk;

import retrofit2.Retrofit;

public class TalkRetrofit {

    private final Retrofit retrofit;

    public TalkRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
