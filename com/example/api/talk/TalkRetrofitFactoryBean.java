package com.example.api.talk;

import com.systex.citizen.core.okhttp.OkHttpClientFactory;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class TalkRetrofitFactoryBean extends AbstractFactoryBean<TalkRetrofit> {

    private String baseURL;

    public TalkRetrofitFactoryBean() {
        this("");
    }

    public TalkRetrofitFactoryBean(final String url) {
        super();
        this.baseURL = url;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Override
    public Class<?> getObjectType() {
        return TalkRetrofit.class;
    }

    @Override
    protected TalkRetrofit createInstance() throws Exception {
        OkHttpClient httpClient = OkHttpClientFactory.create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient);
        return new TalkRetrofit(builder.build());
    }

}
