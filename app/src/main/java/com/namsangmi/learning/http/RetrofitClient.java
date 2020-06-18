package com.namsangmi.learning.http;

import com.namsangmi.learning.PLApplication;
import com.namsangmi.learning.http.interceptor.AddCookiesInterceptor;
import com.namsangmi.learning.http.interceptor.CacheInterceptor;
import com.namsangmi.learning.http.interceptor.OkHttpRequestInterceptor;
import com.namsangmi.learning.http.interceptor.ReceivedCookiesInterceptor;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>
 * Retrofit请求初始化工具类
 */

public class RetrofitClient {

    private static Retrofit.Builder retrofitBuilder;

    private static String baseUrl = "Constant.serverUrlPrefix";

    private static OkHttpRequestInterceptor requestInterceptor;

    private static CacheInterceptor cacheInterceptor;

    private static Cache cache;

    /**
     * 无参数  实例化
     *
     * @return retrofitBuilder
     */
    public static Retrofit getInstance(Map<String, Object> headerMaps) {

        if (retrofitBuilder == null) {
            retrofitBuilder = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            cacheInterceptor = new CacheInterceptor();
        }
        if (headerMaps != null) {
            requestInterceptor = new OkHttpRequestInterceptor(headerMaps);
        } else {
            requestInterceptor = new OkHttpRequestInterceptor();
        }
        retrofitBuilder.baseUrl(baseUrl).addConverterFactory(ResponseConverterFactory.create()).client(getClient());
        return retrofitBuilder.build();
    }

    /**
     * 有参数实例化
     *
     * @param baseUrl 传入baseUrl
     * @return retrofitBuilder
     */
    public static Retrofit getInstance(String baseUrl, Map<String, Object> headerMaps) {

        if (retrofitBuilder == null) {
            retrofitBuilder = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        }
        if (headerMaps != null) {
            requestInterceptor = new OkHttpRequestInterceptor(headerMaps);
        } else {
            requestInterceptor = new OkHttpRequestInterceptor();
        }
        retrofitBuilder.baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(getClient());

        return retrofitBuilder.build();
    }


    private static File httpCacheDirectory = new File(PLApplication.getInstance().getCacheDir(), "itCache");

    private static int cacheSize = 100 * 1024 * 1024; // 100 MiB


    /**
     * 初始化okHttpClient
     *
     * @return OkHttpClient
     */
    public static OkHttpClient getClient() {
        if (cache == null) {
            cache = new Cache(httpCacheDirectory, cacheSize);
        }

        return new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(cacheInterceptor)
                .addInterceptor(new ReceivedCookiesInterceptor())
                .addInterceptor(new AddCookiesInterceptor())
                .addNetworkInterceptor(cacheInterceptor)
                .cache(cache)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
