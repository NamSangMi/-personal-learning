package com.namsangmi.learning.http.interceptor;

import androidx.annotation.NonNull;
import com.namsangmi.learning.utils.Tools;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络缓存
 */

public class CacheInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        //如果没有网络，则启用 FORCE_CACHE
        if (!Tools.isNetworkConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response originalResponse = chain.proceed(request);
        if (Tools.isNetworkConnected()) {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "no-cache")
                    .removeHeader("Pragma")
                    .build();
        } else {
            int maxAge = 60 * 60 * 24 * 60; // 离线时缓存保存1分
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxAge)
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
