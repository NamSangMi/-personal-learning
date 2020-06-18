package com.namsangmi.learning.http.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {
    public static final String TAG = "AddCookiesInterceptor";

    public AddCookiesInterceptor() {
        super();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        //保存Cookie
//        String cookies = CookieManager.getInstance().getCookie(Constant.serverUrlPrefix);
//        if (!StringUtils.isNull(cookies)) {
//            String[] cookie = cookies.split("@");
//            for (String a : cookie) {
//                builder.addHeader("Cookie", a);
//                LogUtil.d(TAG, "Adding Header: " + a);
//            }
//        }
        return chain.proceed(builder.build());
    }
}
