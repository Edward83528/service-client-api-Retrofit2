package com.example.api.parentchild;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.SecureRandom;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import javax.net.ssl.*;

/**
 * Retrofit變量初始化
 */
public class ParentChildRetrofitFactoryBean extends AbstractFactoryBean<ParentChildRetrofit> {

    private String BASE_URL;

    public ParentChildRetrofitFactoryBean() {
        this("");
    }

    public ParentChildRetrofitFactoryBean(final String url) {
        super();
        this.BASE_URL = url;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    private static Strategy strategy = new AnnotationStrategy();
    private static Serializer serializer = new Persister(strategy);

    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();


    @Override
    public Class<?> getObjectType() {
        return ParentChildRetrofit.class;
    }

    @Override
    protected ParentChildRetrofit createInstance() throws Exception {

        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Content-Type", "text/xml; charset=utf-8")   // 對於SOAP 1.1， 如果是soap1.2 應是Content-Type: application/soap+xml; charset=utf-8
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        OkHttpClient sClient = new OkHttpClient();
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }

        HostnameVerifier hv1 = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        String workerClassName = "okhttp3.OkHttpClient";
        try {
            Class workerClass = Class.forName(workerClassName);
            Field hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier");
            hostnameVerifier.setAccessible(true);
            hostnameVerifier.set(sClient, hv1);

            Field sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory");
            sslSocketFactory.setAccessible(true);
            sslSocketFactory.set(sClient, sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .client(sClient);
        return new ParentChildRetrofit(builder.build());
    }

}
