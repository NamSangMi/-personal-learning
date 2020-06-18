package com.namsangmi.learning.http.interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * cookies
 */

public class ReceivedCookiesInterceptor implements Interceptor {

    public ReceivedCookiesInterceptor() {
        super();
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        return chain.proceed(chain.request());

//        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
//            HashSet<String> cookies = new HashSet<>();
//            boolean saveCookies = false;
//            for (String header : originalResponse.headers("Set-Cookie")) {
//                cookies.add(header);
//                if (header.contains("SESSIONID")) {
//                    saveCookies = true;
//                }
//            }
//            if (saveCookies) {
//                StringBuilder saveCookieStrng = new StringBuilder();
//                for (String i : cookies) {
//                    saveCookieStrng.append(i).append("@");
//                }
//                saveCookieStrng.deleteCharAt(saveCookieStrng.length() - 1);
//                StorageUtils.saveConfig4String(context, AddCookiesInterceptor.cookieKey, saveCookieStrng.toString());
//            }
//        }
    }

}
