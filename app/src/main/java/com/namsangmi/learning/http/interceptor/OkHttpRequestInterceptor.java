package com.namsangmi.learning.http.interceptor;

import com.namsangmi.learning.BuildConfig;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <p>
 * okHttp请求拦截器
 * 统一添加请求头
 */

public class OkHttpRequestInterceptor implements Interceptor {

    private Map<String, Object> headerMaps = new TreeMap<>();
    public OkHttpRequestInterceptor(Map<String, Object> headerMaps) {
        this.headerMaps = headerMaps;
    }

    public OkHttpRequestInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();
        if (headerMaps == null || headerMaps.size() == 0) {
            request.addHeader("version", BuildConfig.VERSION_NAME)
                    .addHeader("clientType", "0")
                    .addHeader("user-agent", "Geae/" + BuildConfig.VERSION_NAME)
                    .addHeader("x-sourceid", "204006")
                    .addHeader("x-apptype", "3");

        } else {
            for (Map.Entry<String, Object> entry : headerMaps.entrySet()) {
                request.addHeader(entry.getKey(), (String) entry.getValue());
            }
        }
        return chain.proceed(request.build());
    }


}
